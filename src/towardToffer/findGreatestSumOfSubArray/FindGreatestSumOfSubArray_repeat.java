package towardToffer.findGreatestSumOfSubArray;

import java.util.ArrayList;
import java.util.List;

public class FindGreatestSumOfSubArray_repeat {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int maxSum = 0;
        for(int i = 0; i < array.length; i ++) {
            int subSum = 0;
            for(int j = i; j < array.length; j ++) {
                subSum += array[j];
                maxSum = subSum > maxSum ? subSum : maxSum;
            }
        }
        return maxSum;
    }
}
