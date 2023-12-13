package leetcode75

import kotlin.math.max

//https://leetcode.com/problems/merge-strings-alternately/description
object MergeStringsAlternately {

    @JvmStatic
    fun main(args: Array<String>) {
        check(mergeAlternately("abc", "pqr") == "apbqcr")
        check(mergeAlternately("ab", "pqrs") == "apbqrs")
        check(mergeAlternately("abcd", "pq") == "apbqcd")
    }


    fun mergeAlternately(word1: String, word2: String): String {
        val size = word1.length + word2.length
        if (size == 0) return ""
        if (word1.isEmpty()) return word2
        if (word2.isEmpty()) return word1

        val builder = StringBuilder(size)

        for (i in 0 until max(word1.length, word2.length)) {
            val a = word1.getOrNull(i)?.toString()
            val b = word2.getOrNull(i)?.toString()
            builder.append((a ?: "") + (b ?: ""))
        }

        return builder.toString()
    }
}