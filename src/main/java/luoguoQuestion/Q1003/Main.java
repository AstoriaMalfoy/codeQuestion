package luoguoQuestion.Q1003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] table = new int[200000][200000];
        while(n-- > 0){
            int b = scanner.nextInt();
            int a = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(int i =0;i<y;i++){
                for(int j=0;j<x;++j){
                    table[a+i][b+j]++;
                }
            }
        }
        int resultX = scanner.nextInt();
        int resultY = scanner.nextInt();
        System.out.println(table[resultY][resultX]);
    }
}
