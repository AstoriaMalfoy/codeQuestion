package luoguoQuestion.Q1075;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int sq = (int) Math.sqrt(Math.abs(inputNumber))+1;
        for(int i=2;i<sq;++i){
            if(inputNumber % i == 0 && isPrime(i) && isPrime(inputNumber / i)){
                if(inputNumber < 0){
                    System.out.println(0-i);
                }else{
                    System.out.println(inputNumber/i);
                }
                break;
            }
        }
    }
    public static boolean isPrime(int number){
        if(number==1){
            return false;
        }
        if(number==2){
            return true;
        }
        int m = (int) Math.sqrt(number) + 1;
        for(int i=2;i<m;++i){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
