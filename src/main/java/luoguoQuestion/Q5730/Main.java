package luoguoQuestion.Q5730;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberLength = scanner.nextInt();
        scanner.nextLine();
        String strLine = scanner.nextLine();
        String[][] cpTable = new String[][]{
                {"XXX","..X","XXX","XXX","X.X","XXX","XXX","XXX","XXX","XXX"},
                {"X.X","..X","..X","..X","X.X","X..","X..","..X","X.X","X.X"},
                {"X.X","..X","XXX","XXX","XXX","XXX","XXX","..X","XXX","XXX"},
                {"X.X","..X","X..","..X","..X","..X","X.X","..X","X.X","..X"},
                {"XXX","..X","XXX","XXX","..X","XXX","XXX","..X","XXX","XXX"}
        };
        for(int i=0;i<5;++i){
            for(int j=0;j<numberLength;++j){
                System.out.print(cpTable[i][Integer.parseInt(strLine.charAt(j)+"")]);
                if(j!=numberLength-1){
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
