package array.有效的正方形_593;

import java.util.Arrays;

public class validSquare_593 {

    public static void main(String[] args) {
        validSquare_593 a = new validSquare_593();
//        int [] p1 = {1,1};
//        int [] p2 = {5,3};
//        int [] p3 = {3,5};
//        int [] p4 = {7,7};

//        int [] p1 = {0,0};
//        int [] p2 = {1,1};
//        int [] p3 = {1,0};
//        int [] p4 = {0,1};

        int [] p1 = {0,1};
        int [] p2 = {1,1};
        int [] p3 = {1,1};
        int [] p4 = {1,0};

        System.out.println(validSquare(p1,p2,p3,p4));

    }
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        /*
            分三种情况
            1、p1->p2->p3->p4
            2、p1->p2->p4->p3
            3、p1->p3->p2->p4
         */
        if(Arrays.equals(p1,p2) && Arrays.equals(p2,p3) && Arrays.equals(p3,p4)) {
            return false;
        }
        if(validSquareSub(p1, p2, p3, p4)) {
            return true;
        }
        if(validSquareSub(p1, p2, p4, p3)) {
            return true;
        }
        if(validSquareSub(p1, p3, p2, p4)) {
            return true;
        }
        return false;
    }
    private static boolean validSquareSub(int[] p1, int[] p2, int[] p3, int[] p4) {
        /*
        x=p[0]
        y=p[1]
         */
        //计算各个边长的值
        float p1P2 = twoPointDistance(p1, p2);
        float p2P3 = twoPointDistance(p2, p3);
        float p3P4 = twoPointDistance(p3, p4);
        float p4P1 = twoPointDistance(p4, p1);
        //计算对角线的值
        float p1P3 = twoPointDistance(p1, p3);
        float p2P4 = twoPointDistance(p2, p4);

        if(!judgeTwoDistanceEqual(p1P2,p2P3)) {
            return false;
        }
        if(!judgeTwoDistanceEqual(p2P3,p3P4)) {
            return false;
        }
        if(!judgeTwoDistanceEqual(p3P4,p4P1)) {
            return false;
        }

        if((!judgeTwoDistanceEqual(p1P3, p2P4))) {
            return false;
        }

        if(!judgeThreeDistance(p1P2, p2P3, p1P3)) {
            return false;
        }

        return true;
    }

    private static float twoPointDistance(int[] p1, int[] p2) {
        return (float) (Math.pow(Math.abs(p1[0] - p2[0]),2) + Math.pow(Math.abs(p1[1] - p2[1]),2));
    }

    private static boolean judgeTwoDistanceEqual(float p1P2, float p2P3) {
        if(Math.abs(p1P2 - p2P3) == 0) {
            return true;
        }
        return false;
    }

    private static boolean judgeThreeDistance(float p1P2, float p2P3, float p1P3) {
        float value = p1P2 + p2P3;
        return judgeTwoDistanceEqual(value,p1P3);
    }

}
