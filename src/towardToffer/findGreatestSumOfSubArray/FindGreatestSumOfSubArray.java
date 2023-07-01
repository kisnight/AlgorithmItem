package towardToffer.findGreatestSumOfSubArray;

import java.util.ArrayList;
import java.util.List;

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        List<Integer> tempList = new ArrayList<>();
        int maxSum = 0;
        for(int i = 0; i < array.length; i ++) {
            int arrElementSum = 0;
            for(int j = i; j < array.length; j ++) {
                arrElementSum += array[j];
                maxSum = maxSum < arrElementSum ? arrElementSum : maxSum;
            }
        }
        return maxSum;
    }
}
