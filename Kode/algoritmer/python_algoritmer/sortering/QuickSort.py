import random
import time
import statistics


# Quick Sort
# O-notasjon: O(n log(n))
# konklusjon:


def createList(size):
    lst = []
    for n in range(size):
        lst.append(n)

    # shuffler
    for i in range(len(lst)):
        j = random.randint(0, len(lst) - 1)
        element = lst.pop(j)
        lst.append(element)

    print("< Quick Sort >")
    print("--------------------------------------")
    return lst


def choosePivot(lst, low, high):
    first = low
    middle = lst[len(lst) // 2]
    last = high
    return statistics.median([first, middle, last])


def partition(lst, low, high):
    p = choosePivot(lst, low, high)
    lst[p], lst[high] = lst[high], lst[p]
    pivot = lst[high]
    left = low
    right = high - 1

    while left <= right:
        while left <= right and lst[left] <= pivot:
            left = left + 1

        while right >= left and lst[right] >= pivot:
            right = right - 1

        if left < right:
            lst[left], lst[right] = lst[right], lst[left]

    lst[left], lst[high] = lst[high], lst[left]
    return left


def quickSort(lst, low, high):
    if low >= high:
        return lst

    p = partition(lst, low, high)
    quickSort(lst, low, p - 1)
    quickSort(lst, p + 1, high)

    return lst


def quickSortTimer(lst, low, high):
    start = time.process_time()
    quickSort(lst, low, high)
    print("\ntid:", float(time.process_time() - start), "s")


def main():
    size = 500000
    lst = createList(size)
    print("Size:", size)
    # print("unosorted", lst)
    quickSortTimer(lst, 0, len(lst)-1)
    # print("sorted", lst)


main()

# testet på laptop! ikke stasjonær (kan være raskere)
# tid (ish):
# 100 elementer
# - 0.0 s

# 500 elementer
# - 0.015 s

# 1000 elementer
# - 0.0 s - 0.015 s

# 5000 elementer
# - 0.3 s - 0.062 s

# 10 000 elementer
# - 0.08 s - 0.15 s

# 20 000 elementer
# - 0.17 s - 0.25 s

# 50 000 elementer
# - 0.5 s - 0.6 s

# 100 000 elementer
# - 1.0 s - 1.125 s

# 200 000 elementer
# - 1.625 s - 1.95 s

# 500 000 elementer
# - 4.9s - 8.9 s
