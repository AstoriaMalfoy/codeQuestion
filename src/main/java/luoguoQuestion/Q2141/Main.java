package luoguoQuestion.Q2141;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Astoria
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        Map<Integer,Integer> sumCount = new HashMap<>();
        int[] numberList = new int[numberCount];

        for(int i=0;i<numberCount;++i){
            int inputNumber = scanner.nextInt();
            numberList[i] = inputNumber;
            sumCount.put(inputNumber,-1);
        }

        int result = 0;
        for(int i=0;i<numberCount;++i){
            for(int j=i+1;j<numberCount;++j){
                int sum = numberList[i]+numberList[j];
                if(null != sumCount.get(sum) && numberList[i] != numberList[j] && 1 != sumCount.get(sum)){
                    sumCount.put(sum,1);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
