package luoguoQuestion.Q1307;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        String valueStr = String.valueOf(value);
        int result =0;
        for(int i=valueStr.length()-1;i>=0;i--){
            if(i!=0){
                result+=Integer.parseInt(valueStr.charAt(i)+"");
                result*=10;
            }else{
                if(valueStr.charAt(i)=='-'){
                    result/=10;
                    result = 0-result;
                }else{
                    result+=Integer.parseInt(valueStr.charAt(i)+"");
                }
            }
        }
        System.out.println(result);
    }
}
