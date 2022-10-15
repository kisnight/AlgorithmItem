package array.分割字符串的方案数_1573;

//当字符串都是0的时候
//计算出每个子字符串中1的数量
//遍历数组，当获取到1的数量的最大值时就开始计算后面0的数量，当再遇到1时，就重新计算1的数量和0的数量，直到再次遇到1则返回
//将两个子字符串的所有情况condition1和condition2相乘得出结果

/*
这个题虽然最后一点没有跑过，但是算法是没问题的
而且161/164的用例跑的还是比较理想
 */
public class numWays_1573 {
    private final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        numWays_1573 a = new numWays_1573();
        String s = "000000";
        System.out.println(a.numWays(s));
    }

    public int numWays(String s) {
        //1的数量小于三或者余3不等于0，返回0
        char[] charArr = s.toCharArray();
        int sumOne = 0;
        for(Character item: charArr) {
            if(item.equals('1')) {
                sumOne ++;
            }
        }
        //字符串全部都是0
        if(sumOne == 0) {
            int k = 2;
            int n = s.length() -1 ;
            return combination(k,n);
        }

        //字符串全部都是1但是余3不等于0
        if(sumOne % 3 != 0) {
            return 0;
        }

        //字符串全部都是1而且余3等于0
        if(sumOne == s.length() && (sumOne % 3 == 0)) {
            return 1;
        }

        //当字符串1的数量可以被平均分成3份的时候
        int avergaOne = sumOne / 3;
        int countOne = 0;
        int countZero = 0;
        int strTimes = 1;
        int str1Contidion = 0;
        int str2Contidion = 0;
        Boolean startCountZero = false;
        for (Character item: charArr) {
            if(startCountZero) {
                //当再遇到1时,计算两个子字符串的所有情况condition1和condition2
                if(item.equals('1')) {
                    if(strTimes == 1) {
                        startCountZero = false;
                        str1Contidion = countZero + 1;
                        strTimes ++;
                        countZero = 0;
                    }else {
                        str2Contidion = countZero + 1;
                        break;
                    }
                }else {
                    //统计一个滑动窗口中0的数量
                    countZero ++;
                }

            }
            //开始计算1的数量是否等于每个子串的1的平均数；
            if(!startCountZero) {
                if (item.equals('1')) {
                    countOne++;
                    if (countOne == avergaOne) {
                        startCountZero = true;
                        countOne = 0;
                    }
                }
            }

        }
        //将两个子字符串的所有情况condition1和condition2相乘得出结果
        return str1Contidion * str2Contidion % MOD;

    }
    public int combination(int k, int n) {
        int a = 1, b = 1;
        for(int i = 1; i <= k; i++) {
            a *= (n - i + 1);
            b *= i;
        }
        return a / b;
    }
}
