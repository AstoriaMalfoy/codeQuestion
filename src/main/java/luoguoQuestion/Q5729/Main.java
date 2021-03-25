package luoguoQuestion.Q5729;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Astoria
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point original = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        List<Cube> cubes = new ArrayList<>();
        int cubeCount = scanner.nextInt();
        while(cubeCount-->0){
            cubes.add(new Cube(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),
                    scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }
        int result = 0;
        for(int i=1;i<=original.getX();++i){
            for(int j=1;j<=original.getY();++j){
                for(int k=1;k<=original.getZ();++k){

                    boolean has = true;
                    for (Cube cube : cubes) {
                        if(cube.hasCut(new Point(i,j,k))){
                            has = false;
                            break;
                        }
                    }

                    if(has){
                        result++;
                    }

                }
            }
        }
        System.out.println(result);
    }

    static class Point{
        int x,y,z;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
    static class Cube{
        Point po1;
        Point po2;
        Cube(int x1,int y1,int z1,int x2,int y2,int z2){
            po1 = new Point(x1,y1,z1);
            po2 = new Point(x2,y2,z2);
        }
        boolean hasCut(Point p){
            return p.x >= po1.x && p.y >= po1.y && p.z >= po1.z
                    && p.x <= po2.x && p.y <= po2.y && p.z <= po2.z;
        }

        @Override
        public String toString() {
            return "Cube{" +
                    "po1=" + po1 +
                    ", po2=" + po2 +
                    '}';
        }
    }

}
