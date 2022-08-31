package newCode.leetcode.editor.cn.Q735;

import java.util.Arrays;
import java.util.Stack;

/**
* 行星碰撞	
*/
public class Solution_735{
    public static void main(String[] args) {
        Solution s = new Solution_735().new Solution();
        int[] ints = s.asteroidCollision(new int[]{10,2,-5});
        System.out.println(Arrays.toString(ints));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                Integer stackTopElem = stack.peek();
                Integer currentValue = asteroids[i];
                Boolean bothNull = false;
                while (stackTopElem * currentValue < 0 && stackTopElem > 0) {
                    if (Math.abs(stackTopElem) > Math.abs(asteroids[i])) {
                        currentValue = stack.pop();
                        if (stack.isEmpty()){
                            break;
                        }else{
                            stackTopElem = stack.peek();
                        }
                    } else if (Math.abs(stackTopElem) < Math.abs(asteroids[i])) {
                        stack.pop();
                        if (stack.isEmpty()){
                            break;
                        }else{
                            stackTopElem = stack.peek();
                        }
                    } else {
                        stack.pop();
                        bothNull = true;
                        break;
                    }
                }
                if (!bothNull) {
                    stack.push(currentValue);
                }
            }
        }
        // stakc conver to list
        int[] result = new int[stack.size()];
        for (int i = stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
