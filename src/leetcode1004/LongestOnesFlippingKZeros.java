package leetcode1004;

public class LongestOnesFlippingKZeros {
    public static void main(String[] args) {
        System.out.println("Result for [1,1,1,0,0,0,1,1,1,1,0] and k=2 is " + longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("Result for [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1] and k=2 is " + longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int x = 0;
        int max = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                max = Math.max(max, j - i + 1);
                continue;
            }
            x++;
            while (x > k) {
                if (nums[i++] == 0) x--;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
