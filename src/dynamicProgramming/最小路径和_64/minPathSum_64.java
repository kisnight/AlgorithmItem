package dynamicProgramming.最小路径和_64;

public class minPathSum_64 {
    public int minPathSum(int[][] grid) {
        // 对于二维数组grid，grid[i][j]表明从左上角走到(i,j)的最小路径
        int row = grid.length;
        int collow = grid[0].length;

        // 初始化数组
        for(int i = 1; i < row; i ++) {
            grid[i][0] += grid[i-1][0];
        }
        // 初始化数组
        for(int j = 1; j < collow; j ++) {
            grid[0][j] += grid[0][j-1];
        }
        // 遍历
        for(int i = 1; i < row; i ++) {
            for(int j = 1; j < collow; j ++) {
                // 状态转移方程，表明在（i, j）的最小路径和等于在（i-1, j）和（i, j -1）的最小值 加上原来的现在grid[i][j]的值
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][collow -1];
    }
}
