package leetcode1431;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        // [true,true,true,false,true]
        System.out.println("Result for candies = [2,3,5,1,3], extraCandies = 3: " + kidsWithCandies(new int[] {2,3,5,1,3}, 3));

        // [true,false,false,false,false]
        System.out.println("Result for candies = [4,2,1,1,2], extraCandies = 1: " + kidsWithCandies(new int[] {4,2,1,1,2}, 1));

        // [true,false,true]
        System.out.println("Result for candies = [12,1,12], extraCandies = 10: " + kidsWithCandies(new int[] {12,1,12}, 10));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();

        return Arrays.stream(candies)
                .boxed()
                .map( item -> item + extraCandies >= max)
                .collect(Collectors.toList());

    }
}
