package newCode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
* 986_区间列表的交集
**/
public class IntervalListIntersections_986{
    public static void main(String[] args) {
        Solution solution = new IntervalListIntersections_986().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int firstListLength = firstList.length;
        int secondListLength = secondList.length;

        if (firstListLength == 0 || secondListLength == 0){
            return new int[][]{};
        }

        int firstPoint = 0,secondPoint = 0;

        List<int[]> tempResult = new ArrayList<>();

        Boolean con = true;

        while (firstPoint!=firstListLength && secondPoint != secondListLength){


            // 选择一个靠前的
            int firstLeft = firstList[firstPoint][0];
            int firstRight = firstList[firstPoint][1];

            int secondLeft = secondList[secondPoint][0];
            int secondRight = secondList[secondPoint][1];


            // 判断交集
            int resultStart = firstLeft < secondLeft ? secondLeft : firstLeft;
            int resultEnd = firstRight < secondRight ? firstRight : secondRight;
            if (resultStart <= resultEnd){
                tempResult.add(new int[]{resultStart,resultEnd});
            }
            // 判断移动标志
            if (firstRight == secondRight){
                firstPoint ++;
                secondPoint++;
            }
            else if (firstRight > secondRight) {
                secondPoint++;
            }
            else{
                firstPoint++;
            }

        }

        if (tempResult.size() == 0){
            return new int[][]{};
        }
        int[][] result = new int[tempResult.size()][2];
        for (int i = 0 ; i < tempResult.size() ; ++i){
            result[i][0] = tempResult.get(i)[0];
            result[i][1] = tempResult.get(i)[1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



