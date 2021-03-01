package luoguoQuestion.Q1085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum =0;int unHappyDay=0;
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<7;++i){
            int daySum = scanner.nextInt() + scanner.nextInt();
            if(daySum > sum){
                unHappyDay = i;
                sum = daySum;
            }
        }
        System.out.println(unHappyDay+1);
    }
}
