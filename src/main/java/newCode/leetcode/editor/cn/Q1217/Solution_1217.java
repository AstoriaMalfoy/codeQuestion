import java.util.Map;

/**
* 玩筹码	
*/
public class Solution_1217{
    public static void main(String[] args) {
        Solution s = new Solution_1217().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostToMoveChips(int[] position) {
        int ji = 0 , ou = 0;
        for (int i : position) {
            if ( (i & 1) == 0){
                ou++;
            }else{
                ji++;
            }
        }
        return Math.min(ou,ji);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
