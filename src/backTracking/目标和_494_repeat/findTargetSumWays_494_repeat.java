package backTracking.目标和_494_repeat;

/*
方案思路：

1、数组nums 的每个元素都可以添加符号 + 或 -，因此每个元素有 2种添加符号的方法，n个数共有 2^n
n种添加符号的方法，对应 2^n种不同的表达式。当 n个元素都添加符号之后，即得到一种表达式，如果表达式的结果等于目标数target，则该表达式即为符合要求的表达式。

2、可以使用回溯的方法遍历所有的表达式，回溯过程中维护一个计数器 count，当遇到一种表达式的结果等于目标数target时，将count 的值加 11。遍历完所有的表达式之后，即可得到结果等于目标数target 的表达式的数目。

 */

public class findTargetSumWays_494_repeat {
    private static int count = 0;

    public static void main(String[] args) {
        int [] arr = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        findTargetSumWays_494_repeat a = new findTargetSumWays_494_repeat();
        System.out.println(a.findTargetSumWays(arr, target));
    }


    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int [] nums, int target, int curIndex, int sum) {
        // 1、构建参数

        // 2、递归终止的条件
        if(curIndex == nums.length) {
            if(sum == target) {
                count ++;
            }
            return;
        }
        // 3、递归中需要做的事情
        int sumAdd = sum + nums[curIndex];
        int sumSub = sum - nums[curIndex];
        // 4、构建递归,这里需要构建两个不同的分支，分别代表加法和减法
        dfs(nums, target, curIndex + 1, sumAdd);
        dfs(nums, target, curIndex + 1, sumSub);
        // 5、这里为什么没有回退到上一级去置位状态是因为这里需要遍历完nums中所有的元素,
        // 并且在递归终止条件中就已经把想要统计的数据统计完了，而且每一层的递归结束不会相互影响
    }
}
