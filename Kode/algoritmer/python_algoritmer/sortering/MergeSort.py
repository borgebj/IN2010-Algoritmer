import random
import time


# Merge Sort
# O-notasjon: O(n log(n))
# konklusjon: veldig rask! raskere enn Heapsort?!


def createList(size):
    lst = []
    for n in range(size):
        lst.append(n)

    # shuffler
    for i in range(len(lst)):
        j = random.randint(0, len(lst) - 1)
        element = lst.pop(j)
        lst.append(element)

    print("< Merge Sort >")
    print("--------------------------------------")
    return lst


def merge(a, b, lst):
    j = 0
    i = 0

    while i < len(a) and j < len(b):
        if a[i] < b[j]:
            lst[i + j] = a[i]
            i = i + 1
        else:
            lst[i + j] = b[j]
            j = j + 1

    while i < len(a):
        lst[i + j] = a[i]
        i = i + 1

    while j < len(b):
        lst[i + j] = b[j]
        j = j + 1

    return lst


def mergeSort(lst):
    n = len(lst)
    if n <= 1:
        return lst

    i = n // 2
    a = mergeSort(lst[0:i])  # 0 til i
    b = mergeSort(lst[i:n])  # i til n

    return merge(a, b, lst)


def mergeSortTimer(lst):
    start = time.process_time()
    mergeSort(lst)
    print("\ntid:", float(time.process_time() - start), "s")


def main():
    size = 100000
    lst = createList(size)
    print("Size:", size)
    print("unosorted", lst)
    mergeSortTimer(lst)
    print("sorted", lst)


main()

# tid (ish):
# 100 elementer
# - 0.0 s

# 500 elementer
# - 0.0 s

# 1000 elementer
# - 0.015 s

# 5000 elementer
# - 0.031 s

# 10 000 elementer
# - 0.062 s

# 20 000 elementer
# - 0.156 s

# 50 000 elementer
# - 0.35 s

# 100 000 elementer
# - 0.78 s
