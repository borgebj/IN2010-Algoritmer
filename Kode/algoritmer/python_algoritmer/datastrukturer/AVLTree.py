class AVL:
    def __init__(self):
        self.root = None

    class Node:
        def __init__(self, x):
            self.x = x
            self.height = 0
            self.left = None
            self.right = None

    def leftRotate(self, z):
        y = z.right
        t1 = y.left

        y.left = z
        z.right = t1

        z.height = 1 + max(self.height(z.left), self.height(z.right))
        y.height = 1 + max(self.height(y.left), self.height(y.right))

        return y

    def rightRotate(self, z):
        y = z.left
        t2 = y.right

        y.right = z
        z.left = t2

        z.height = 1 + max(self.height(z.left), self.height(z.right))
        y.height = 1 + max(self.height(y.left), self.height(y.right))

        return y

    def balance(self, v):
        # høyretung
        if self.balanceFactor(v) < -1:
            if self.balanceFactor(v.right) > 0:
                v.right = self.rightRotate(v.right)
            return self.leftRotate(v)

        # venstretung
        if self.balanceFactor(v) > 1:
            if self.balanceFactor(v.left) < 0:
                v.left = self.leftRotate(v.left)
            return self.rightRotate(v)

        return v

    # inserting - start
    def insert(self, *args):
        for arg in args:
            self.root = self.balance_insert(self.root, arg)

    def balance_insert(self, v, x):
        if v is None:
            v = self.Node(x)

        elif x < v.x:
            v.left = self.balance_insert(v.left, x)

        elif x > v.x:
            v.right = self.balance_insert(v.right, x)

        v.height = 1 + max(self.height(v.left), self.height(v.right))
        return self.balance(v)

    # insert - end

    # remove - start
    def remove(self, x):
        self.root = self.balance_remove(self.root, x)

    def balance_remove(self, v, x):
        if v is None:
            return None

        if x < v.x:
            v.left = self.balance_remove(v.left, x)

        elif x > v.x:
            v.right = self.balance_remove(v.right, x)

        # case 2: har kun 1-barnenode
        elif v.left is None:
            v = v.right

        elif v.right is None:
            v = v.left

        # case 3: har begge barnenoder
        else:
            u = self.findMin(v.right)
            v.x = u.x
            v.height = 1 + max(self.height(v.left), self.height(v.right))

        return self.balance(v)

    # remove - end

    # contains
    def contains(self, x):
        return self.balance_contains(self.root, x)

    def balance_contains(self, v, x):
        if v is None:
            return False

        if x < v.x:
            return self.balance_contains(v.left, x)

        if x > v.x:
            return self.balance_contains(v.right, x)

        return True

    # hjelpemetoder

    def balanceFactor(self, v):
        if v is None:
            return 0
        return self.height(v.left) - self.height(v.right)

    def height(self, v):
        if v is None:
            return 0
        return max(self.height(v.left), self.height(v.right)) + 1

    def findMin(self, v):
        if v is None or v.left is None:
            return v
        return self.findMin(v.left)

    def findMax(self, v):
        if v is None or v.right is None:
            return v
        return self.findMin(v.right)

    # traversering

    # inorder - start
    def inorder(self):
        self.print_inorder(self.root)

    def print_inorder(self, v):
        if v is None: return
        self.print_inorder(v.left)
        print(v.x, end=" ")
        self.print_inorder(v.right)
    # inorder - end

    # postorder - start
    def postorder(self):
        self.print_postorder(self.root)

    def print_postorder(self, v):
        if v is None: return
        self.print_postorder(v.left)
        self.print_postorder(v.right)
        print(v.x, end=" ")
    # postorder - end

    # preorder - start
    def preorder(self):
        self.print_preorder(self.root)

    def print_preorder(self, v):
        if v is None: return
        print(v.x, end=" ")
        self.print_preorder(v.left)
        self.print_preorder(v.right)
    # preorder - end


# printing
t = AVL()
t.insert(5, 8, 10, 9, 7, 6)
t.insert(2, 1, 0, -1, 11, 13, 16)

print("3: ", t.contains(3))
print("12: ", t.contains(12))
print("7: ", t.contains(7))

print("\nFjerner 3 og 7")
t.remove(3)
t.remove(7)
print("3: ", t.contains(3))
print("12: ", t.contains(12))
print("7: ", t.contains(7))

print("\n\n-- Printing inorder --")
t.inorder()
print("\n\n-- Printing postorder  --")
t.postorder()
print("\n\n-- Printing preorder --")
t.preorder()