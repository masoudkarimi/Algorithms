package slidingwindow

/**
 * Problem Statement: Fruits into Baskets
 *  Given an array of characters where each character represents a fruit tree,
 *  you are given two baskets, and your goal is to put maximum number of fruits
 *  in each basket. The only restriction is that each basket can have only one
 *  type of fruit.
 *
 *  You can start with any tree, but you can’t skip a tree once you have started.
 *  You will pick one fruit from each tree until you cannot, i.e., you will stop
 *  when you have to pick from a third fruit type.
 *
 *  Write a function to return the maximum number of fruits in both baskets.
 *
 *  Example 1:
 *      Input: Fruit=['A', 'B', 'C', 'A', 'C']
 *      Output: 3
 *      Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * */

object MaxFruitCountOf2Types {
    private const val BASKETS_SIZE = 2

    data class Result(
        val maxLength: Int,
        val resultStartIndex: Int
    )

    fun findAnswer(aar: CharArray): Result {
        var resultStartIndex = 0
        var windowStart = 0
        var maxLength = 0
        val fruitFrequencyMap = HashMap<Char, Int>()
        for (windowEnd in aar.indices) {
            val rightChar = aar[windowEnd]
            fruitFrequencyMap[rightChar] = fruitFrequencyMap.getOrDefault(rightChar, 0) + 1

            while (fruitFrequencyMap.size > BASKETS_SIZE) {
                val leftChar = aar[windowStart]
                fruitFrequencyMap[leftChar] = fruitFrequencyMap[leftChar]!! - 1
                if (fruitFrequencyMap[leftChar] == 0) {
                    fruitFrequencyMap.remove(leftChar)
                }
                windowStart++
            }

            val currentWindowSize = windowEnd - windowStart + 1

            if (currentWindowSize > maxLength) {
                maxLength = currentWindowSize

                // also update the result start index
                resultStartIndex = windowStart
            }
        }

        return Result(
            maxLength,
            resultStartIndex
        )
    }
}

fun main() {
    val fruits = charArrayOf('A', 'B', 'C', 'A', 'C')
    val result = MaxFruitCountOf2Types.findAnswer(fruits)
    print("Result for fruits: ${result.maxLength}, ${String(fruits, result.resultStartIndex, result.maxLength).toList()}")
}