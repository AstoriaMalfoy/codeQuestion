package luoguoQuestion.Q2433;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionNumber = scanner.nextInt();
        switch (questionNumber){
            case 1:
                System.out.println("I love Luogu!");
                break;
            case 2:
                System.out.println((2+4) + " " + (10-2-4));
                break;
            case 3:
                System.out.println(14/4);
                System.out.println(14-(14%4));
                System.out.println(14%4);
                break;
            case 4:
                BigDecimal bigDecimal = new BigDecimal(500/3);
                double result = bigDecimal.setScale(3,BigDecimal.ROUND_HALF_DOWN).doubleValue();
                System.out.println(result);
                break;
            case 5:
                System.out.println(15);
                break;
            case 6:
                double c6result = Math.sqrt(6*6 + 9*9);
                System.out.println(c6result);
                break;
            case 7:
                int c7sum = 100;
                c7sum+=10;
                System.out.println(c7sum);
                c7sum-=20;
                System.out.println(c7sum);
                System.out.println(0);
                break;
            case 8:
                double pi = 3.141593;
                System.out.println(2.0*pi*5.0);
                System.out.println(pi*5.0*5.0);
                System.out.println((4.0/3.0)*pi*5.0*5.0*5.0);
                break;
            case 9:
                System.out.println(22);
                break;
            case 10:
                System.out.println(9);
                break;
            case 11:
                System.out.println(100.0/3.0);
                break;
            case 12:
                System.out.println(13);
                System.out.println("R");
                break;
            case 13:
                double q13pi = 3.141593;
                System.out.println(Math.pow((4.0/3.0)*q13pi*4*4*4+(4.0/3.0)*q13pi*10*10*10,1/3.0));
                break;
            case 14:
                System.out.println(60);
            default:
        }
    }
}
