/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A **perfect square** is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Solution:
 *
 * T(i) =
 *     0 <= i <=3               i
 *
 *     i >= 4                   Min (i, 1 + T(i - j*j)) when j in 1..i  & j*j < i
 * **/

class PerfectSquare {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            repeat(10) {
                println("Number of perfect squares for $it is ${numSquares(it)}")
            }
        }

        fun numSquares(n: Int): Int {
            if (n < 4) return n
            val dp = IntArray(n + 1)

            dp[0] = 0
            dp[1] = 1
            dp[2] = 2
            dp[3] = 3

            for (i in 4 .. n) {
                dp[i] = i
                var j = 1
                while (j * j <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j])
                    j++
                }
            }

            return dp[n]
        }
    }

}