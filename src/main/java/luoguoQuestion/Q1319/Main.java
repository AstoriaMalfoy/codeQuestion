package luoguoQuestion.Q1319;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        List<Integer> integers = Arrays.stream(s).map(Integer::parseInt).collect(Collectors.toList());
        Integer tableSize = integers.remove(0);

        int[][] tables = new int[tableSize][tableSize];
        boolean isOne = false;
        int printCount = 0;
        for (Integer integer : integers) {
            for (int i = 0; i < integer; i++) {
                if(isOne){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
                printCount++;
                if(printCount % tableSize == 0){
                    System.out.println();
                }
            }
            if(isOne){
                isOne = false;
            }else{
                isOne = true;
            }
        }
    }
}
