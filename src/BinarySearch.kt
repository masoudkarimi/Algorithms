/**
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * */

class BinarySearch {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val binarySearch = BinarySearch()
            val nums = intArrayOf(-1,0,3,5,9,12)
            val index = binarySearch.search(nums, 9)
            val index2 = binarySearch.search(nums, 8)
            println("Index= $index")
            println("Index2= $index2")
        }
    }


    fun search(nums: IntArray, target: Int): Int {
        return search(nums, 0, nums.lastIndex, target)
    }

    fun search(nums: IntArray, l: Int, r: Int, target: Int): Int {
        if (r >= l) {
            val mid = l + (r - l) / 2
            if (nums[mid] == target) {
                return mid
            }

            if (target < nums[mid]) {
                return search(nums, l, mid - 1, target)
            }

            return search(nums, mid + 1, r, target)
        }

        return -1
    }
}