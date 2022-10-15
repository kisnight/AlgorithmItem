package dynamicProgramming.回文子串_647;

import java.util.Arrays;

public class countSubstrings_647 {

    public static void main(String[] args) {
        countSubstrings_647 a = new countSubstrings_647();
        String s = "abc";
        System.out.println(a.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int retNum = 0;
        // 1、dp[i][j]表示起始下标为i，尾部下标为j的字符串是否是回文子串
        if("".equals(s)) {
            return 1;
        }
        boolean [][] dp = new boolean[s.length()][s.length()];
        // 2、dp[i][j]初始化, 刚开始的时候都是false，这里需要注意一下二维数组在使用 Arrays.fill初始化的时候需要for循环
        for(int i = 0; i < s.length(); i ++) {
            Arrays.fill(dp[i], false);
        }

        // 3、公式推导
        /*
            1、i = j: dp[i][j] = true; 字符串有一个元素的时候；
            2、j - i = 1: dp[i][j] = true; 字符串有两个元素并且两个元素相同的时候
            3、j - i > 1;
               (s[i] = s[j]) && dp[i + 1][j - 1] => dp[i][j] = true;
               其他情况：=> dp[i][j] = false;
         */
        // 这里遍历i的时候采用反向遍历,因为下面会出现dp[i+1][j-1]，如果是正向遍历的话i+1会等于s.length()导致越界
        for(int i = s.length() - 1; i >= 0; i --) {
            for(int j = i; j <= s.length() - 1; j ++) {
                if(i == j) {
                    dp[i][j] = true;
                }else if ((j - i == 1) && (s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1]);
                }
                // 当找到一个符合要求的回文字符串的时候就与老的回文字符串比较长度大小，如果新的长度更长的话就直接替换；
                if(dp[i][j]) {
                    retNum ++;
                }
            }
        }
        // 返回最终的结果
        return retNum;
    }
}
