package characterString.字符串解码_394;

import java.util.Stack;


/*
1、如果遇到 ']'，就一直在栈中找到 '['，将之间的字符连接起来，将 '['前面的数字连接起来作为出现次数再次压栈
2、遇到数字、字母、'['就直接压栈，最后将栈里的字符串弹出连接起来就ok了
 */
public class decodeString_394 {

    public static void main(String[] args) {
        decodeString_394 a = new decodeString_394();
        String s = "100[leetcode]";
        System.out.println(a.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int index = 0; index <= s.length()-1; index ++) {
            if(s.charAt(index) == ']') {
                String str = "";
                StringBuilder strBuilder = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    strBuilder.append(stack.pop());
                }
                //将“[”从栈里面pop出去
                stack.pop();
                str = strBuilder.toString();
                StringBuilder reStrBuilder = new StringBuilder();
                String reStr = "";
                String countStr = "";
                //这一步非常重要，因为如果重复次数是100这种多位数的，而每一次只能弹出一位数，所以就要循环构建出来
                while(!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    countStr = stack.pop() + countStr;
                }
                int count = Integer.parseInt(countStr);
                for(int i = 0; i <= count -1; i++) {
                    reStrBuilder.append(str);
                }
                reStr = reStrBuilder.toString();

                stack.push(reStr);
            } else {
                stack.push(s.charAt(index) + "");
            }
        }

        StringBuilder retString = new StringBuilder();
        while(!stack.isEmpty()) {
            retString.append(stack.pop());
        }
        return retString.reverse().toString();
    }
}
