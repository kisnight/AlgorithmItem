package characterString.无重复字符的最长子串_3;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        lengthOfLongestSubstring_3 a = new lengthOfLongestSubstring_3();
        String s = "abcabcbb";

        System.out.println(a.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int max = 0;
        int temCout = 0;
        Set<Character> tempSet = new HashSet<>();
        for(int i = 0; i < s.length() - 1; i ++) {
            tempSet.add(s.charAt(i));
            temCout ++;
            for(int j = i + 1; j < s.length(); j ++) {
                if(!tempSet.contains(s.charAt(j))) {
                    tempSet.add(s.charAt(j));
                    temCout ++;

                }else {
                    break;
                }
            }
            max = Math.max(max, temCout);
            tempSet.clear();
            temCout = 0;
        }
        return max;
    }
}
