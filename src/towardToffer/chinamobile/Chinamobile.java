package towardToffer.chinamobile;

import java.util.Scanner;

public class Chinamobile {
    private static boolean isAttack(int A,int B,int C,int[] pos){
        //其实是任意的两个以上同时等于0则认为是受攻击的
        //处理特殊的情况
        int zeroCount = 0;
        if((A*pos[0] + B*pos[1] + C) == 0) {
            zeroCount++;
        }
        if((A*pos[2] + B*pos[3] + C) == 0) {
            zeroCount++;
        }
        if((A*pos[4] + B*pos[5] + C) == 0) {
            zeroCount++;
        }
        if((A*pos[6] + B*pos[7] + C) == 0) {
            zeroCount++;
        }
        if(zeroCount >= 2) {
            return true;
        }

        boolean flag1 = (A*pos[0] + B*pos[1] + C) > 0?true:false;
        boolean flag2 = (A*pos[2] + B*pos[3] + C) > 0?true:false;
        boolean flag3 = (A*pos[4] + B*pos[5] + C) > 0?true:false;
        boolean flag4 = (A*pos[6] + B*pos[7] + C) > 0?true:false;
        if(flag1 == flag2&& flag2 == flag3 && flag3 == flag4) {
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int N = sc.nextInt();

            int[] pos = new int[8];
            for(int m = 0;m<8;m++){
                pos[m] = 0;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<N;i++){  //每一行有4个坐标
                pos[0] = sc.nextInt();
                pos[1] = sc.nextInt();
                pos[2] = sc.nextInt();
                pos[3] = sc.nextInt();
                pos[4] = sc.nextInt();
                pos[5] = sc.nextInt();
                pos[6] = sc.nextInt();
                pos[7] = sc.nextInt();
                if(isAttack(A,B,C,pos)){
                    sb.append("1").append("\n");
                }else{
                    sb.append("-1").append("\n");
                }
            }
            System.out.println(sb.toString().trim());

        }
    }
}
