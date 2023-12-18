package leetcode151;

//https://leetcode.com/problems/reverse-words-in-a-string/description
public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println("Result for `the sky is blue`: " + reverseWords("the sky is blue")); // blue is sky the
        System.out.println("Result for `a good   example`: " + reverseWords(" a  good   example ")); // example good a
    }

    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0, j;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                j = i + 1;
                while (j < s.length() && s.charAt(j) != ' ') { j++; }

                if (s.charAt(j -1) == ' ') { continue; }

                if (builder.length() != 0) {
                    builder.insert(0, ' ');
                }

                builder.insert(0, s.substring(i, j));
                i = j + 1;
                continue;
            }

            i++;
        }

        return builder.toString();
    }
}
