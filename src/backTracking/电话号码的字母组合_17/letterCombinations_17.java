package backTracking.电话号码的字母组合_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations_17 {
    StringBuilder sb = new StringBuilder();
    List<String> ret = new ArrayList<>();

    public static void main(String[] args) {
        letterCombinations_17 a = new letterCombinations_17();
        System.out.println(a.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)) {
            return ret;
        }
        Map<Integer, String> digitMap = new HashMap<>();
        digitMap.put(0, "");
        digitMap.put(1, "");
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");

        buildCharCombinations(digitMap, digits, 0);
        return ret;
    }

    /*
    digitMap表明的是每个数字对应的字符串；
    digits 表明传进来的数字字符串 比如“23”
    digitIndex 表明此次递归是数字字符串中的哪个数字对应的字符串，比如‘2’ -> "abc"
    */
    private void buildCharCombinations(Map<Integer, String> digitMap, String digits, int digitIndex) {
        // 满足条件为sb中的字符数量等于数字字符串的长度，比如字符串 = “23”， 那么触发条件就是sb.length() == 2
        if(sb.length() == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        // 获取到目前的单个电话号码，即 2，但是后面需要加一个“- '0'”,不然不能转化成int型
        int digitNumber = digits.charAt(digitIndex) - '0';
        // 从map中获取根据单个电话号码获取到对应的字符串；即 2 -> "abc"
        String digitNumberToCharStr = digitMap.get(digitNumber);
        if("".equals(digitNumberToCharStr)) {
            return;
        }
        // 外层遍历"abc"这个字符串
        for(int i = 0; i < digitNumberToCharStr.length(); i ++) {
            // 首先将单个字节加入进去，即 ‘a’
            sb.append(digitNumberToCharStr.charAt(i));
            // 递归下一个电话号码，即 “23”中的 ‘3’， 因此digitIndex 要加1
            buildCharCombinations(digitMap, digits, digitIndex + 1);
            // 记住这里删除的时候，digitIndex = 1,其实就是已经找到了一组符合条件的字符串，即“ad”,然后退出来的时候需要将'd'这个元素删掉
            sb.deleteCharAt(digitIndex);
        }
    }
}
