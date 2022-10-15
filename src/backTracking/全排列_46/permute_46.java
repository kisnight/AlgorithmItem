package backTracking.全排列_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
深度优先遍历（）
-状态：每一个结点表示了求解问题的不同阶段
-深度优先遍历在回到上一层结点时需“状态重置”
状态变量：
1、递归到第几层depth
2、已经选了哪些数path
3、布尔数组used
 */
public class permute_46 {

    public static void main(String[] args) {
        permute_46 a = new permute_46();
        int [] arry = {1,2,3};
        System.out.println(a.permute(arry));
    }
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean [] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int [] nums, int len, int depth, Deque<Integer> path, boolean [] used, List<List<Integer>> res) {
        //循环结束的标志
        if(depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        //构建循环
        for (int i = 0; i < len; i++) {
            //如果在此深度中nums[i]已经被用了，那么就直接跳过；
            if(used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1, path, used,res);
            //一次深度递归结束，将之前的动作反着做一遍，相当于回到上一个层次；
            path.removeLast();
            used[i] = false;
        }
    }


}
