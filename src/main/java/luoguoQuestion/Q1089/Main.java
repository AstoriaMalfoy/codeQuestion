package luoguoQuestion.Q1089;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int handHas =0;
        int savings =0;
        boolean hasOverdraft = false;
        for(int i=1;i<=12;++i){
            int inputNumber = scanner.nextInt();
            if(handHas+300 < inputNumber){
                System.out.println(0-i);
                hasOverdraft = true;
                break;
            }
            int mHandHas = 300-inputNumber+handHas;
            savings += ((mHandHas)/100)*100;
            handHas=mHandHas%100;
        }
        if(!hasOverdraft){
            System.out.printf("%d",(int)(savings*1.2)+handHas);
        }
    }
}
