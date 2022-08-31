package newCode.leetcode.editor.cn.Q780;


/**
* 780_到达终点
**/
public class ReachingPoints_780{
    public static void main(String[] args) {
        Solution solution = new ReachingPoints_780().new Solution();
        System.out.println(solution.reachingPoints(6,5,11,16));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if (tx == ty){
                return sx == sy && sx == tx;
            }
            int sourceMin = sx > sy ? sy : sx;

            Boolean result = false;
            while(!result){

                if (tx == ty){
                    return sx == sy && sx == tx;
                }

                if (tx > ty){
                     tx = tx % ty;
                }else{
                    ty  = ty % tx;
                }

                if (tx == sx){
                    result = ty == sy;
                }else {
                    result = tx == sy && ty == sx;
                }

                if (tx < 0 || ty < 0){
                    break;
                }
                if (tx < sourceMin || ty < sourceMin ){
                    break;
                }
            }
            return result;


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



