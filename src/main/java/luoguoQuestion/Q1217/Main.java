package luoguoQuestion.Q1217;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i=a;i<=b;++i){
            if(isPrime(i) && isHuiwenshu(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isHuiwenshu(int number){
        String str = String.valueOf(number);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = str.length()-1;i>=0;--i){
            stringBuilder.append(str.charAt(i));
        }
        if(Integer.parseInt(str) == Integer.parseInt(stringBuilder.toString())){
            return true;
        }else{
            return false;
        }

    }
    public static boolean isPrime(int number){
        for(int i=2;i<number/2;i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
