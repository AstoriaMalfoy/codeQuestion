package luoguoQuestion.Q1046;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] applesHight = new int[10];
        for(int i=0;i<10;++i){
            applesHight[i] = scanner.nextInt();
        }
        int personHight = scanner.nextInt();
        int result = 0;
        for(int i=0;i<10;++i){
            if (personHight + 30 >= applesHight[i]){
                result++;
            }
        }
        System.out.println(result);
    }
}
