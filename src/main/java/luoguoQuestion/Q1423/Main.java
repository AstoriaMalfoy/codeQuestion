package luoguoQuestion.Q1423;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNumber = scanner.nextDouble();
        double sum = 0;
        double currentStep=2L;
        int result=0;
        while(sum < inputNumber){
            sum+=currentStep;
            currentStep*=0.98;
            result++;
        }
        System.out.print(result);
    }
}
