
def Insert(A, x):
    n = len(A)-1
    A[n] = x
    i = n
    while 0 < i and A[i] < A[(i-1)/2]:
        A[i], A[(i-1)/2] = A[(i-1)/2], A[i]
        i = [(i-1)/2]


def RemoveMin(A):
    n = len(A)
    x = A[0]
    A[0] = A[n-1]
    i = 0
    while (2*i)+1 < n-1:
        if A[(2*i)+1] <= A[(2*i)+2]:
            j = (2*i)+1
        else:
            j = (2*i)+2
        if A[j] <= A[i]:
            A[i], A[j] = A[j], A[i]
            i = j
    if (2*i)+1 < n-1 and A[(2*i)+1] <= A[i]:
        A[i], A[(2*i)+1] = A[(2*i)+1], A[i]
    return x