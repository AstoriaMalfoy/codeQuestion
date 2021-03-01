package luoguoQuestion.Q5717;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if(a+b<c || a+c<b || c+b <a){
            System.out.println("Not triangle");
        }else{
            int max = Math.max(Math.max(a,b),c);
            int min = Math.min(Math.min(a,b),c);
            int middle = a ^ b ^ c ^ max ^ min;
            if(max*max == middle*middle + min*min){
                System.out.println("Right triangle");
            }else if(max*max > middle*middle + min*min){
                System.out.println("Obtuse triangle");
            }else{
                System.out.println("Acute triangle");
            }
            if(a==b && b==c){
                System.out.println("Isosceles triangle");
                System.out.println("Equilateral triangle");
            }
            if((a==b&&b!=c) || (a==c&&c!=b) || (c==b&&a!=b)){
                System.out.println("Isosceles triangle");
            }
        }
    }
}
