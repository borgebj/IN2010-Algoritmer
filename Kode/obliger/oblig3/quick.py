import statistics


# region Quick-Sort
def medianOfThree(lst, low, high):
    first = lst[low]
    middle = lst[len(lst) // 2]
    last = lst[high]

    pivot = statistics.median([first, middle, last])

    return lst.index(pivot)


def partition(lst, low, high):
    p = medianOfThree(lst, low, high)
    lst.swap(p, high)
    pivot = lst[high]
    left = low
    right = high - 1

    while left <= right:
        while left <= right and lst[left] <= pivot:
            left = left + 1

        while right >= left and lst[right] >= pivot:
            right = right - 1

        if left < right:
            lst.swap(left, right)

    lst.swap(left, high)
    return left


def quicksort(lst, low, high):
    if low >= high:
        return lst

    p = partition(lst, low, high)
    quicksort(lst, low, p - 1)
    quicksort(lst, p + 1, high)

    return lst


def sort(lst):
    n = len(lst)
    low = 0
    high = n - 1
    return quicksort(lst, low, high)
# endregion
