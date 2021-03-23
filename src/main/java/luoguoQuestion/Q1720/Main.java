package luoguoQuestion.Q1720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long a=0,b=1;
        long c = b;
        if(number == 1 ){
            System.out.println("1.00");
        }else if(number == 0){
            System.out.println("0.00");
        }
        else{
            for(int i=2;i<=number;i++){
                c = a+b;
                a = b;
                b = c;
            }
            System.out.println(c+".00");
        }

    }
}
