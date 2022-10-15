package dynamicProgramming.打家劫舍_198;

import static sun.swing.MenuItemLayoutHelper.max;

public class rob_198 {
    public int rob(int[] nums) {
        if(nums.length <= 1) {
            return nums.length == 0 ? 0:nums[0];
        }
        /*
            dp[i]
                截止到目前这一家，我们能够拿到的最大的钱数
         */
        int[] dp = new int[nums.length];
        int res = Math.max(nums[0],nums[1]);
        for(int i = 0; i < nums.length;i++) {
            if(i == 0) {
                dp[i] = nums[0];
                continue;
            }
            if(i == 1) {
                dp[i] = Math.max(nums[0],nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            res = Math.max(res,dp[i]);
        }

        return res;
    }

}
