package selection

import kotlin.random.Random

/**
 * Introduction to Algorithms, Page 29, Exercise 2.2-2
 * Consider sorting n numbers sorted in array A by first finding the smallest element of A and exchanging it with the
 * element A[1]. Then find the second smallest element of A, and exchange  it with A[2]. Continue in this  manner for
 * the first n-1 elements
 *
 * ******** Pseudocode *********
 *
 *      // Indices started from 1
 *      for j=1 to A.length - 1
 *          minIndex = j
 *          for i = j+1 to A.length
 *              // finding the next min and exchanging it
 *              if A[i] < A[minIndex]
 *                  minIndex = i
 *          swap A[j] , A[minIndex]
 *
 *
 * ****** Loop invariant ********
 * 1- Initialization: At the start of each iteration of for loop, the subarray A[0-j] consists some of items in original
 *    array but in sorted order.
 *
 * 2- Maintenance: In each iteration, before iteration we have the sorted subarray A[0-j], and just before the next
 *    iteration we have the sorted subarray A[0- j+1]
 *
 * 3- Termination: When the loop terminates, the invariant gives us a useful property that helps show that the algorithm
 *    is correct. In this algorithm when the loop terminates we have a sorted subarray A[0 - j]
 *
 * */

fun selectionSort(array: Array<Int>) {
    // from 0 to n - 2, because the last element sorted after sorting the n-1 items
    for (j in 0 until array.lastIndex) {
        var minIndex = j

        for (i in (j+1) until array.size) {
            if (array[i] < array[minIndex]) {
                minIndex = i
            }
        }

        // swap a[]
        array[j] = array[minIndex].also { array[minIndex] = array[j] }

    }
}

fun main() {
    val array = Array(15) { Random.nextInt(0, 50) }
    println(array.toList())
    selectionSort(array)
    println(array.toList())
}