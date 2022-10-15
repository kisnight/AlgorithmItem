package array.下一个排列_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nextPermutation_31 {

    public static void main(String[] args) {
        nextPermutation_31 a = new nextPermutation_31();
        int [] array = {4,2,0,2,3,2,0};
        System.out.println(a.nextPermutation(array).toString());
    }

    public int[] nextPermutation(int[] nums) {
        if(nums.length == 0) {
            return nums;
        }
        int indexI = -1;
        int indexJ = -1;
        boolean findFlag = false;
        for(int i = nums.length -1; i >= 1; i-- ) {
            for(int j = i-1; j>=0; j--) {
                //这里也是难点，因为要判断j是否是最大的
                if(nums[i] > nums[j] && j > indexJ) {
                    indexI = i;
                    indexJ = j;

                }
                //这里是难点和优化点
                if(i == indexJ) {
                    findFlag = true;
                    break;
                }
            }

            if(findFlag) {
                break;
            }
        }

        if(indexI == -1) {
            Arrays.sort(nums);
            return nums;
        }

        int temp = nums[indexJ];
        nums[indexJ] = nums[indexI];
        nums[indexI] = temp;
        List<Integer> list = new ArrayList<>();
        for(int k = indexJ + 1; k <= nums.length -1; k++) {
            list.add(nums[k]);
        }
        Collections.sort(list);
        for(int n = indexJ + 1; n <= nums.length -1; n++) {
            nums[n] = list.get(n - indexJ -1);
        }
        return nums;
    }
}
