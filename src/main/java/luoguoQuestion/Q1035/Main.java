package luoguoQuestion.Q1035;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        double  sum = 0;
        int result = 1;
        while(sum < k){
            sum += 1L/(double)result;
            result++;
        }
        System.out.println(result-1);
    }
}
