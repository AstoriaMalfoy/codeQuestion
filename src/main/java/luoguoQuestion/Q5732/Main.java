package luoguoQuestion.Q5732;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = scanner.nextInt();
        int[] preLine = new int[lineCount];
        int[] currentLien = null;
        for(int i=1;i<=lineCount;++i){
            preLine = pringIndexLint(preLine,currentLien,i);
        }

    }

    private static int[] pringIndexLint(int[] preLine, int[] currentLien, int i) {
        if(i == 1){
            System.out.println("1");
            preLine[0] = 1;
            return preLine;
        }
        if(i == 2){
            System.out.println("1 1");
            preLine[0] = 1;preLine[1] = 1;
            return preLine;
        }
        currentLien = new int[i];
        for(int index = 0;index < i;++index){
            if(index == 0){
                currentLien[index] = 1;
                continue;
            }
            if(index == i-1){
                currentLien[index] = 1;
                continue;
            }
            currentLien[index] = preLine[index -1] + preLine[index];
        }
        for (int i1 : currentLien) {
            System.out.print(i1 + " ");
        }
        System.out.println();
        return currentLien;
    }
}
