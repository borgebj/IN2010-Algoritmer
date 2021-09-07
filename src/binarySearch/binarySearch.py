

# fyller liste med tall fra start til slutt
start = 0
slutt = 100
list = []
for x in range(start, slutt):
    list.append(x)

print(list)

finne = 41
print("Skal finne tallet:", finne)



# simple search

print("\nSimple search")
def simpleSearch(A, x):
    for i in A:
        if A[i] == x:
            return True
    return False


print("fant tall: ", simpleSearch(list, finne))

# binærsøk

print("\nBinary search")
def binarySearch(A, x):
    low = 0
    high = len(A)

    while low <= high:
        mid = int((low + high)/2)

        if A[mid] == x:
            return True

        elif A[mid] < x:
            low = mid + 1

        elif A[mid] > x:
            high = mid - 1

    return False


print("Fant tall: ", binarySearch(list, finne))