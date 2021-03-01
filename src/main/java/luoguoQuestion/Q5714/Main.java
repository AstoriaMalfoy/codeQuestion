package luoguoQuestion.Q5714;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static final double UNDERWEIGHT = 18.5;
    private static final double NORMAL = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double h = scanner.nextDouble();
        double value = m/(h*h);
        if(value < UNDERWEIGHT){
            System.out.println("Underweight");
        }else if(value <  NORMAL){
            System.out.println("Normal");
        }else{
            BigDecimal bigDecimal = new BigDecimal(value);
            int zCount = 0;
            double temp = value;
            while(temp % 10 != 0 && temp > 1){
                zCount ++;
                temp /= 10;
            }
            double result = bigDecimal.setScale(6-zCount,BigDecimal.ROUND_HALF_DOWN).doubleValue();
            System.out.println(result);
            System.out.println("Overweight");
        }
    }
}
