package array.颜色分类_75;

import java.util.Arrays;

public class sortColors_75_repeat {

    public static void main(String[] args) {
        sortColors_75_repeat a = new sortColors_75_repeat();
        //int [] arry = {0,1};
        //int [] arry = {2,0,1};
        //int [] arry = {2,0,1};
        //int [] arry = {0,0,1};
        //int [] arry = {0,1,2};
        int [] arry = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(a.sortColors(arry)));

    }
    //该方法比较简洁
    public int[] sortColors(int[] nums) {
        if(nums.length == 1 || nums.length == 2) {
            Arrays.sort(nums);
            return nums;
        }
        int countRed = 0;
        int countWhite = 0;
        int countBlu = 0;

        for(int item : nums) {
            if(item == 0) {
                countRed ++;
                continue;
            }

            if(item == 1) {
                countWhite ++;
                continue;
            }

            if(item == 2) {
                countBlu ++;
            }
        }

        if(countRed != 0) {
            Arrays.fill(nums, 0, countRed, 0);
        }

        if(countWhite != 0) {
            Arrays.fill(nums, countRed, countRed + countWhite, 1);
        }

        if(countBlu != 0) {
            Arrays.fill(nums, countRed + countWhite, nums.length, 2);
        }

        return nums;
    }

}
