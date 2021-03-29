package luoguoQuestion.Q1161;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        Map<Integer,Boolean> openLightMap = new HashMap<>();
        for(int i=0;i<numberCount;++i){
            double a = scanner.nextDouble();
            int t = scanner.nextInt();
            for(int j=1;j<=t;j++){
                int operLightNumber = (int) (j * a);
                if(openLightMap.get(operLightNumber) == null){
                    openLightMap.put(operLightNumber,true);
                }else{
                    openLightMap.remove(operLightNumber);
                }
            }
        }
        Set<Integer> integers = openLightMap.keySet();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
