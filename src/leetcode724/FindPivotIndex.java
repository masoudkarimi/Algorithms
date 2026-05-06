package leetcode724;


public class FindPivotIndex {
    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        System.out.println("Pivot index for [1,7,3,6,5,6] is " + f.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println("Pivot index for [1,2,3] is " + f.pivotIndex(new int[]{1, 2, 3}));
        System.out.println("Pivot index for [2,1,-1] is " + f.pivotIndex(new int[]{2, 1, -1}));

    }

    public int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            sumRight[i] = sumRight[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (sumLeft[i] == sumRight[i]) {
                return i;
            }
        }

        return -1;
    }
}
