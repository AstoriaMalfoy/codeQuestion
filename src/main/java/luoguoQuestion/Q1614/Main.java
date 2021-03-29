package luoguoQuestion.Q1614;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCount = scanner.nextInt();
        int sumCount = scanner.nextInt();

        int[] numberList = new int[numberCount];
        int firstIndex = 0;
        long currentSum = 0;
        long minSum = Integer.MAX_VALUE;

        if(numberCount == 0 || sumCount == 0){
            System.out.println("0");
            return;
        }
        for(int i=0;i<numberCount;++i){
            int inputNumber = scanner.nextInt();
            numberList[i] = inputNumber;
            if(i<sumCount-1){
                currentSum+=inputNumber;
            }else if(i == sumCount-1){
                currentSum+=inputNumber;
                if(currentSum < minSum){
                    minSum = currentSum;
                }
            }else{
                currentSum += inputNumber;
                currentSum -= numberList[firstIndex];
                firstIndex++;
                if(currentSum < minSum){
                    minSum = currentSum;
                }
            }
        }

        System.out.println(minSum);
    }
}