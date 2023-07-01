package towardToffer.firstNotRepeatingChar;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if(str == null) {
            return -1;
        }
        Map<Character, Integer> tempMap = new HashMap<>();
        for(int i = 0; i < str.length(); i ++) {
            if(tempMap.containsKey(str.charAt(i))) {
                int times = tempMap.get(str.charAt(i));
                times ++;
                tempMap.put(str.charAt(i), times);
            }else {
                tempMap.put(str.charAt(i), 1);
            }
        }

        Character retChar = ' ';
        for(Character item : tempMap.keySet()) {
            if(tempMap.get(item) == 1) {
                retChar = item;
                break;
            }
        }
        if(retChar != ' ') {
            return str.indexOf(retChar);
        }
        return -1;
    }
}
