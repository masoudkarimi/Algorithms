/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since
 * each version is developed based on the previous version, all the versions after a
 * bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
     Example 1:
        Input: n = 5, bad = 4
        Output: 4
     Explanation:
        call isBadVersion(3) -> false
        call isBadVersion(5) -> true
        call isBadVersion(4) -> true
        Then 4 is the first bad version.
 * */
class FirstBadVersion(private val versions: Map<Int, Boolean>) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val versions = mapOf(
                1 to false,
                2 to false,
                3 to false,
                4 to false,
                5 to false,
                6 to false,
                7 to true,
            )

            val firstBadVersion = FirstBadVersion(versions)
            val result = firstBadVersion.firstBadVersion(versions.size)

            println("First bad version is: $result")
        }
    }

    fun firstBadVersion(n: Int) : Int {
        return findTheBadVersion(1, n)
    }

    private fun findTheBadVersion(from: Int, to: Int): Int {
        if (from > to) {
            throw IllegalArgumentException()
        }

        if (from == to) {
            return from
        }

        val pivot = from + ((to - from) / 2)
        return if (isBadVersion(pivot)) {
            findTheBadVersion(from, pivot)
        } else {
            findTheBadVersion(pivot + 1, to)
        }
    }

    fun isBadVersion(version: Int) : Boolean = versions[version] ?: false
}