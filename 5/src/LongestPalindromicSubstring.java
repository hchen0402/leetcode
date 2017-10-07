public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean table[][] = new boolean[len][len];

        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            table[i][i] = true;

        }

        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int k = 3; k <= len; k++) {

            for (int i = 0; i < len - k + 1; i++) {
                int j = i + k - 1;

                if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
