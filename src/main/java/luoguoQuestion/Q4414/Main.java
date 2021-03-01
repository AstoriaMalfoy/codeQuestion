package luoguoQuestion.Q4414;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int max = Math.max(Math.max(a,b),c);
        int min = Math.min(Math.min(a,b),c);
        int middle = a^b^c^max^min;
        for(int i=0;i<3;++i){
            if(i == 0){
                if(str.charAt(i) == 'A'){
                    System.out.print(min);
                }else if(str.charAt(i) == 'B'){
                    System.out.print(middle);
                }else{
                    System.out.print(max);
                }
            }else{
                if(str.charAt(i) == 'A'){
                    System.out.print(" " + min);
                }else if(str.charAt(i) == 'B'){
                    System.out.print(" " + middle);
                }else{
                    System.out.print(" " + max);
                }
            }
        }
    }
}
