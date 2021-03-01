package luoguoQuestion.Q1055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        int result = 0;int itemNumner=1;
        for(int i=0;i<11;++i){
            if(i!=1 && i!=5){
                result+=Integer.parseInt(isbn.substring(i,i+1))*itemNumner;
                itemNumner++;
            }
        }
        if(result % 11 != 10 && !"X".equals(isbn.substring(isbn.length()-1)) &&  result % 11 == Integer.parseInt(isbn.substring(isbn.length()-1))){
            System.out.println("Right");
        }
        else if(result%11==10 && "X".equals(isbn.substring(isbn.length()-1))){
            System.out.println("Right");
        }
        else{
            if(result%11==10){
                System.out.println(isbn.substring(0,isbn.length()-1) + "X");
            }else{
                System.out.println(isbn.substring(0,isbn.length()-1) + result%11);
            }
        }
    }
}
