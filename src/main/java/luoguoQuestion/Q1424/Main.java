package luoguoQuestion.Q1424;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int allWeak = n / 7;
        int leaveDay = n % 7;
        int swimming = allWeak * 250 * 5;
        for(int i=1;i<=leaveDay;++i){
            if(x - 1 + i != 6 && x - 1 + i != 7 ){
                swimming += 250;
            }
        }
        System.out.println(swimming);
    }
}
