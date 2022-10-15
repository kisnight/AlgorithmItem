package array.将整数按权重排序_1387;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class getKth_1387 {

    public static void main(String[] args) {
        getKth_1387 a = new getKth_1387();
        System.out.println(a.getKth(7, 11, 4));
    }

    public int getKth(int lo, int hi, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int index = lo; index <= hi; index ++) {
            getRelationMap(index, hashMap);
        }
        HashSet<Integer> hashSet = new HashSet<>(hashMap.values());
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
        List<Integer> tempList = new ArrayList<>();
        List<Integer> retList = new ArrayList<>();
        for(Integer value : treeSet) {
            for(Integer key : hashMap.keySet()) {
                if(Objects.equals(hashMap.get(key), value)) {
                    tempList.add(key);
                }
            }

            Collections.sort(tempList);
            retList.addAll(tempList);
            tempList.clear();

        }

        return retList.get(k - 1);

    }

    public int calcate(int val) {
        if(val % 2 == 0) {
            return val / 2;
        }else {
            return 3 * val + 1;
        }
    }

    public void getRelationMap(int indexVal, HashMap<Integer, Integer> map) {
        int count = 1;
        int calcateVal = calcate(indexVal);
        while (calcateVal != 1) {
            calcateVal = calcate(calcateVal);
            count ++;
        }
        map.put(indexVal, count);
    }


}
