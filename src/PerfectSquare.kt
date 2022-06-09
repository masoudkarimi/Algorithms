import java.util.Arrays
import kotlin.math.min

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
    data class Result(
        val min: Int,
        val answer: List<Int>
    )

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            repeat(101) {
                println("Number of perfect squares for $it is ${numSquares(it)}")
                println("Number of perfect squares answer for $it is ${numSquaresAnswer(it)}")
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

        fun numSquaresAnswer(n: Int): List<Int> {
            if (n < 4) {
                return Array(n) { 1 }.toList()
            }

            val dp = Array(n + 1) { Result(0, listOf()) }

            dp[0] = Result(0, listOf())
            dp[1] = Result(1, listOf(1))
            dp[2] = Result(2, listOf(1, 1))
            dp[3] = Result(3, listOf(1, 1, 1))


            for (i in 4 .. n) {
                dp[i] = Result(i, listOf())

                var j = 1
                while (j * j <= i) {
                    dp[i] = if ((dp[i - j * j].min + 1) < dp[i].min) {
                        Result(
                            min = 1 + dp[i - j * j].min,
                            answer = dp[i - j * j].answer + listOf(j * j)
                        )
                    } else {
                        dp[i]
                    }
                    j++
                }
            }

            return dp[n].answer
        }
    }

}