package luoguoQuestion.Q5710;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean case1 = number % 2 == 0;
        boolean case2 = 4 < number && number <= 12;
        StringBuilder sb = new StringBuilder();
        if (case1 && case2) {
            sb.append("1 ");
        } else {
            sb.append("0 ");
        }
        if(case1 || case2){
            sb.append("1 ");
        }else{
            sb.append("0 ");
        }
        if(case1 && !case2 || !case1 && case2){
            sb.append("1 ");
        }else{
            sb.append("0 ");
        }
        if(!case1&&!case2){
            sb.append("1");
        }else{
            sb.append("0");
        }
        System.out.println(sb.toString());
    }
}
