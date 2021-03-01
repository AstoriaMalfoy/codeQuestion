package luoguoQuestion.Q5709;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int t = scanner.nextInt();
        int s = scanner.nextInt();
        if(s == 0){
            System.out.println(m);
            return;
        }
        if(t==0){
            System.out.println(0);
            return;
        }
        int result = m-s/t;
        if(s%t!=0){
            result--;
        }
        if(result<0){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }
}
