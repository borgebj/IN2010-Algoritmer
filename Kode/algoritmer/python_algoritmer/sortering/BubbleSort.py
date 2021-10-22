import random
import time


# BubbleSort
# O-notasjon: O(n^2)


def createList(size):
    lst = []
    for n in range(size):
        lst.append(n)

    # shuffler
    for i in range(len(lst)):
        j = random.randint(0, len(lst) - 1)
        element = lst.pop(j)
        lst.append(element)

    print("< Bubble Sort >")
    print("--------------------------------------")
    return lst


def bubbleSort(lst):
    start = time.process_time()
    ##################################################
    for i in range(len(lst) - 1):
        for j in range(len(lst) - i - 1):
            if lst[j] > lst[j + 1]:
                lst[j], lst[j + 1] = lst[j + 1], lst[j]
    ##################################################
    print("\ntid:", float(time.process_time() - start), "s")


def main():
    size = 20000
    lst = createList(size)
    print("Size:", size)
    print("unosorted", lst)
    bubbleSort(lst)
    print("sorted", lst)


main()

# tid (ish):
# 100 elementer
# - 0.0 s

# 500 elementer
# - 0.031 s

# 1000 elementer
# - 0.14 s

# 5000 elementer
# - 3.46 s

# 10 000 elementer
# - 13.21 s

# 20 000 elementer
# - 55.32 s
