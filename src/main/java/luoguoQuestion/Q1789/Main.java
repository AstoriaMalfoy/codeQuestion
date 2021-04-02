package luoguoQuestion.Q1789;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tableSize = scanner.nextInt();
        int torchCount = scanner.nextInt();
        int fluoriteCount = scanner.nextInt();

        int[][] table = new int[tableSize][tableSize];
        List<Point> tourchList = new ArrayList<>();
        List<Point> fluoriteList = new ArrayList<>();
        for(int i=0;i<torchCount;++i){
            tourchList.add(new Point(scanner.nextInt()-1,scanner.nextInt()-1));
        }
        for(int i=0;i<fluoriteCount;++i){
            fluoriteList.add(new Point(scanner.nextInt(),scanner.nextInt()));
        }
        for (Point point : tourchList) {
            if(legitimate(point.x, point.y + 1, tableSize)) table[point.x][point.y+1] = 1;
            if(legitimate(point.x, point.y + 2, tableSize)) table[point.x][point.y+2] = 1;
            if(legitimate(point.x, point.y - 1, tableSize)) table[point.x][point.y-1] = 1;
            if(legitimate(point.x, point.y - 2, tableSize)) table[point.x][point.y-2] = 1;
            if(legitimate(point.x + 1, point.y, tableSize)) table[point.x+1][point.y] = 1;
            if(legitimate(point.x + 2, point.y, tableSize)) table[point.x+2][point.y] = 1;
            if(legitimate(point.x - 1, point.y, tableSize)) table[point.x-1][point.y] = 1;
            if(legitimate(point.x - 2, point.y, tableSize)) table[point.x-2][point.y] = 1;
            if(legitimate(point.x , point.y, tableSize)) table[point.x][point.y] = 1;
            if(legitimate(point.x + 1, point.y + 1, tableSize)) table[point.x+1][point.y+1] = 1;
            if(legitimate(point.x + 1, point.y - 1, tableSize)) table[point.x+1][point.y-1] = 1;
            if(legitimate(point.x - 1, point.y + 1, tableSize)) table[point.x-1][point.y+1] = 1;
            if(legitimate(point.x - 1, point.y - 1, tableSize)) table[point.x-1][point.y-1] = 1;
        }
        for (Point point : fluoriteList) {
            int xstart = point.x - 2,xend = point.x+2,ystart= point.y-2,yend = point.y+2;
            for(int x = xstart;x<=xend;++x){
                for(int y = ystart;y<=yend;++y){
                    if(legitimate(x,y,tableSize)) table[x][y] = 1;
                }
            }
        }
        int result = 0;
        for (int[] ints : table) {
            for (int anInt : ints) {
                if(anInt == 0) result++;
            }
        }
        System.out.println(result);
    }

    private static boolean legitimate(int x,int y, int tableSize) {
        return  x>=0 && x<tableSize && y>=0 && y<tableSize;
    }

    private static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
