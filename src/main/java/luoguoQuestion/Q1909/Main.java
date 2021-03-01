package luoguoQuestion.Q1909;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personCount = scanner.nextInt();
        int minMoney = Integer.MAX_VALUE;
        for(int i=0;i<3;++i){
            int packageCount = scanner.nextInt();
            int buyPackageCount = personCount / packageCount;
            if(personCount % packageCount != 0){
                buyPackageCount++;
            }
            int unitPrice = scanner.nextInt();
            if(unitPrice * buyPackageCount < minMoney){
                minMoney = unitPrice * buyPackageCount;
            }
        }
        System.out.println(minMoney);
    }
}