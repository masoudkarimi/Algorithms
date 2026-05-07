package leetcode1207;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        UniqueNumberOfOccurrences u = new UniqueNumberOfOccurrences();
        int[] nums = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println("Result for [-3,0,1,-3,1,1,1,-3,10,0] is " + u.uniqueOccurrences(nums));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
