package luoguoQuestion.Q5722;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = 0;
        for(int i=0;i<=number;++i){
            result += i;
        }
        System.out.println(result);
    }
}
