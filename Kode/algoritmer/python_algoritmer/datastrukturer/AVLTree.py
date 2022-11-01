import math

class AVL:
    """AVL-tree class containing subclass and methods"""
    def __init__(self):
        self.root = None

    class Node:
        """Node class containing data and children-pointers"""
        def __init__(self, data):
            self.data = data
            self.height = 0
            self.left = None
            self.right = None

    def leftRotate(self, node):
        """Performs a left-rotate of node and subtree"""
        right_child = node.right
        right_child_left = right_child.left

        right_child.left = node
        node.right = right_child_left

        node.height = 1 + max(self.height(node.left), self.height(node.right))
        right_child.height = 1 + max(self.height(right_child.left), self.height(right_child.right))

        return right_child

    def rightRotate(self, node):
        """Performs a right-rotate of node and subtree"""
        left_child = node.left
        left_child_right = left_child.right

        left_child.right = node
        node.left = left_child_right

        node.height = 1 + max(self.height(node.left), self.height(node.right))
        left_child.height = 1 + max(self.height(left_child.left), self.height(left_child.right))

        return left_child

    def balance(self, node):
        """Balances tree based on balancefactor of current node"""
        # høyretung
        if self.balanceFactor(node) < -1:
            if self.balanceFactor(node.right) > 0:
                node.right = self.rightRotate(node.right)
            return self.leftRotate(node)

        # venstretung
        if self.balanceFactor(node) > 1:
            if self.balanceFactor(node.left) < 0:
                node.left = self.leftRotate(node.left)
            return self.rightRotate(node)

        return node

    # inserting - start
    def insert(self, *args):
        """Inserts element(s) in tree"""
        for arg in args:
            self.root = self.balance_insert(self.root, arg)

    def balance_insert(self, node, element):
        if node is None:
            node = self.Node(element)

        elif element < node.data:
            node.left = self.balance_insert(node.left, element)

        elif element > node.data:
            node.right = self.balance_insert(node.right, element)

        node.height = 1 + max(self.height(node.left), self.height(node.right))
        return self.balance(node)

    # insert - end

    # remove - start
    def remove(self, element):
        """Removes node with given element from tree"""
        self.root = self.balance_remove(self.root, element)

    def balance_remove(self, node, element):
        if node is None:
            return None

        if element < node.data:
            node.left = self.balance_remove(node.left, element)

        elif element > node.data:
            node.right = self.balance_remove(node.right, element)

        # case 2: har kun 1-barnenode
        elif node.left is None:
            node = node.right

        elif node.right is None:
            node = node.left

        # case 3: har begge barnenoder
        else:
            lowest = self.findMin(node.right)
            node.data = lowest.data
            node.height = 1 + max(self.height(node.left), self.height(node.right))

        return self.balance(node)

    # remove - end

    # contains
    def contains(self, element):
        """Looks for element in node"""
        return self.balance_contains(self.root, element)

    def balance_contains(self, node, element):
        if node is None:
            return False

        if element < node.data:
            return self.balance_contains(node.left, element)

        if element > node.data:
            return self.balance_contains(node.right, element)

        return True

    # hjelpemetoder

    def balanceFactor(self, node):
        """Finds balance factor of node
        Used to determined if left-heavy or right-heavy
        """
        if node is None:
            return 0
        return self.height(node.left) - self.height(node.right)

    def height(self, node):
        """Finds height of tree"""
        if node is None:
            return 0
        return max(self.height(node.left), self.height(node.right)) + 1

    def findMin(self, node):
        """Finds the lowest node by traversing to left-children"""
        if node is None or node.left is None:
            return node
        return self.findMin(node.left)

    def findMax(self, node):
        """Finds the highest node by traversing to right-children"""
        if node is None or node.right is None:
            return node
        return self.findMax(node.right)

    # traversering

    # inorder - start
    def inorder(self):
        """Prints the AVL-tree inorder - Left-Root-Right of tree"""
        self.print_inorder(self.root)

    def print_inorder(self, node):
        if node is None: return
        self.print_inorder(node.left)
        if node.data == self.root.data: print("[", node.data, "]", end=" ")
        else: print(node.data, end=" ")
        self.print_inorder(node.right)
    # inorder - end

    # postorder - start
    def postorder(self):
        """Prints the AVL-tree postorder - Left-Right-Root of tree"""
        self.print_postorder(self.root)

    def print_postorder(self, node):
        if node is None: return
        self.print_postorder(node.left)
        self.print_postorder(node.right)
        if node.data == self.root.data: print("[", node.data, "]", end=" ")
        else: print(node.data, end=" ")
    # postorder - end

    # preorder - start
    def preorder(self):
        """Prints the AVL-tree preorder - Root-Left-Right of tree"""
        self.print_preorder(self.root)

    def print_preorder(self, node):
        if node is None: return
        if node.data == self.root.data: print("[", node.data, "]", end=" ")
        else: print(node.data, end=" ")
        self.print_preorder(node.left)
        self.print_preorder(node.right)
    # preorder - end

    def print(self):
        print("\n")
        lines = []
        level = []
        next = []

        level.append(self.root)
        nn = 1
        widest = 0

        while nn != 0:
            line = []

            nn = 0

            for node in level:
                if node is None:
                    line.append(None)
                    next.append(None)
                    next.append(None)
                else:
                    aa = str(node.data)
                    line.append(aa)
                    if len(aa) > widest: widest = len(aa)

                    next.append(node.left)
                    next.append(node.right)

                    if node.left is not None: nn += 1
                    if node.right is not None: nn += 1

            if widest % 2 == 1: widest += 1

            lines.append(line)

            tmp = level
            level = next
            next = tmp
            next.clear()

        perpiece: int = len(lines[len(lines) - 1]) * (widest + 4)
        for i in range(len(lines)):
            line = lines[i]
            hpw: int = math.floor(perpiece / 2.0) - 1

            if i > 0:
                for j in range(len(line)):
                    c = ' '
                    if j % 2 == 1:
                        if line[j - 1] is not None:
                            c = '┴' if line[j] is not None else '┘'
                        else:
                            if line[j] is not None:
                                c = '└'
                    print(c, end="")

                    if line[j] is None:
                        for k in range(len(perpiece) - 1):
                            print(" ", end="")
                    else:
                        for k in range(hpw):
                            print(" " if j % 2 == 0 else "─", end="")
                        print("┌" if j % 2 == 0 else "┐", end="")
                        for k in range(hpw):
                            print("─" if j % 2 == 0 else " ", end="")

                print()

            for f in line:
                if f is None: f = ""
                gap1: int = math.ceil(perpiece / 2.0 - len(f) / 2.0)
                gap2: int = math.floor(perpiece / 2.0 - len(f) / 2.0)

                for k in range(gap1):
                    print(" ", end="")
                print(f, end="")
                for k in range(gap2):
                    print(" ", end="")

            print()
            perpiece /= 2



# printing
t = AVL()
t.insert(1, 6, 9, 2, 3, -1, -3)

print("3: ", t.contains(3))
print("12: ", t.contains(12))
print("7: ", t.contains(7))

print("\nRoot of tree:", t.root.data)
print("\n-- Printing inorder --")
t.inorder()
print("\n\n-- Printing postorder  --")
t.postorder()
print("\n\n-- Printing preorder --")
t.preorder()
t.print()
