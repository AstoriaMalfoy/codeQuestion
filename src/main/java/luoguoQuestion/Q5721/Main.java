package luoguoQuestion.Q5721;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumebr = scanner.nextInt();
        int inValue =1;
        for(int j=0;j<lineNumebr;++j){
            for(int i = lineNumebr - j;i>0;i--){
                System.out.print(formatString(inValue));
                inValue++;
            }
            if(j!=lineNumebr-1){
                System.out.println();
            }
        }
    }
    public static String formatString(int value){
        if(value < 10){
            return "0" + value;
        }else{
            return String.valueOf(value);
        }
    }
}
