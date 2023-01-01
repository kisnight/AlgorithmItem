package study.demo.jerrytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Logger;

public class RangeList {
    private static final Logger LOGGER = Logger.getLogger(RangeList.class.toString());

    private TreeMap<Integer, List<Integer>> rangeMap = new TreeMap<>();

    private boolean add(List<Integer> range) {
        if (range.size() != 2) {
            LOGGER.warning("size of range is wrong.");
            return false;
        }

        List<Integer> keyList = new ArrayList<>(rangeMap.keySet());
        int rangeStartVal = range.get(0);
        int rangeEndVal = range.get(1);
        if (rangeMap.size() == 0) {
            rangeMap.put(rangeStartVal, range);
            return true;
        }
        if (rangeStartVal == rangeEndVal) {
            return true;
        }

        // 找到参数列表范围的启始位置位于rangeMap中key值的那个范围内
        // 参数列表范围的最小值要大于

        if (rangeEndVal <= keyList.get(0)) {
            rangeMap.put(rangeStartVal, range);
            return true;
        }

        if (rangeStartVal >= keyList.get(keyList.size() -1)) {
            rangeMap.put(rangeStartVal, range);
            return true;
        }

        // 如果rangeStartVal小于第一个窗口中的开始位置，并且rangeEndVal要在第一个窗口中间

        // 如果rangeStartVal小于第一个窗口中的开始位置，并且rangeEndVal要在第一个窗口和第二个窗口中间位置

        //
        for (int keyIndex = 0; keyIndex < keyList.size(); keyIndex ++) {
            /*
                1、rangeStartValCur < rangeStartValOld
                   rangeEndValCur > rangeStartValCur && rangeEndValCur < rangeEndValOld
                2、
             */

        }
        return false;
    }


    private boolean remove(int [] range) {
        return true;
    }

    private List<Integer> getRangeOfValue(Integer val, List<Integer> keyList) {
        List<Integer> valRange = new ArrayList<>();
        int low = 0;
        int high = keyList.size() -1;
        while(high != low + 1) {
            int mid = (low + high) / 2;
            if (keyList.get(mid) > val) {
                high = mid;
            }else {
                low = mid;
            }
        }

        valRange.add(low);
        valRange.add(high);
        return valRange;
    }

    private Integer getIndexOfKey(Integer val, List<Integer> keyList) {
        for(int index = 0; index < keyList.size(); index ++) {
            if(keyList.get(index).equals(val)) {
                return index;
            }
        }
        return null;
    }
}
