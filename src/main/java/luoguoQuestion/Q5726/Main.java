package luoguoQuestion.Q5726;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int minNumber = Integer.MAX_VALUE,maxNumber = Integer.MIN_VALUE,sum =0;
        for(int i=0;i<numberCount;++i){
            int inputNumber = scanner.nextInt();
            if(inputNumber > maxNumber){maxNumber=inputNumber;}
            if(inputNumber < minNumber){minNumber=inputNumber;}
            sum+=inputNumber;
        }
        sum-=minNumber;
        sum-=maxNumber;
        System.out.printf("%.2f",(sum+0.0)/(numberCount-2));
    }
}
