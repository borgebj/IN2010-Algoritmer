package binarySearch

fun main() {
    val list = mutableListOf<Int>()
    for (i in 0..150) {
        list.add(i)
    }
    val tall = 49

    // Simple search
    println("Simple search:")
    val simpleResult = simpleSearch(list, tall)
    println("Fant tall: $simpleResult")

    // binary search
    println("\nBinary search:")
    val binaryResult = binarySearch(list, tall)
    println("Fant tall: $binaryResult")
}

fun simpleSearch(A: List<Int>, x: Int): Boolean {
    for (i in A.indices) {
        if (A[i] == x)
            return true
    }
    return false
}

fun binarySearch(A: List<Int>, x: Int): Boolean {
    var low = 0
    var high = A.size-1

    while (low <= high) {
        val mid = (low+high)/2

        if(A[mid] == x)
            return true

        else if (A[mid] < x)
            low = mid + 1

        else if (A[mid] > x)
            high = mid - 1
    }
    return false
}