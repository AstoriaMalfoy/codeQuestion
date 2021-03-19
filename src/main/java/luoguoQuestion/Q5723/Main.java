package luoguoQuestion.Q5723;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberIn = scanner.nextInt();
        int sum = 0;
        List<Integer> numberList = new ArrayList<>();
        for(int i=2;;i++){
            if(isPrime(i)){
                if(sum + i <= numberIn){
                    sum += i;
                    numberList.add(i);
                }else{
                    break;
                }
            }

        }
        for (Integer integer : numberList) {
            System.out.println(integer);
        }
        System.out.println(numberList.size());
    }

    private static boolean isPrime(int number) {
        for(int i=2;i<number;++i){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

}
