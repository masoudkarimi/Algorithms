package leetcode345;

//https://leetcode.com/problems/reverse-vowels-of-a-string/description
public class ReverseVowelsInString {
    public static void main(String[] args) {
        System.out.println("Result for hello: " + reverseVowels("hello")); // holle
        System.out.println("Result for leetcode: " + reverseVowels("leetcode")); // leotcede
        System.out.println("Result for masoud: " + reverseVowels("masoud")); // musoad
        System.out.println("Result for Ali: " + reverseVowels("Ali")); // ilA
    }

    public static String reverseVowels(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }

        for (int i = 0, j = s.length() - 1; i <= j;) {
            char left = result[i];
            char right = result[j];

            if (isVowel(left) && isVowel(right)) {
                result[i] = right;
                result[j] = left;
                i++;
                j--;
                continue;
            }

            if (!isVowel(left)) {
                i++;
            }

            if (!isVowel(right)) {
                j--;
            }


        }

        return new String(result);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'O' || c == 'I' || c == 'U';
    }
}
