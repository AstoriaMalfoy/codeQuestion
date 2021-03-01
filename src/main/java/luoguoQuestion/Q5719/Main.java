package luoguoQuestion.Q5719;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int sumA = 0,numA =0;
        int sumB = 0,numB =0;
        for(int i=1;i<=n;++i){
            if(i % k == 0){
                sumA+=i;numA++;
            }else{
                sumB+=i;numB++;
            }
        }
        double resultA = ((double)sumA)/numA;
        double resultB = ((double)sumB)/numB;
        System.out.printf("%.1f %.1f",resultA,resultB);
    }
}
