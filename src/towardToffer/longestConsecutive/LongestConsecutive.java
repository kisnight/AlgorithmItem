package towardToffer.longestConsecutive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer item : set) {
            set.add(item);
        }

        List<Integer> integerList = new ArrayList<>(set);
        Collections.sort(integerList);
        int seriseCount = 1;
        int tempSeriseCount = 1;
        int preValue = integerList.get(0);
        for(int i = 1; i < integerList.size(); i ++) {
            if(integerList.get(i) == preValue + 1) {
                tempSeriseCount ++;
                preValue = integerList.get(i);
            } else {

                if(tempSeriseCount > seriseCount) {
                    seriseCount = tempSeriseCount;
                }
                tempSeriseCount = 1;
                preValue = integerList.get(i);
            }
        }

        if(tempSeriseCount > seriseCount) {
            seriseCount = tempSeriseCount;
        }
        return seriseCount;
    }
}
