package leetcode1456;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 * */
public class MaximumNumberOfVowelsInASubstring {

    public static void main(String[] args) {
        System.out.println("Max vowels for s=abciiidef and k=3 is " + maxVowels("abciiidef", 3));
        System.out.println("Max vowels for s=aeiou and k=2 is " + maxVowels("aeiou", 2));
        System.out.println("Max vowels for s=leetcode and k=3 is " + maxVowels("leetcode", 3));
        System.out.println("Max vowels for s=le and k=3 is " + maxVowels("le", 3));
    }

    public static int maxVowels(String s, int k) {
        if (s.length() < k) return 0;
        int max;
        int vowels = 0;

        for (int i=0; i< k; i++) {
            if (isVowel(s.charAt(i))) vowels++;
        }

        max = vowels;
        if (max == k) return max;

        for (int i=0, j=k; j<s.length(); i++, j++) {
            if (isVowel(s.charAt(j))) {
                vowels++;
            }

            if (isVowel(s.charAt(i))) {
                vowels--;
            }

            max = Math.max(max, vowels);
            if (max == k) return max;
        }

        return max;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}