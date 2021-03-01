package luoguoQuestion.Q5712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        if(sum == 1 || sum ==0){
            System.out.println("Today, I ate "+sum+" apple.");
        }else{
            System.out.println("Today, I ate "+sum+" apples.");
        }
    }
}
