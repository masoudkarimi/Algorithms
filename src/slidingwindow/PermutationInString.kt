package slidingwindow

/**
 * Problem Statement: Permutation in a String
 *  Given a string and a pattern, find out if the string contains any permutation of the pattern.
 *  Permutation is defined as the re-arranging of the characters of the string.
 *  For example, “abc” has the following six permutations:
 *  1. abc
 *  2. acb
 *  3. bac
 *  4. bca
 *  5. cab
 *  6. cba
 *
 *  Example:
 *     Input: String= "oidbcaf", Pattern="abc"
 *     Output: true
 *     Explanation: The string contains "bca" which is a permutation of the given pattern.
 *
 * */

object PermutationInString {

    fun findAnswer(str: String, pattern: String): Boolean {
        var windowStart = 0
        var matched = 0

        val charFrequencyMap = HashMap<Char, Int>()
        for (char in pattern) {
            charFrequencyMap[char] = charFrequencyMap.getOrDefault(char, 0) + 1
        }

        for (windowEnd in str.indices) {
            val rightChar = str[windowEnd]
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap[rightChar] = charFrequencyMap[rightChar]!! - 1

                if (charFrequencyMap[rightChar] == 0) { // character is completely matched
                    matched++
                }
            }

            if (matched == charFrequencyMap.size)
                return true

            if (windowEnd >= pattern.length - 1) { // shrink the window by one character
                val leftChar = str[windowStart++]
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap[leftChar] == 0) {
                        matched--
                    }

                    charFrequencyMap[leftChar] = charFrequencyMap[leftChar]!! + 1
                }
            }

        }

        return false
    }
}

fun main() {
    println("Permutation exist: " + PermutationInString.findAnswer("oidabcaf", "abca"))
}