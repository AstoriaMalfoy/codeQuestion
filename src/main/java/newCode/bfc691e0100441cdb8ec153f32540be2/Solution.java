package newCode.bfc691e0100441cdb8ec153f32540be2;

import java.util.*;

/*
 * public class Point {
 *   int x;
 *   int y;
 * }
 */


/**

 *
 *
 */

public class Solution {
    /**
     *
     * @param points Point类一维数组 
     * @return int整型
     */
    public int maxPoints (Point[] points) {
        // write code here
        if (points.length == 2){
            return 2;
        }
        for (int i = 0; i < points.length; i++) {

        }
        return 1;
    }


    static class Point{
        int x;
        int y;

        public Point(int x,int y){
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