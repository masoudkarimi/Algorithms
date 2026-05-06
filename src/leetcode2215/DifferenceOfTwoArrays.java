package leetcode2215;


import java.util.*;

/***
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
public class DifferenceOfTwoArrays {

    public static void main(String[] args) {
        DifferenceOfTwoArrays d = new DifferenceOfTwoArrays();
        List<List<Integer>> q1 = d.findDifference(new int[]{-80, -15, -81, -28, -61, 63, 14, -45, -35, -10}, new int[]{-1, -40, -44, 41, 10, -43, 69, 10, 2});
        System.out.println("Answer for nums1 = [1,2,3, 3], nums2 = [1, 1, 2, 2] is: " + Arrays.toString(q1.get(0).toArray()) + " and " + Arrays.toString(q1.get(1).toArray()));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i : set1) {
           if (!set2.contains(i)) list1.add(i);
        }

        for (int i : set2) {
           if (!set1.contains(i)) list2.add(i);
        }


        return List.of(list1, list2);
    }
}
