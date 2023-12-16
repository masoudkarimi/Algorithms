package leetcode605;

// https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println("Result for [1,0,0,0,1], n = 1: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // true
        System.out.println("Result for [1,0,0,0,1], n = 2: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // false
        System.out.println("Result for [1,0,0,0,1,0,0,1,0], n = 2: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0}, 3)); // false
        System.out.println("Result for [1,0,0,0,0,1], n = 2: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2)); // false
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result = 0;
        for (int i = 0; i < flowerbed.length; ) {
            // If we see a 1 it means you cant plant a flower in current index and also next index
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            }

            // If current index is 0 we should check the previous and the next index
            if (flowerbed[i] == 0) {

                // If previous index is 1, we cant plant here
                if (i > 0 && flowerbed[i - 1] == 1) {
                    i++;
                    continue;
                }

                // If next index is 1, we cant plant here and we need to go further for 2 or 1 index depend on the
                // array length
                if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                    i += i < flowerbed.length - 2 ? 2 : 1;
                    continue;
                }

                // Here the previous and the next item is 0 so we plant our flower and update the index
                flowerbed[i] = 1;

                // Since the current index used to plant a flower we need to go further for 2 index
                i += 2;
                result++;
            }
        }

        return result >= n;
    }
}
