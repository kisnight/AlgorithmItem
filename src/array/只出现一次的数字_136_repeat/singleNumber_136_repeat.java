package array.只出现一次的数字_136_repeat;

import java.util.HashMap;
import java.util.Map;

public class singleNumber_136_repeat {

    public static void main(String[] args) {
        singleNumber_136_repeat a = new singleNumber_136_repeat();
        int [] arr = new int []{4,1,2,1,2};

        System.out.println(a.singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer item : nums) {
            if(map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }else {
                map.put(item, 1);
            }
        }
        for(Integer item : map.keySet()) {
            if(map.get(item) == 1) {
                return item;
            }
        }
        return 0;
    }

}
