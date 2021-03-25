package luoguoQuestion.Q1554;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sNumber = scanner.nextInt();
        int bNumber = scanner.nextInt();
        int[] result = new int[10];
        for(int i=sNumber;i<=bNumber;++i){
            String str = String.valueOf(i);
            for(int j=0;j<str.length();++j){
                result[Integer.parseInt(str.charAt(j)+"")]++;
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

}
