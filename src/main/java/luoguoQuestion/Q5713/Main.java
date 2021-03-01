package luoguoQuestion.Q5713;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionSum = scanner.nextInt();
        if(questionSum <= 5){
            System.out.println("Local");
        }else{
            System.out.println("Luogu");
        }
    }
}
