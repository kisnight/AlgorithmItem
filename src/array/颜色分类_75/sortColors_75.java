package array.颜色分类_75;

import java.util.Arrays;

public class sortColors_75 {

    public static void main(String[] args) {
        sortColors_75 a = new sortColors_75();
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

        //记录下0,1,2三个元素的出现次数
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i<=nums.length -1; i++) {
            if(nums[i] == 0) {
                count0 ++;
                continue;
            }

            if(nums[i] == 1) {
                count1 ++;
                continue;
            }

            if(nums[i] == 2) {
                count2 ++;
            }
        }
        //对于三个元素，分别填入到nums数组中的次数
        if(count0 > 0) {
            Arrays.fill(nums,0,count0,0);
        }
        if(count1 > 0) {
            Arrays.fill(nums,count0,count0 + count1 ,1);
        }
        if(count2 > 0) {
            Arrays.fill(nums,count0 + count1,nums.length,2);
        }

        return nums;
    }

    //方法二：采用的是指针方法，但是边界比较难确定导致跑不过，因此不推荐
/*
    public int[] sortColors(int[] nums) {
        if(nums.length == 1 || nums.length == 2) {
            Arrays.sort(nums);
            return nums;
        }

        int index = 0;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == 0) {
                //如果index所对应的数值不等于0，就做替换
                if(nums[index] != 0) {
                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i]= tmp;
                    //exchangeValue(nums[index],nums[i]);
                }
                index ++;
            }
        }

        if(nums[index] == 0 || index == 0) {
            index ++;
        }
        //判断index是否在下面的循环中产生变化
        //index ++;

        if(index > nums.length - 2) {
            return nums;
        }

        for(int j = index + 1;j < nums.length;j ++) {
            if(nums[j] == 1) {
                if(nums[index] != 1) {
                    int tmp = nums[index];
                    nums[index] = nums[j];
                    nums[j]= tmp;
                    //exchangeValue(nums[index],nums[j]);
                }
                index ++;
            }
        }

        return nums;
    }


    public void exchangeValue(int val1, int val2) {
        int tmp = val1;
        val1 = val2;
        val2 = tmp;
    }
*/



}
