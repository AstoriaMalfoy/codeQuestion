package luoguoQuestion.Q1320;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        String str = scanner.nextLine();
        int length = str.length();
        stringList.add(str);
        for(int i=1;i<length;++i){
            stringList.add(scanner.nextLine());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(length).append(" ");
        char preChar = '0';
        int appendLength = 0;
        for (String s : stringList) {
            for(int i=0;i<s.length();++i){
                if(s.charAt(i) == preChar){
                    appendLength++;
                }else{
                    stringBuilder.append(appendLength).append(" ");
                    appendLength = 1;
                    if(preChar == '1'){
                        preChar = '0';
                    }else{
                        preChar = '1';
                    }
                }
            }
        }
        if(appendLength != 0 ){
            stringBuilder.append(appendLength);
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
