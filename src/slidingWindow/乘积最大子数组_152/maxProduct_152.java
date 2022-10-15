package slidingWindow.乘积最大子数组_152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class maxProduct_152 {
    public int maxProduct(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer item : nums) {
            treeSet.add(item);
        }
        ArrayList<Integer> list = new ArrayList<>(treeSet);
        int maxPro = list.get(list.size() - 1);
        int tempPro ;
        for(int index = 0; index < nums.length - 1; index ++ ) {
            tempPro = nums[index];
            for(int colum = index + 1; colum < nums.length; colum ++) {
                tempPro = tempPro * nums[colum];
                if(maxPro < tempPro) {
                    maxPro = tempPro;
                }
            }
        }

        return maxPro;

    }
}
