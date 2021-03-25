package luoguoQuestion.Q2615;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int[][] outPutTable = new int[inputNumber][inputNumber];
        int x_position=0,y_position=inputNumber/2;
        outPutTable[x_position][y_position] = 1;
        for(int i=2;i<=inputNumber*inputNumber;++i){
            if(x_position == 0 && y_position != inputNumber-1){
                x_position = inputNumber-1;
                y_position++;
                outPutTable[x_position][y_position] = i;
            }else if(x_position != 0 && y_position == inputNumber-1){
                x_position--;
                y_position=0;
                outPutTable[x_position][y_position] = i;
            }else if(x_position == 0 && y_position == inputNumber-1){
                x_position++;
                outPutTable[x_position][y_position] = i;
            }else{
                if(outPutTable[x_position-1][y_position+1] == 0){
                    x_position--;
                    y_position++;
                    outPutTable[x_position][y_position] = i;
                }else{
                    x_position++;
                    outPutTable[x_position][y_position] = i;
                }
            }
        }
        for (int[] ints : outPutTable) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
