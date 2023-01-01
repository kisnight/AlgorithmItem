package array.最短无序连续子数组_581_repeat;

/*
    解题思路：
    1、如果最右端的一部分已经排好序，这部分的每个数都比它左边的最大值要大，
    2、同理，如果最左端的一部分排好序，这每个数都比它右边的最小值小。
    3、所以我们从左往右遍历，如果i位置上的数比它左边部分最大值小，则这个数肯定要排序，就这样找到右端不用排序的部分，
    4、同理找到左端不用排序的部分，它们之间就是需要排序的部分
 */
public class findUnsortedSubarray_581_repeat {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int leftMax = Integer.MIN_VALUE;
        int toRightIndex = 0;
        // 记住这里的toRightIndex肯定比toLeftIndex大
        for(int i = 0; i < nums.length; i ++) {
            // 当所在元素比左边的最大值都小的时候，说明不是一个递增元素，该元素需要进行排序
            if(nums[i] < leftMax) {
                // 将需要排序的下标赋予到toRightIndex中
                toRightIndex = i;
            }
            // 每次遍历将左边的最大值都更新一下
            leftMax = Math.max(leftMax, nums[i]);
        }

        int rightMin = Integer.MAX_VALUE;
        int toLeftIndex = 0;
        for(int j = nums.length - 1; j >= 0; j --) {
            // 当所在元素比右边的最小值都大的时候，说明不是一个递减元素，该元素需要进行排序
            if(nums[j] > rightMin) {
                toLeftIndex = j;
            }
            // 每次遍历将右边的最小值都更新一下
            rightMin = Math.min(rightMin, nums[j]);
        }

        if(toRightIndex == toLeftIndex) {
            return 0;
        }

        return toRightIndex - toLeftIndex + 1 ;
    }
}
