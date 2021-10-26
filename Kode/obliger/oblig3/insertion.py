

# region Insertion-Sort
def sort(lst):
    for i in range(len(lst)):
        j = i

        while j > 0 and lst[j - 1] > lst[j]:
            # lst[j - 1], lst[j] = lst[j], lst[j - 1]
            lst.swap(j - 1, j)
            j = j - 1

    return lst
# endregion
