package luoguoQuestion.Q5705;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=str.length(); i++) {
            sb.append(str.charAt(str.length()-i));
        }
        System.out.println(sb.toString());
    }
}
