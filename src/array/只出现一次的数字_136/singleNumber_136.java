package array.只出现一次的数字_136;

import java.util.HashMap;

public class singleNumber_136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for(Integer itm : nums) {
            if(tempMap.containsKey(itm)) {
                tempMap.put(itm, tempMap.get(itm) + 1);
            }else {
                tempMap.put(itm, 1);
            }
        }

        for(Integer item : tempMap.keySet()) {
            if(tempMap.get(item) == 1) {
                return item;
            }
        }
        return 0;
    }
}
