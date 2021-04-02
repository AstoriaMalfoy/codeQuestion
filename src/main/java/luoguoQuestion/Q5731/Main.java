package luoguoQuestion.Q5731;

import java.util.Scanner;

public class Main {
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int[][] outTables = new int[inputNumber][inputNumber];
        int direction = RIGHT;

        int counts = inputNumber * inputNumber;
        int xPosition=0,yPosition=-1;
        int fillInNumber = 1;
        for(int i=0;i<counts;++i){
            if(direction == RIGHT){
                yPosition++;
                if(yPosition == inputNumber || outTables[xPosition][yPosition] != 0){
                    yPosition--;
                    direction = DOWN;
                    xPosition++;
                }
                outTables[xPosition][yPosition] = fillInNumber;
                fillInNumber++;
            }else if(direction == DOWN){
                xPosition++;
                if(xPosition == inputNumber || outTables[xPosition][yPosition] != 0){
                    xPosition--;
                    direction = LEFT;
                    yPosition--;
                }
                outTables[xPosition][yPosition] = fillInNumber;
                fillInNumber++;
            }else if(direction == LEFT){
                yPosition--;
                if(yPosition == -1 || outTables[xPosition][yPosition] != 0){
                    yPosition++;
                    direction = UP;
                    xPosition--;
                }
                outTables[xPosition][yPosition] = fillInNumber;
                fillInNumber ++;
            }else{
                xPosition--;
                if(xPosition == -1 || outTables[xPosition][yPosition] != 0){
                    xPosition++;
                    direction = RIGHT;
                    yPosition++;
                }
                outTables[xPosition][yPosition] = fillInNumber;
                fillInNumber++;
            }
        }
        for (int[] outTable : outTables) {
            for (int i : outTable) {
                System.out.print(formatPrintNumner(i));
            }
            System.out.println();
        }
    }

    private static String formatPrintNumner(int i) {
        if(i<10){
            return "  " + i;
        }
        if(i<100){
            return " " + i;
        }
        return "" + i;
    }
}
