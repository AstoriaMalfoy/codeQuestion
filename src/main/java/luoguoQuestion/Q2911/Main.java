package luoguoQuestion.Q2911;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s1 = scanner.nextInt();
        int s2 = scanner.nextInt();
        int s3 = scanner.nextInt();
        int[] countList = new int[81];
        int sumMax = 0,resultPositon=-1;
        for(int i=1;i<=s1;++i){
            for(int j=1;j<=s2;++j){
                for(int k=1;k<=s3;++k){
                    int sum = i+j+k;
                    countList[sum]++;
                }
            }
        }
        for(int i=0;i<=80;++i){
            if(sumMax < countList[i]){
                sumMax = countList[i];
                resultPositon = i;
            }
        }
        System.out.println(resultPositon);
    }
}
