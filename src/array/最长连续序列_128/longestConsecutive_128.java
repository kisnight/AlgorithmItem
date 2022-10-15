package array.最长连续序列_128;

import java.util.HashSet;
import java.util.TreeSet;

public class longestConsecutive_128 {

    public static void main(String[] args) {
        longestConsecutive_128 a = new longestConsecutive_128();
        int [] arry = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(a.longestConsecutive(arry));
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer item : nums) {
            set.add(item);
        }
        TreeSet<Integer> treeSet = new TreeSet<>(set);
        int preValue = 0;
        Boolean isFirstItem = true;
        int seriseCount = 0;
        int tmpSeriseCount = 0;
        for(Integer item : treeSet) {
            if(isFirstItem) {
                tmpSeriseCount ++;
                preValue = item;
                isFirstItem = false;
            }else {
                if(item == preValue + 1) {
                    tmpSeriseCount ++;
                    preValue = item;
                }else {
                    if(tmpSeriseCount > seriseCount) {
                        seriseCount = tmpSeriseCount;
                    }
                    tmpSeriseCount = 1;
                    preValue = item;
                }
            }
        }

        if(tmpSeriseCount > seriseCount) {
            seriseCount = tmpSeriseCount;
        }

        return seriseCount;
    }
}
