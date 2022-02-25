package newCode.leetcode.editor.cn;


import java.util.Arrays;

/**
* 1706_球会落何处
**/
public class WhereWillTheBallFall_1706{
    public static void main(String[] args) {
        Solution solution = new WhereWillTheBallFall_1706().new Solution();
        int[] ball = solution.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}});
        System.out.println(Arrays.toString(ball));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 表示方向
     */
    private static final int TOP = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static final int BUTTOM = 4;

    /**
     * 表示进来源和出来源为同一个 代表已经进入了死路
     */
    private static final int NON = 0;

    /**
     * 盒子类型
     */
    //  左上-右下
    private static final int GRID_A = 1;
    //  右上-左下
    private static final int GRID_B = -1;


    public int[] findBall(int[][] grid) {

        int x = grid.length;
        int y = grid[0].length;

        int[] result = new int[y];

        for (int i=0 ; i < y ; i++){
            // 初始下落方向为从上下落
            int position = TOP;
            // 第一个落入的盒子为第一行中第i个盒子
            int xTemp = 0;
            int yTemp = i;
            // 可以落入
            Boolean nextBox = true;
            while ( nextBox){
                position = getdis(grid[xTemp][yTemp], position);
                switch (position){
                    case RIGHT:
                        yTemp++;
                        position = LEFT;
                        break;
                    case LEFT:
                        yTemp--;
                        position = RIGHT;
                        break;
                    case BUTTOM:
                        xTemp++;
                        position = TOP;
                        break;
                    default:
                        nextBox = false;
                }
                if (!nextBox || xTemp >= x || yTemp >= y || xTemp < 0 || yTemp < 0){
                    nextBox = false;
                }
            }

            if (xTemp == x ){
                result[i] = yTemp;
            }else{
                result[i] = -1;
            }
        }
        return result;
    }

    public int getdis(int type,int position){
        // 左上-右下
        if (type == GRID_A){
            switch (position){
                case TOP:return RIGHT;
                case LEFT:return BUTTOM;
                case RIGHT:return NON;
                default:throw new RuntimeException("进入BOX的方向异常");
            }
        }
        // 右上-左下
        if (type == GRID_B){
            switch (position){
                case TOP:return LEFT;
                case LEFT:return NON;
                case RIGHT:return BUTTOM;
                default:throw new RuntimeException("进入BOX的方向异常");
            }
        }
        return NON;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



