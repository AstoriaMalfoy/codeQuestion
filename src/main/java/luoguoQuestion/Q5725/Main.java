package luoguoQuestion.Q5725;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int spaceCount = inputNumber-1;
        int pNumber = 1;
        int tpNumber = 1;
        for(int i=0;i<inputNumber;++i){
            for(int j=0;j<inputNumber;++j){
                printNumber(tpNumber);
                tpNumber++;
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<inputNumber;++i){
            for(int j=0;j<inputNumber;++j){
                if(j<spaceCount-i){
                    System.out.print("  ");
                }else{
                    printNumber(pNumber);
                    pNumber++;
                }
            }
            System.out.println();
        }
    }

    private static void printNumber(int pNumber) {
        if(pNumber < 10) {
            System.out.print("0");
        }
        System.out.print(pNumber);
    }
}
