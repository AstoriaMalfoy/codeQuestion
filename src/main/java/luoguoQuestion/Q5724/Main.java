package luoguoQuestion.Q5724;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<number;++i){
            int inputNumber = scanner.nextInt();
            if(inputNumber > maxValue){
                maxValue = inputNumber;
            }
            if(inputNumber < minValue){
                minValue = inputNumber;
            }
        }
        System.out.println(maxValue-minValue);
    }
}
