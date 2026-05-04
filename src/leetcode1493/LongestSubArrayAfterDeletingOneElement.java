package leetcode1493;

public class LongestSubArrayAfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubArrayAfterDeletingOneElement longest = new LongestSubArrayAfterDeletingOneElement();
        System.out.println("Longest sub array of ones for [1,1,0,1] is " + longest.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println("Longest sub array of ones for [0,1,1,1,0,1,1,0,1] is " + longest.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println("Longest sub array of ones for [1,1,1] is " + longest.longestSubarray(new int[]{1, 1, 1}));
        System.out.println("Longest sub array of ones for [1,0] is " + longest.longestSubarray(new int[]{1, 0}));
        System.out.println("Longest sub array of ones for [0, 0, 0] is " + longest.longestSubarray(new int[]{0, 0, 0}));
    }

    public int longestSubarray(int[] nums) {
        int max = 0;
        int zeros = 0;
        for (int s = 0, e = 0; e < nums.length; e++) {
            if (nums[e] == 0) {
                zeros++;
                while (zeros > 1) {
                    if (nums[s++] == 0) zeros--;
                }
            }

            max = Math.max(max, e - s);
        }

        return max;
    }
}
