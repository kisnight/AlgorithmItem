package slidingWindow.水果成篮_904;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;


//这道题考的知识点就是滑动窗口,调试的时候超时了
public class totalFruit_904 {

    public static void main(String[] args) {
        totalFruit_904 a = new totalFruit_904();
        //int [] arry = {1,2,1};
        int [] arry = {1,2,3,2,2};
        System.out.println(a.totalFruit(arry));

    }

    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2) {
            return fruits.length;
        }
        int maxFruitSum = 0;
        int fruitTypeNum = 0;
        List<Integer> list = new ArrayList<>();
        //遍历水果树，创建滑动窗口
        for(int i = 0; i <=fruits.length-3; i ++) {
            list.add(fruits[i]);
            fruitTypeNum ++;
            for(int j = i+1; j <= fruits.length -1; j++){
                //针对每个窗口，判断水果种类是否已经到达两种
                if(fruitTypeNum == 2) {
                    //当水果种类已经到达两种，如果没有新的水果种类，那么就可以继续增加水果数量
                    if(list.contains(fruits[j])) {
                        list.add(fruits[j]);
                    }
                    else { //反之，则计算两个篮子所有的水果数量
                        //将当时的窗口的水果数量和maxFruitSum作对比，如果大于maxFruitSum，则重新赋值maxFruitSum
                        maxFruitSum = max(list.size(),maxFruitSum);
                        //将旧的滑动窗口清除
                        list.clear();
                        //将判断水果种类的标志位置false;
                        fruitTypeNum = 0;
                        //停止获取水果数量
                        break;
                    }
                }else { //在水果种类没有达到两种的情况下进行fruitTypeNum的累加
                    if(!list.contains(fruits[j])) {
                        fruitTypeNum ++;
                    }
                    //在水果种类没有达到两种的情况下进行水果数量的累加
                    list.add(fruits[j]);
                }
                //j指标走到了fruit数组最后一个元素
                if(j == fruits.length -1) {
                    //将当时的窗口的水果数量和maxFruitSum作对比，如果大于maxFruitSum，则重新赋值maxFruitSum
                    maxFruitSum = max(list.size(),maxFruitSum);
                    //将旧的滑动窗口清除
                    list.clear();
                    //将判断水果种类的标志位置false;
                    fruitTypeNum = 0;
                }

            }

        }

        return max(maxFruitSum,2);
    }


}
