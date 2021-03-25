package luoguoQuestion.Q1428;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        int fishCount = scanner.nextInt();
        for (int i = 0; i < fishCount; ++i) {
            int inPutNumber = scanner.nextInt();
            int lessCount = 0;
            for (Integer integer : inputList) {
                if (integer < inPutNumber) {
                    lessCount++;
                }
            }
            resultList.add(lessCount);
            inputList.add(inPutNumber);
        }
        for (Integer integer : resultList) {
            System.out.print(integer+" ");
        }
    }
}