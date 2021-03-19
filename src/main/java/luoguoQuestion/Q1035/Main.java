package luoguoQuestion.Q1035;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        double sum = 0;
        int result = 0;
        for(double i=1; sum <= number ; ++i){
            sum += 1D/i;
            result++;
        }
        System.out.println(result);
    }
}
