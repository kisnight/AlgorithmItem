package towardToffer.MaxInWindows;

import java.util.ArrayList;
import java.util.List;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> retList = new ArrayList<>();
        if(num.length == 0 || size == 0) {
            return retList;
        }

        if(num.length < size) {
            return retList;
        }

        for(int i = 0; i <= num.length - size; i ++) {
            int max = num[i];
            for(int j = i; j < i + size; j ++) {
                if(max < num[j]) {
                    max = num[j];
                }
            }
            retList.add(max);
        }
        return retList;
    }
}
