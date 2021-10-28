

# region Heap-Sort
def bubbleDown(lst, i, n):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and lst[largest] < lst[left]:
        largest, left = left, largest

    if right < n and lst[largest] < lst[right]:
        largest, right = right, largest

    if i != largest:
        lst.swap(i, largest)
        bubbleDown(lst, largest, n)


def BuildMaxHeap(lst, n):
    for i in range(n // 2, -1, -1):
        bubbleDown(lst, i, n)


def sort(lst):
    n = len(lst)
    BuildMaxHeap(lst, n)

    for i in range(n - 1, 0, -1):
        lst.swap(0, i)
        bubbleDown(lst, 0, i)
    return lst
# endregion
