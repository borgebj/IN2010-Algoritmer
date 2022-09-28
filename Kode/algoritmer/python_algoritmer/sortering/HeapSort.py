import random
import time


# Heap Sort
# O-notasjon: O(n log(n))
# konklusjon: Ekstremt rask


def createList(size):
    lst = []
    for n in range(size):
        lst.append(n)

    # shuffler
    for i in range(len(lst)):
        j = random.randint(0, len(lst) - 1)
        element = lst.pop(j)
        lst.append(element)

    print("< Heap Sort >")
    print("--------------------------------------")
    return lst


def bubbleDown(lst, i, n):
    largest = i
    left = 2*i + 1
    right = 2*i + 2

    if left < n and lst[largest] < lst[left]:
        largest, left = left, largest

    if right < n and lst[largest] < lst[right]:
        largest, right = right, largest

    if i != largest:
        lst[i], lst[largest] = lst[largest], lst[i]
        bubbleDown(lst, largest, n)


def BuildMaxHeap(lst, n):
    for i in range(n//2, -1, -1):
        bubbleDown(lst, i, n)


def heapSort(lst):
    n = len(lst)
    BuildMaxHeap(lst, n)
    for i in range(n-1, -1, -1):
        lst[0], lst[i] = lst[i], lst[0]
        bubbleDown(lst, 0, i)


def heapSortTimer(lst):
    start = time.process_time()
    heapSort(lst)
    print("\ntid:", float(time.process_time() - start), "s")


def main():
    size = 10
    lst = createList(size)
    print("Size:", size)
    print("unosorted", lst)
    heapSortTimer(lst)
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
# - 0.125 s

# 20 000 elementer
# - 0.20 s

# 50 000 elementer
# - 0.65 s

# 100 000 elementer
# - 1.5 s
