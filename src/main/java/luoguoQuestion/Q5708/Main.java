package luoguoQuestion.Q5708;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double p = (a+b+c)/2.0;
        BigDecimal bigDecimal = new BigDecimal(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
        double result = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        System.out.println(result);
    }
}
