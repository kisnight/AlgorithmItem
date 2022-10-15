package backTracking.单词拆分_139;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordBreak_139 {

    public static void main(String[] args) {
        wordBreak_139 a = new wordBreak_139();
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

    boolean dfs(String s, int start, List<String> wordDict, Map<Integer, Boolean> map) {
        /*
        当s中的一个单词可以在wordDict中找到的时候可以进行递归，并且传入进去的start字段是
        另外一个单词的开头，因此如果进入dfs函数递归的时候start索引就等于字符串的长度的话就
        表明这是最后一个递归，并且上一次递归已经在wordDict中找到了最后一个单词
        */
        if(start == s.length()) {
            return true;
        }
        /*
        能够走入这一个分支，表明start = 0第一个递归失败了，这个时候start = 1，end从2开始，
        后面如果end在累加的时候能够从map中找到，则说明第二轮其实在走第一轮的老路 ，必定是失败的
         */
        if(map.containsKey(start)){
            return false;
        }

        for(int end = start + 1; end <= s.length(); end ++) {
            if(wordDict.contains(s.substring(start, end))) {
                if(dfs(s, end, wordDict, map)) {
                    return true;
                }
            }
            map.put(start, false);
        }
        return false;
    }

}
