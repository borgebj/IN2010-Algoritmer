class Node:
    def __init__(self, element):
        self.element = element
        self.left = None
        self.right = None
        self.height = None


def Height(v):
    if v is None:
        return 0
    return max(Height(v.left), Height(v.right)) + 1

def findMin(v):
    if v.left is None:
        return v
    return findMin(v.left)


def LeftRotate(z):
    y = z.right
    t1 = y.left

    y.left = z
    z.right = t1

    z.height = 1 + max(Height(z.left), Height(z.right))
    y.height = 1 + max(Height(y.left), Height(y.right))

    # ny rot y
    return y


def RightRotate(z):
    y = z.left
    t2 = y.right

    y.right = z
    z.left = t2

    z.height = 1 + max(Height(z.left), Height(z.right))
    y.height = 1 + max(Height(z.left), Height(z.right))

    return y


def BalanceFactor(v):
    if v is None:
        return 0
    return Height(v.left) - Height(v.right)


def Balance(v):
    # høyre-tung
    if BalanceFactor(v) < -1:
        if BalanceFactor(v.right) > 0:
            v.right = RightRotate(v.right)
        return LeftRotate(v)

    # venstre-tung
    if BalanceFactor(v) > 1:
        if BalanceFactor(v.left) < 0:
            v.left = LeftRotate(v.left)
        return RightRotate(v)

    return v


def Insert(v, x):
    if v is None:
        v = Node(x)
    elif x < v.element:
        v.left = Insert(v.left, x)
    elif x > v.element:
        v.right = Insert(v.right, x)

    v.height = 1 + max(Height(v.left), Height(v.right))
    return Balance(v)


def Remove(v, x):
    if v is None:
        return None
    if x < v.element:
        v.left = Remove(v.left, x)
    elif x > v.element:
        v.right = Remove(v.right, x)
    elif v.left is None:
        v = v.right
    elif v.right is None:
        v = v.left
    else:
        u = findMin(v.right)
        v.element = u.element
        v.right = Remove(v.right, u.element)
    v.height = 1 + max(Height(v.left), Height(v.right))
    return Balance(v)
