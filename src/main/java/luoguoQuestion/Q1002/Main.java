package luoguoQuestion.Q1002;

import java.util.Scanner;

/**
 * @author Administrator
 */
public class Main {

    private static int hx;
    private static int hy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bx = scanner.nextInt();
        int by = scanner.nextInt();
        hx = scanner.nextInt();
        hy = scanner.nextInt();
        long[][] stepTable = new long[bx +1][by +1];
//        初始化右下角步数
        stepTable[bx][by]=1;
        for(int i = bx; i>-1 ; i--){
            for(int j = by; j>-1 ; j--){
                //判断点处于右下角
                if(i== bx && j == by){
                    if(isHorseStep(i,j)){
                        stepTable[i][j] = 0;
                    }else{
                        stepTable[i][j] = 1;
                    }
                }
                //判单点处于最下面一行
                else if(i == bx){
                    if(isHorseStep(i,j)){
                        stepTable[i][j] = 0;
                    }else{
                        stepTable[i][j] = stepTable[i][j+1];
                    }
                }
                //判断点处于最右侧一行
                else if(j== by){
                    if(isHorseStep(i,j)){
                        stepTable[i][j] = 0;
                    }else{
                        stepTable[i][j] = stepTable[i+1][j];
                    }
                }
                //处于普通位置
                else{
                    if(isHorseStep(i,j)){
                        stepTable[i][j] = 0;
                    }else{
                        stepTable[i][j] = stepTable[i+1][j] + stepTable[i][j+1];
                    }
                }
            }
        }
        System.out.println(stepTable[0][0]);
    }
    public static boolean isHorseStep(int x,int y){
        if(x == hx && y == hy){return true;}
        if(x==hx+1 && (y==hy+2||y==hy-2)){return true;}
        if(x==hx-1 && (y==hy+2||y==hy-2)){return true;}
        if(x==hx-2 && (y==hy+1||y==hy-1)){return true;}
        if(x==hx+2 && (y==hy+1||y==hy-1)){return true;}
        return false;
    }
}
