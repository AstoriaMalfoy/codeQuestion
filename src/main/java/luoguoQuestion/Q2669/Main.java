package luoguoQuestion.Q2669;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayCount = scanner.nextInt();
        int receiveCount = 0;
        int incFalg = 1;
        int pointFlag = 1;
        while(dayCount-- > 0){
            if(pointFlag <= incFalg){
                receiveCount += incFalg;
                pointFlag++;
            }
            if(pointFlag > incFalg){
                incFalg ++;
                pointFlag =1;
            }
        }
        System.out.println(receiveCount);
    }
}
