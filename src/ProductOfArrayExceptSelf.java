import java.util.Arrays;
/**
 * Product of Array Except Self
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">LeetCode</a>
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to
 * the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 *  Input: nums = [1,2,3,4]
 *  Output: [24,12,8,6]
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does
 * not count as extra space for space complexity analysis.)
 *
 * This a solution with O(1) extra space
 * */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(product.productExceptSelf(new int[] {2, 3, 4, 5})));

        System.out.println(Arrays.toString(product.productExceptSelf(new int[] {-1,1,0,-3,3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        // Prefix array
        for (int i = 1 ; i < nums.length; i ++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int x = 1;
        for (int i = nums.length - 2 ;  i >= 0; i--) {
            x *= nums[i + 1];
            result[i] = x * result[i];
        }

        return result;

    }
}
