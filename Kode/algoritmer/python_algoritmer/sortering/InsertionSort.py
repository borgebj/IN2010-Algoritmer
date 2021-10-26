import random
import time


# Insertion Sort
# O-notasjon: O(n^2)
# konklusjon: ish som selection?, raskest for småe


def createList(size):
    lst = []
    for n in range(size):
        lst.append(n)

    # shuffler
    for i in range(len(lst)):
        j = random.randint(0, len(lst) - 1)
        element = lst.pop(j)
        lst.append(element)

    print("< Insertion Sort >")
    print("--------------------------------------")
    return lst


def insertionSort(lst):
    for i in range(len(lst)):
        j = i
        while j > 0 and lst[j-1] > lst[j]:
            lst[j-1], lst[j] = lst[j], lst[j-1]
            j = j - 1


def insertionSortTimer(lst):
    start = time.process_time()
    insertionSort(lst)
    print("\ntid:", float(time.process_time() - start), "s")


def main():
    size = 20000
    lst = createList(size)
    print("Size:", size)
    print("unosorted", lst)
    insertionSortTimer(lst)
    print("sorted", lst)


main()

# tid (ish):
# 100 elementer
# - 0.0 s

# 500 elementer
# - 0.015 s

# 1000 elementer
# - 0.10 s

# 5000 elementer
# - 2.8 s

# 10 000 elementer
# - 11.0 s

# 20 000 elementer
# - 49.0 s

