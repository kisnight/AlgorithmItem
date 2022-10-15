package array.最接近的三数之和_16;

/*
思路：
先排序, 然后遍历, 然后内部使用双指针
 */
import java.util.Arrays;

public class threeSumClosest_16 {

    public static void main(String[] args) {
        threeSumClosest_16 a = new threeSumClosest_16();
        int [] arry = {-1,2,1,-4};
        System.out.println(a.threeSumClosest(arry, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int tempSum;
        boolean start = true;
        for(int i = 0; i <= nums.length - 3; i++) {
            //使用双指针进行数据的判定
            int leftIndex = i+1;
            int rightIndex = nums.length - 1;
            while(leftIndex < rightIndex) {
                if(start) {
                    tempSum = sum;
                    start = false;
                }else {
                    //这里是获取最接近target的和
                    tempSum = nums[i] + nums[leftIndex] + nums[rightIndex];
                    if(Math.abs(tempSum - target) < Math.abs(sum - target)) {
                        sum = tempSum;
                    }
                }

                if(tempSum < target) {
                    leftIndex ++;
                }else if(tempSum > target) {
                    rightIndex --;
                }else {
                    //如果已经等于target的话, 肯定是最接近的
                    return target;
                }
            }
        }
        return sum;
    }
}
