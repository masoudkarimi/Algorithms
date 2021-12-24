package slidingwindow

import java.lang.IllegalArgumentException
import kotlin.math.max

/**
 * Problem: Longest Substring with K Distinct Characters
 * Problem Statement:
 *      Given a string, find the length of the longest substring in
 *      it with no more than K distinct characters.
 *      You can assume that K is less than or equal to the length of
 *      the given string.
 *
 * Example 1:
 *       Input: String="araaci", K=2
 *       Output: 4
 *       Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * */
object LongestSubstringKDistinct {

    data class Answer(
        val maxLength: Int,
        val answers: List<String>
    )

    fun findAnswer(str: String, k: Int): Answer {
        if (str.isEmpty() || str.length < k) {
            throw IllegalArgumentException()
        }

        var answers = mutableListOf<String>()
        var windowStart = 0
        var maxLength = 0
        val charFrequentMap = HashMap<Char, Int>()
        for (windowEnd in str.indices) {
            val rightChar = str[windowEnd]
            charFrequentMap[rightChar] = charFrequentMap.getOrDefault(rightChar, 0) + 1

            while (charFrequentMap.size > k) {
                val leftChar = str[windowStart]
                charFrequentMap[leftChar] = charFrequentMap[leftChar]!! - 1
                if (charFrequentMap[leftChar] == 0) {
                    charFrequentMap.remove(leftChar)
                }
                windowStart++
            }

            val currentWindowSize = windowEnd - windowStart + 1
            maxLength = max(maxLength, currentWindowSize)

            if (answers.isNotEmpty() && currentWindowSize > answers.first().length) {
                answers.clear()
            }

            if (answers.isEmpty() || currentWindowSize >= answers.first().length) {
                answers.add(str.substring(windowStart, windowEnd + 1))
            }
        }

        return Answer(
            maxLength,
            answers
        )
    }

}

fun main() {
    val str1 = "araaci"
    val k1 = 2
    println(
        "Answer of the longest substring for $str1 with k = $k1: "
                + LongestSubstringKDistinct.findAnswer(str1, k1)
    )


    val str2 = "cbbebi"
    val k2 = 3
    println(
        "Answer of the longest substring for $str2 with k = $k2: "
                + LongestSubstringKDistinct.findAnswer(str2, k2)
    )
}