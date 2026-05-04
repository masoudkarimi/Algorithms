package leetcode1732;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        FindTheHighestAltitude f = new FindTheHighestAltitude();
        System.out.println("Highest altitude for [-5,1,5,0,-7] is " + f.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println("Highest altitude for [-4,-3,-2,-1,4,3,2] is " + f.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public int largestAltitude(int[] gain) {
        int highest = 0;
        int sum = 0;
        for (int num : gain) {
            sum += num;
            highest = Math.max(highest, sum);
        }

        return highest;
    }
}
