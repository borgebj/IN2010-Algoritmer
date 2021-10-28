

# region Bubble-Sort
def sort(lst):
    for i in range(len(lst) - 1):
        for j in range(len(lst) - i - 1):
            if lst[j] > lst[j + 1]:
                lst.swap(j+1, j)
    return lst
# endregion
