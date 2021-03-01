package luoguoQuestion.Q5706;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = scanner.nextDouble();
        int person = scanner.nextInt();
        BigDecimal bigDecimal = new BigDecimal(sum/person);
        System.out.println(bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println(person*2);
    }
}
