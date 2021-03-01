package luoguoQuestion.Q5718;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            int value = scanner.nextInt();
            if(minValue > value){
                minValue = value;
            }
        }
        System.out.println(minValue);
    }
}
