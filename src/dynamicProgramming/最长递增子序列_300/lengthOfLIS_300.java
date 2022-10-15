package dynamicProgramming.最长递增子序列_300;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lengthOfLIS_300 {

    public static void main(String[] args) {
        lengthOfLIS_300 a = new lengthOfLIS_300();
        int [] arr = new int[]{0,1,0,3,2,3};
        System.out.println(a.lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {

        // dp[i]表示i之前包括i自身所形成的数组中最长子序列的长度
        int [] dp = new int[nums.length];

        // 初始化dp[i]
        Arrays.fill(dp, 1);
        // 公式递推
        /*
            位置i的最长子序列的长度应该等于从0 到 i -1 各个位置的最长子序列长度 + 1的最大值
            if(nums[i] > nums[j]) => dp[i] = max(dp[i], dp[j] + 1);
         */
        int maxLen = 0;
        for(int i = 1; i < nums.length; i ++) {
            for(int j = 0; j < i; j ++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i ++) {
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int lengthOfLIS1(int[] nums) {
        // dp[i][j]表示以nums[i]作为子序列的第一个元素，nums[j]作为子序列的最后一个元素，是否是严格递增的
        boolean [][] dp = new boolean[nums.length][nums.length];
        int maxLenth = 0;

        // 2、dp[i][j]初始化, 刚开始的时候都是false，这里需要注意一下二维数组在使用 Arrays.fill初始化的时候需要for循环
        for(int i = 0; i < nums.length; i ++) {
            Arrays.fill(dp[i], false);
        }
        // 公式递推
        /*
        1、i = j,表明子序列只有一个元素，dp[i][j] = true;
        2、i < j, 如果子序列的最后一个元素小于dp[i][j], 那么dp[i][j] = true;
         */
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++) {
            temp.clear();
            for(int j = i; j < nums.length; j ++) {
                if(i == j) {
                    dp[i][j] = true;
                }else {
                    if(nums[j] > temp.get(temp.size() -1)) {
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]) {
                    temp.add(nums[j]);
                    if(maxLenth < temp.size()) {
                        maxLenth = temp.size();
                    }
                }

            }
        }
        return maxLenth;
    }



}
