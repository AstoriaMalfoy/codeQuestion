package luoguoQuestion.Q1422;

import java.util.Scanner;

public class Main {
    private static final double BASE1_PRICE = 0.4463;
    private static final double BASE2_PRICE = 0.4663;
    private static final double BASE3_PRICE = 0.5663;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double eNumber = scanner.nextDouble();
        double cost ;

        if(eNumber < 150){
            cost = eNumber * BASE1_PRICE;
        }else if(150 < eNumber && eNumber < 400){
            cost = 150D * BASE1_PRICE;
            cost += (eNumber-150D) * BASE2_PRICE;
        }else{
            cost = 150D * BASE1_PRICE;
            cost += 250D * BASE2_PRICE;
            cost += (eNumber - 400D) * BASE3_PRICE;
        }
        System.out.printf("%.1f\n",cost);
    }
}
