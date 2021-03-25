package luoguoQuestion.Q2550;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ticketCount = scanner.nextInt();
        int[] resultList = new int[]{0,0,0,0,0,0,0,0};
        Ticket openPrizeTicket = new Ticket(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),
                scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        for(int i=0;i<ticketCount;++i){
            int prizeLevel = openPrizeTicket.prizeLevel(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),
                    scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
            resultList[7-prizeLevel]++;
        }
        for(int i=0;i<7;++i){
            System.out.print(resultList[i] + " ");
        }
    }
    static class Ticket{
        List<Integer> tickNumber;
        public Ticket(int a,int b,int c,int d,int e,int f,int g){
            tickNumber = new ArrayList<>();
            tickNumber.add(a);
            tickNumber.add(b);
            tickNumber.add(c);
            tickNumber.add(d);
            tickNumber.add(e);
            tickNumber.add(f);
            tickNumber.add(g);
        }
        int prizeLevel(int a,int b,int c,int d,int e,int f,int g){
            int result =0;
            if(tickNumber.contains(a)){result++;}
            if(tickNumber.contains(b)){result++;}
            if(tickNumber.contains(c)){result++;}
            if(tickNumber.contains(d)){result++;}
            if(tickNumber.contains(e)){result++;}
            if(tickNumber.contains(f)){result++;}
            if(tickNumber.contains(g)){result++;}
            return  result;
        }
    }
}
