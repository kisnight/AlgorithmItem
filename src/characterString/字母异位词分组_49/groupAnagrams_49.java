package characterString.字母异位词分组_49;

import java.util.*;

public class groupAnagrams_49 {

    /*
    方法一：
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> tempMap = new HashMap<>();
        for(String str : strs) {
            //对于每个字符串，将其转化成数组形式
            char [] charArr = str.toCharArray();
            //对其进行排序处理
            Arrays.sort(charArr);
            //通过上一步的排序可以得到唯一的key
            String key = Arrays.toString(charArr);
            List<String> valueList = tempMap.getOrDefault(key, new ArrayList<String>());
            valueList.add(str);
            tempMap.put(key, valueList);
        }
        List<List<String>> retList = new ArrayList<>(tempMap.values());
        return retList;
    }

    /*
    方法二：比较复杂，超时了
     */
    /***
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> retList = new ArrayList<>();
        if(strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            retList.add(list);
            return retList;
        }

        HashMap<String, List<String>> tempMap = new HashMap<>();
        for(String str : strs) {
            String mapContainStrRet = mapContainStr(tempMap, str);
            if(mapContainStrRet == null) {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                tempMap.put(str, tempList);
            }else {
                List<String> tempList = tempMap.get(mapContainStrRet);
                tempList.add(str);
                tempMap.put(mapContainStrRet, tempList);
            }
        }

        retList.addAll(tempMap.values());
        return retList;

    }


    private String mapContainStr(HashMap<String, List<String>> tempMap, String str) {
        String strSorted = sortStr(str);
        for(String strItem : tempMap.keySet()) {
            if(strItem.length() != str.length()) {
                continue;
            }
            String strItemSorted = sortStr(strItem);
            if(strItemSorted.equals(strSorted)) {
                return strItem;
            }

        }
        return null;
    }

    private String sortStr(String str) {
        char [] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return Arrays.toString(charArr);
    }
     ***/
}
