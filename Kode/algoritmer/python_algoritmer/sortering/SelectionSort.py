import random
import time


# Selection Sort
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

    print("< Selection Sort >")
    print("--------------------------------------")
    return lst


def selectionSort(lst):
    start = time.process_time()
    ##################################################
    for i in range(len(lst)):
        min_indx = i
        for j in range(i + 1, len(lst)):
            if lst[j] < lst[min_indx]:
                min_indx = j

        if i != min_indx:
            lst[i], lst[min_indx] = lst[min_indx], lst[i]
    ##################################################
    print("\ntid:", float(time.process_time() - start), "s")


def main():
    size = 20000
    lst = createList(size)
    print("Size:", size)
    print("unosorted", lst)
    selectionSort(lst)
    print("sorted", lst)


main()

# tid (ish):
# 100 elementer
# - 0.0 s

# 500 elementer
# - 0.015 s

# 1000 elementer
# - 0.062

# 5000 elementer
# - 1.64 s

# 10 000 elementer
# - 6.5 s

# 20 000 elementer
# - 26.73 s
