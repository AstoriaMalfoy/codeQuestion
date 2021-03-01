package luoguoQuestion.Q5715;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = Math.max(Math.max(a,b),c);
        int min = Math.min(Math.min(a,b),c);
        int middle = a ^ b ^ c ^ max ^ min;
        System.out.println(min + " " + middle + " " + max);
    }
}
