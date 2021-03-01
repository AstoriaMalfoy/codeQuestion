package luoguoQuestion.Q1888;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max = Math.max(Math.max(a,b),c);
        int min = Math.min(Math.min(a,b),c);
        int middle = a ^ b ^ c ^ max ^ min;
        for(int i=min; i>0;i--){
            if(max % i ==0 && min % i ==0){
                min = min / i;
                max = max / i;
                break;
            }
        }
        System.out.println(min + "/" + max);
    }
}
