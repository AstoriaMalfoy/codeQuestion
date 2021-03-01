package luoguoQuestion.Q2181;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long lineCount = scanner.nextInt();
        if(lineCount <= 3){
            System.out.println("0");
        }else if(lineCount <= 4){
            System.out.println("1");
        }else{
            BigInteger result ;
            result = BigInteger.valueOf(lineCount).multiply(BigInteger.valueOf(lineCount-1)).multiply(BigInteger.valueOf(lineCount-2)).multiply(BigInteger.valueOf(lineCount-3)).divide(BigInteger.valueOf(24));
            System.out.printf(result.toString());
        }
    }
}
