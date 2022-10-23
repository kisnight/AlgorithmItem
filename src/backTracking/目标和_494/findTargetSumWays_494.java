package backTracking.目标和_494;

/*
方案思路：

1、数组nums 的每个元素都可以添加符号 + 或 -，因此每个元素有 2种添加符号的方法，n个数共有 2^n
n种添加符号的方法，对应 2^n种不同的表达式。当 n个元素都添加符号之后，即得到一种表达式，如果表达式的结果等于目标数target，则该表达式即为符合要求的表达式。

2、可以使用回溯的方法遍历所有的表达式，回溯过程中维护一个计数器 count，当遇到一种表达式的结果等于目标数target时，将count 的值加 11。遍历完所有的表达式之后，即可得到结果等于目标数target 的表达式的数目。

 */

public class findTargetSumWays_494 {
    private static int count = 0;

    public static void main(String[] args) {
        int [] arr = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        findTargetSumWays_494 a = new findTargetSumWays_494();
        System.out.println(a.findTargetSumWays(arr, target));
    }


    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int [] nums, int target, int sum, int curIndex) {
        // 终止条件，当遍历下标等于数组的长度时，就说明已经n个数已经遍历完了；这里不要用curIndex == nums.length -1，会出问题
        if(curIndex == nums.length) {
            if(sum == target) {
                count ++;
            }
            // 这里记住是在if语句外面返回，之前我在里面返回会出边界问题；
            return;
        }

        // 在递归遍历中需要做的事情， 对于数组中的每一个元素，存在两种计算方式，加法和减法
        int sumAdd = sum + nums[curIndex];
        int sumSub = sum - nums[curIndex];

        // 构建递归， 加法递归和减法递归，这两种递归计算方式都可以使得count增加，有点像二叉树的左右树，只是这里不会减枝
        dfs(nums, target, sumAdd,  curIndex + 1);
        dfs(nums, target, sumSub, curIndex + 1);
    }

}
