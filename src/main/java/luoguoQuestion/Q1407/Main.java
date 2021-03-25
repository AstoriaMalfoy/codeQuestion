package luoguoQuestion.Q1407;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = scanner.nextInt();
        int rodeCount = scanner.nextInt();
        List<RoadBet> roadBetList = new ArrayList<>();
        for(int i=0;i<rodeCount;++i){
            RoadBet roadBet = new RoadBet(scanner.nextInt(),scanner.nextInt());
            roadBetList.add(roadBet);
        }
        int resultCount = 0;
        for(int i=0;i<=maxLength;++i){
            boolean isBet = false;
            for (RoadBet roadBet : roadBetList) {
                if(roadBet.inBet(i)){
                    isBet = true;
                }
            }
            if(!isBet){
                resultCount++;
            }
        }
        System.out.println(resultCount);


    }

    public static class RoadBet{
        public int lNumber;
        public int bNumber;

        public RoadBet(int lNumber, int bNumber) {
            this.lNumber = lNumber;
            this.bNumber = bNumber;
        }
        public boolean inBet(int number){
            if(number>=lNumber && number<=bNumber){
                return true;
            }
            return false;
        }
    }
}
