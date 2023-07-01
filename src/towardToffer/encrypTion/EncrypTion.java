package towardToffer.encrypTion;

import com.sun.xml.internal.ws.util.StringUtils;
import towardToffer.triCode.TriCoding;

import java.util.ArrayList;
import java.util.List;

public class EncrypTion {

    public static void main(String[] args)
    {
        // 测试用例
        EncrypTion t = new EncrypTion();
        System.out.println(t.encryption("hellorfetywuwww", "234137"));
    }


    public String encryption(String plaintext,String key) {
        if(plaintext == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        result.append(plaintext);
        int temp;
        for(int i = 0; i < plaintext.length(); i ++) {
            // 获取到该字节所对应的key的数字
            char ch = key.charAt(i % key.length());
            // 判断i是偶数位还是奇数位
            if(i % 2 == 0) {
                temp = plaintext.charAt(i) + ch;
                if(temp > 122) {
                    temp = temp - 48;
                }
                result.setCharAt(i, (char) temp);
            }else {
                temp = plaintext.charAt(i) - ch;
                if(temp < 97) {
                    temp = temp + 48;
                }
                result.setCharAt(i, (char) temp);
            }

        }

        return result.toString();
    }


    public String encryption1(String plaintext,String key) {
        int temp;
        StringBuilder result = new StringBuilder(plaintext.length());
        result.append(plaintext);
        for (int i = 0;i < plaintext.length();i++) {
            char c = key.charAt(i % key.length()); //从左到右每次从秘钥中取出一个数字字符，得到该字符的数字值K，若到达秘钥的最后则从头开始取
            if (i % 2 == 0) { //偶数位
                temp = (int) (plaintext.charAt(i)) + c;
                if (temp > 122) { //这里偶数位是加法运算，所以只有可能相加之后的ASCLL值大于'z'的ASCLL值，因此不用考虑小于'a'的情况
                    char temp1 = (char) (temp - 48);
                    result.setCharAt(i, temp1);
                }else { //这里的else主要指的是相加之后的ASCLL值还处在'a'~'z'之间
                    char temp1 = (char) temp;
                    result.setCharAt(i, temp1);
                }
            }else { //奇数位
                temp = (int) (plaintext.charAt(i)) - c;
                if (temp < 97) { //这里奇数位是减法运算，所以只有可能相减之后的ASCLL值小于'a'的ASCLL值，因此不用考虑大于'z'的情况
                    char temp1 = (char) (temp + 48);
                    result.setCharAt(i, temp1);
                }else { //这里的else主要指的是相减之后的ASCLL值还处在'a'~'z'之间
                    char temp1 = (char) temp;
                    result.setCharAt(i, temp1);
                }
            }
        }

        return result.toString();
    }

}
