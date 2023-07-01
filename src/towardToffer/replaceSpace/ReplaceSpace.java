package towardToffer.replaceSpace;

import array.整数转罗马数字_12.intToRoman_12;

/*
题目描述：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace a = new ReplaceSpace();
        String str = "We Are Happy";
        System.out.println(a.relpaceSpace1(str));
    }

    public String replaceSpace(String str) {
        if(str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public String relpaceSpace1(String str) {
        if(str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) == ' ') {
                sb.append("20%");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
