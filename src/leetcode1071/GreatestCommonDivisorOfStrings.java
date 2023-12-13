package leetcode1071;

//https://leetcode.com/problems/greatest-common-divisor-of-strings/description
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println("Result for ABCABC and ABC= " + gcdOfStrings("ABCABC", "ABC") );
        System.out.println("Result for ABABAB and ABAB= " + gcdOfStrings("ABABAB", "ABAB") );
        System.out.println("Result for LEET and CODE= " + gcdOfStrings("LEET", "CODE") );
        System.out.println("Result for AAAAAAAAA and AAACCC= " + gcdOfStrings("AAAAAAAAA", "AAACCC") );
    }

    public static String gcdOfStrings(String str1, String str2) {
        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() < str2.length() ? str2 : str1;

        for (int j = shorter.length(); j > 0; j--) {
            if (longer.length() % j != 0) {
                continue;
            }
            if (shorter.length() % j != 0) {
                continue;
            }


            for (int i = 0; i < longer.length(); i++) {
                if (longer.charAt(i) != shorter.charAt(i % j)) {
                    break;
                }
                if (i == longer.length() - 1) {

                    for (int k = 0; k < shorter.length(); k++) {
                        if (shorter.charAt(k) != shorter.charAt(k % j)) {
                            break;
                        }

                        if (k == shorter.length() - 1) {
                            return shorter.substring(0, j);
                        }
                    }

                }
            }
        }

        return "";
    }
}
