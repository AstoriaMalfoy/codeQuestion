package luoguoQuestion.Q1420;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int result =0;
        int tempResult=1;
        int tempValue = -1;
        for(int i=0;i<numberCount;++i){
            int inputValue = scanner.nextInt();
            if(i==0){
                tempValue=inputValue;
            }
            if(inputValue == tempValue+1){
                tempResult++;
                tempValue++;
            }else{
                tempValue = inputValue;
                if(tempResult > result){
                    result = tempResult;
                }
                tempResult = 1;
            }

        }
        System.out.println(result);
    }
}
