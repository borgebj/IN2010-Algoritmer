class Node:
    def __init__(self, element):
        self.element = element
        self.left = None
        self.right = None


def preorder(v):
    if not v:
        return
    print(v.element, " - ")
    preorder(v.left)
    preorder(v.right)


def postorder(v):
    if not v:
        return
    postorder(v.left)
    postorder(v.right)
    print(v.element, " - ")


def inorder(v):
    if not v:
        return
    inorder(v.left)
    print(v.element, " - ")
    inorder(v.right)


def Insert(v, x):
    if not v:
        v = Node(x)
    elif x < v.element:
        v.left = Insert(v.left, x)
    elif x > v.element:
        v.right = Insert(v.right, x)

    return v


def Search(v, x):
    if not v:
        return None
    elif v.element == x:
        return v
    elif x < v.element:
        Search(v.left, x)
    elif x > v.element:
        Search(v.right, x)


def findMin(v):
    if v.left is None:
        return v
    return findMin(v.left)


def Remove(v, x):
    if not v:
        return None
    elif x < v.element:
        v.left = Remove(v.left, x)
        return v
    elif x > v.element:
        v.right = Remove(v.right, x)
    elif v.left is None:
        return v.right
    elif v.right is None:
        return v.left
    u = findMin(v.right)
    v.element = u.element
    v.right = Remove(v.right, u.element)
    return v