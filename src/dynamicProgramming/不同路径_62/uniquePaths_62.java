package dynamicProgramming.不同路径_62;

/*
动态规划思路步骤：
1、dp数组以及下标的意义
2、递推公式
3、dp数组如何初始化
4、遍历顺序
5、打印dp数组的结果
 */
public class uniquePaths_62 {
    public int uniquePaths(int m, int n) {
        // 构建一个二维数组，dp[i][j]表明从左上角走到(i,j)的路径数量
        int [][] dp = new int[m][n];
        // 初始化数组
        for(int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        // 初始化数组
        for(int j = 0; j < n; j ++) {
            dp[0][j] = 1;
        }

        // 遍历数组，但是因为上面已经初始化，因此i,j的值都是从1开始的，并且范围为[0, m)和[0, n)
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                // 状态转移方程，表明dp[i][j]的值依赖于上一步的状态；
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n -1];
    }
}
