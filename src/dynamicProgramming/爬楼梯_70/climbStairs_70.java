package dynamicProgramming.爬楼梯_70;

public class climbStairs_70 {

    public static void main(String[] args) {
        climbStairs_70 a = new climbStairs_70();
        System.out.println(a.climbStairs(2));
    }

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }
        /*
        dp[n] 表示爬上第n个台阶的方法数量,这里将dp数组的初始化数量设置为n+1，
        是因为最终要求的是dp[n],所以数组应该有n+1个
         */
        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n+1; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }
}
