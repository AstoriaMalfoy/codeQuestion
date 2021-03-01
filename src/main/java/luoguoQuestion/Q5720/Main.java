package luoguoQuestion.Q5720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int baseNumber = scanner.nextInt();
        int cutTime = 1;
        while(baseNumber!=1){
            cutTime ++;
            baseNumber/=2;
        }
        System.out.println(cutTime);
    }
}
