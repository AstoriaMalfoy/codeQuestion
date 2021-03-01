package luoguoQuestion.Q1009;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        BigInteger bigInteger = BigInteger.valueOf(0);
        for(int i=1;i<=number;++i){
            bigInteger = bigInteger.add(getMul(i));
        }
        System.out.println(bigInteger.toString());
    }


    public static BigInteger getMul(int number){
        BigInteger bigInteger = BigInteger.valueOf(1);
        for(int i=1;i<=number;++i){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }
}
