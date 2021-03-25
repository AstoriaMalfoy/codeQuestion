package luoguoQuestion.Q5727;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int tempNumber = inputNumber;
        List<Integer> lineList = new ArrayList<>();
        while(tempNumber!=1){
            lineList.add(tempNumber);
            if(tempNumber%2==0){
                tempNumber/=2;
            }else{
                tempNumber = tempNumber*3+1;
            }
        }
        lineList.add(tempNumber);
        for (int i = lineList.size()-1; i >=0 ; --i) {
            System.out.printf(lineList.get(i) + " ");
        }
    }

}
