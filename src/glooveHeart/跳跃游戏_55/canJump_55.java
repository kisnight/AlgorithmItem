package glooveHeart.跳跃游戏_55;

import java.util.Arrays;

public class canJump_55 {
    /*
        方法一：动态规划方法
        思路：
        dp[i]表示能否到达位置i，对每个位置i判断能否通过前面的位置跳跃过来，当前位置j能达到，
        并且当前位置j加上能到达的位置如果超过了i，那dp[i]更新为ture，便是i位置也可以到达。
     */
    public boolean canJump1(int[] nums) {
        // dp[i]表示能否到达位置i; i为数组的下标
        boolean [] dp = new boolean[nums.length];
        // 将dp[]数组中所有的元素都初始化为false；
        Arrays.fill(dp, false);

        //初始化,第一个元素肯定可以到达的，因此dp[0] = true;
        dp[0] = true;
        for(int i = 1; i < nums.length; i ++) {
            for(int j = 0; j < i; j ++) {
                //当前位置j能达到，并且当前位置j加上能到达的位置如果超过了i，那dp[i]更新为ture，便是i位置也可以到达
                if(dp[j] && (j + nums[j]) >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length -1];
    }


    /*
        方法二：贪心算法
        思路：
        i每次移动只能在cover的范围内移动，每移动一个元素，cover得到该元素数值（新的覆盖范围）的补充，让i继续移动下去。
        而cover每次只取 max(该元素数值补充后的范围, cover本身范围)。
        如果cover大于等于了终点下标，直接return true就可以了。
     */
    public boolean canJump2(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int maxCover = 0;

        // 注意这里是小于等于覆盖范围maxCover，而不是nums.length
        for(int i = 0; i <= maxCover; i ++) {
            // 更新新的覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
            // 说明可以覆盖到终点了
            if(maxCover >= nums.length -1) {
                return true;
            }
        }
        return false;
    }

}
