package array.最长连续序列_128_repeat;

import java.util.*;

/*
    题目理解：数字连续序列表示[1, 2, 3, 4]这种数值的连续，不在乎在数组位置上是否连续
 */
public class longestConsecutive_128_repeat {

    public static void main(String[] args) {
        longestConsecutive_128_repeat a = new longestConsecutive_128_repeat();
        int [] arry = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(a.longestConsecutive(arry));
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        // 将nums数组中的重复元素去掉
        HashSet<Integer> set = new HashSet<>();
        for(Integer item : nums) {
            set.add(item);
        }
        // 将set集合转换成List集合并且排序
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        // seriseCount表示最长数字连续序列的长度
        int seriseCount = 1;
        // 表示最长数字连续序列的长度的中间结果
        int tempSeriseCount = 1;
        /*
            preVal表示在遍历数字连续序列的时候前一个数字的值，
            因为如果是数字连续序列，那么后面一个数字的值必须要比前一个数字大1
         */
        int preVal = list.get(0);
        // i从1开始是因为preVal = list.get(0)已经取了list中的第一个元素了
        for(int i = 1; i < list.size(); i ++) {
            // 判断当前的元素是否比前一个元素大1；如果大1，则tempSeriseCount 加1，并且更新前一个元素preVal的值；
            if(list.get(i) == preVal + 1) {
                tempSeriseCount ++;
                preVal = list.get(i);
            }else {
                /*
                如果当前的元素不比前一个元素大1，那么说明这次窗口遍历结束，
                判断此时的tempSeriseCount是否比seriseCount大
                 */

                if(tempSeriseCount > seriseCount) {
                    seriseCount = tempSeriseCount;
                }
                // 窗口遍历结束后要置位tempSeriseCount = 1并且把preVal恢复到当前遍历的元素
                tempSeriseCount = 1;
                preVal = list.get(i);
            }
        }

        /*
        这是因为最后一次窗口遍历完后很有可能就是连续的数字，
        那么就不会触发tempSeriseCount和seriseCount的比较，所以最后要手动触发一次；
         */
        if(tempSeriseCount > seriseCount) {
            seriseCount = tempSeriseCount;
        }
        // 返回结果
        return seriseCount;
    }
}
