package newCode.leetcode.editor.cn.Q397;

import java.util.HashMap;
import java.util.Map;

/**
* 整数替换	
*/
public class Solution_397{
    public static void main(String[] args) {
        Solution s = new Solution_397().new Solution();
        System.out.println(s.integerReplacement(7));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Integer,Integer> buffer = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1){
            return 0;
        }
        if (n%2==0){
            Integer res = 1 + integerReplacement(n/2);
            return res;
        }else{
            Integer res = 2+ Math.min(integerReplacement(n/2) ,integerReplacement((n/2)+1));
            return res;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
