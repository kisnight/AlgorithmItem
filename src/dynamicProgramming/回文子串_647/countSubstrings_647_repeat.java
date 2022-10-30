package dynamicProgramming.回文子串_647;

import java.util.Arrays;

public class countSubstrings_647_repeat {

    public static void main(String[] args) {
        countSubstrings_647_repeat a = new countSubstrings_647_repeat();
        String s = "abc";
        System.out.println(a.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int retNum = 0;
        if("".equals(s)) {
            return 1;
        }

        boolean [][] dp = new boolean[s.length()][s.length()];
        // 初始化二维数组
        for(int i = 0; i < s.length(); i ++) {
            Arrays.fill(dp[i], false);
        }

        // 公式推导
        /*
            j = i;
            j -i = 1;
            j - i > i => dp[i][j] = s[i] == s[j] && dp[i+1][j-1];
         */
        for(int i = s.length() -1; i >=0; i --) {
            /*
            这里j 从i开始是因为j 要比i 大，所以j不能从0开始，
            做第二遍的时候我的j是从0开始的，因此出现了问题
             */
            for(int j = i; j < s.length(); j ++) {
                if(i == j) {
                    dp[i][j] = true;
                }else if(j - i == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1]);
                }
                if(dp[i][j]) {
                    retNum ++;
                }
            }
        }
        return retNum;
    }
}
