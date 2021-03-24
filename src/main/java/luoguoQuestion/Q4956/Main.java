package luoguoQuestion.Q4956;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
//        52*7*x + 52*(1+2+3+4+5+6)*k
        for(int x = 100;x>0;x--){
            if((number-52*7*x) % 1092 == 0 && (number-52*7*x) / 1092 > 0){
                System.out.println(x);
                System.out.println((number-52*7*x) / 1092);
                break;
            }
        }
    }
}
