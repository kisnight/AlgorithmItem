package array.最接近的三数之和_16_repeat;

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
        // 顺序排序
        Arrays.sort(nums);
        // 这是真正要返回的三个数之和
        int threeSum = nums[0] + nums[1] + nums[nums.length - 1];
        // 这是三个数之和的中间结果
        int tempThreeSum;
        // 定住第一个数的下标
        for(int i = 0; i <= nums.length - 3; i ++) {
            // 第二个数的开始下标，从i + 1开始
            int leftIndex = i + 1;
            // 第三个数的开始下标，从最右边开始
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                // 获取到三个数之和的中间结果
                tempThreeSum = nums[i] + nums[leftIndex] + nums[rightIndex];
                // 判断中间结果和target的大小关系
                if(tempThreeSum == target) {
                    return target;
                }
                // 如果大了，就把右边的数往左边移动
                if(tempThreeSum > target) {
                    rightIndex --;
                }else {
                    // 如果小了，就把左边的数往右边移动
                    leftIndex ++;
                }

                // 这里是获取最接近target的和
                if(Math.abs(tempThreeSum - target) < Math.abs(threeSum - target)) {
                    threeSum = tempThreeSum;
                }
            }
        }
        return threeSum;
    }
}
