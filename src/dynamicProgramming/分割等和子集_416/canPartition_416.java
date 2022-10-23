package dynamicProgramming.分割等和子集_416;

public class canPartition_416 {


    public static void main(String[] args) {
        int [] arr = new int[]{14, 9, 8, 4, 3, 2};
        canPartition_416 a = new canPartition_416();
        System.out.println(a.canPartition(arr));
    }

/*
0-1背包问题解决思路：
1、动态规划求解之前的前置特殊情况的排查
 （1）根据数组的长度n判断数组是否可以被划分。如果n<2，则不可能将数组分割成元素和相等的两个子集，
      因此直接返回false。
  (2)计算整个数组的元素和sum以及最大元素maxNum。如果sum 是奇数，则不可能将数组分割成元素和相
     等的两个子集，因此直接返回false。如果sum 是偶数，则令target = sum /2,需要判断是否可以
     从数组中选出一些数字，使得这些数字的和等于target。如果maxNum > target，则除了maxNum
     以外的所有元素之和一定小于target，因此不可能将数组分割成元素和相等的两个子集，直接返回false。

2、状态数组dp的定义：
  dp[i][j]:表示从数组的[0,i]下标范围内选取若干个正整数（可以是0个),是否存在一种选取方案使得被选
           取的正整数的和等于j;

3、状态转移方程的初始化
 （1）创建二维数组dp[i][j], 包含 n 行 target+1 列，初始时,dp[i][j]中的全部元素都是false。
 （2）0 < i < n，dp[i][0]=true, 因为 j = 0 表明正整数的和等于0，如果不选取任何正整数，则被选取的正整数等于0。
 （3）当 i==0 时，只有一个正整数 nums[0] 可以被选取，因此 dp[0][nums[0]] = true。

3、状态转移方程的推导
  当 i > 0, 且 j > 0 时，存在两种情况
  （1）如果 j ≥ nums[i]，则对于当前的数字 nums[i]，可以选取也可以不选取，两种情况只要有一个为 true，就有dp[i][j]=true。
    1) 如果不选取nums[i]，则dp[i][j] = dp[i-1][j];
    2) 如果选取nums[i]，dp[i][j]=dp[i−1][j−nums[i]],其中 j - nums[i] 表示前一个状态的元素和；

  （2）如果 j < nums[i]，则在选取的数字的和等于 j 的情况下无法选取当前的数字nums[i]，因此有dp[i][j] = dp[i-1][j];
   综上所述：
   状态转移方程如下：
   dp[i][j]= dp[i−1][j] | dp[i−1][j−nums[i]]  j ≥ nums[i];
   dp[i][j]= dp[i−1][j]                       j > nums[i];

 */
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int totalSum = 0;
        // 获取数组所有元素的和 以及 数组中元素的最大值
        for (int item : nums) {
            totalSum += item;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        // 获取一半的值, 即背包的大小
        int target =  totalSum / 2;

        // 1、构建二维状态数组dp[i][j],表示从数组的[0,i]下标范围内选取若干个正整数（可以是0个),
        // 是否存在一种选取方案使得被选取的正整数的和等于j;
        boolean [][] dp = new boolean[nums.length][target + 1];

        // 2、初始化dp[i][j]
        for(int i = 0; i < nums.length; i ++) {
            dp[i][0] = true;
        }

        // 3、状态转移方程推导
        for(int i = 1; i <= nums.length - 1; i ++) {
            for(int j = 1; j <= target; j ++) {
                if(j >= nums[i]) {
                    dp[i][j] = dp[i -1][j] | dp[i - 1][j - nums[i]];
                }else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }

        // 4、获取最终结果
        return dp[nums.length -1][target];
    }
}
