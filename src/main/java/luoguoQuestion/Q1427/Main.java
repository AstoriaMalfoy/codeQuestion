package luoguoQuestion.Q1427;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        while(true){
            int inputNumber = scanner.nextInt();
            if(inputNumber == 0){
                break;
            }
            inputList.add(inputNumber);
        }
        for(int i = inputList.size()-1;i>=0;--i){
            System.out.print(inputList.get(i) + " ");
        }

    }
}
