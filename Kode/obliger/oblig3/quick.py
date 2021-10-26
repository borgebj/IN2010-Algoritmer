import statistics


# region Quick-Sort
def choosePivot(lst, low, high):
    first = low
    middle = lst[len(lst) // 2]
    last = high
    print(statistics.median[first, middle, last])
    return statistics.median([first, middle, last])


def partition(lst, low, high):
    p = choosePivot(lst, low, high)
    # lst[p], lst[high] = lst[high], lst[p]
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
            # lst[left], lst[right] = lst[right], lst[left]
            lst.swap(left, right)

    # lst[left], lst[high] = lst[high], lst[left]
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
    print(lst)
    low = 0
    high = len(lst) - 1
    return quicksort(lst, low, high)
# endregion
