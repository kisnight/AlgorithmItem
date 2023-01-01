package backTracking.单词拆分_139_repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordBreak_139_repeat {

    public static void main(String[] args) {
        wordBreak_139_repeat a = new wordBreak_139_repeat();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();

//        wordDict.add("leet");
//        wordDict.add("code");

        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        //        String [] wordDict = new String [] {"leet", "code"};
        System.out.println(a.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        return dfs(s, 0, wordDict, map);
    }

    private boolean dfs(String s, int startIndex, List<String> wordDict, Map<Integer, Boolean> map) {

        // 构建参数

        // 构建终止条件
        if(startIndex == s.length()) {
            return true;
        }
        // 构建在递归中需要做的动作
        // 这里是非常关键的，这个地方一直想不通
        if(map.containsKey(startIndex)){
            return false;
        }
        // 构建递归，循环递归还是单一递归；
        for(int i = startIndex; i < s.length(); i ++) {
            String subWord = s.substring(startIndex, i+1);
            if(wordDict.contains(subWord)) {
                if (dfs(s, i+1, wordDict, map)) {
                    return true;
                }
            }

            // 这里是非常关键的
            map.put(startIndex, false);
        }

        return false;
    }

}
