

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
        lst[i], lst[largest] = lst[largest], lst[i]
        bubbleDown(lst, largest, n)


def BuildMaxHeap(lst, n):
    for i in range(n // 2, 0, -1):
        bubbleDown(lst, i, n)


def sort(lst):
    n = len(lst)
    BuildMaxHeap(lst, n)

    for i in range(n - 1, 0, -1):
        lst[0], lst[i] = lst[i], lst[0]
        bubbleDown(lst, 0, i)
    return lst
# endregion
