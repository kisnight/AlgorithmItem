package slidingWindow.最短无序连续子数组_581;

import java.util.Arrays;

public class findUnsortedSubarray_581 {

    public static void main(String[] args) {
        findUnsortedSubarray_581 a = new findUnsortedSubarray_581();
        int [] arry = {2,1};
        System.out.println(a.findUnsortedSubarray(arry));

    }
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int [] arry = nums.clone();
        Arrays.sort(arry);
        if(Arrays.equals(nums,arry)) {
            return 0;
        }

        if(nums.length == 2) {
            if(nums[0] != arry[0] || nums[nums.length-1] != arry[nums.length-1]) {
                return 2;
            }
        }else {
            if(nums[0] != arry[0] || nums[nums.length-1] != arry[nums.length-1]) {
                return 0;
            }
        }

        int start = 1;
        int end = nums.length-2;
        boolean startFlg = false;
        boolean endFlg = false;
        while (start < end ) {
            int [] arryCopy = Arrays.copyOfRange(nums,start,end + 1);
            Arrays.sort(arryCopy);
            if(nums[start] == arryCopy[0]) {
                start ++;
            }else {
                startFlg = true;
            }
            if(nums[end] == arryCopy[arryCopy.length -1]) {
                end --;
            }else {
                endFlg = true;
            }

            if(startFlg && endFlg) {
                break;
            }

        }

        return end -start + 1;
    }
}
