package luoguoQuestion.Q1425;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int min = (c-a-1)*60 + (60-b) + d;
        System.out.println(min / 60 +" "+min % 60);
    }
}
