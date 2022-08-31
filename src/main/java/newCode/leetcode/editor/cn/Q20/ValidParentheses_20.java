package newCode.leetcode.editor.cn;


import java.util.Stack;

/**
* 20_有效的括号
**/
public class ValidParentheses_20{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses_20().new Solution();
        boolean valid = solution.isValid("]");
        System.out.println(valid);
        Stack<String> stack = new Stack<>();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (currentChar == '['){
                    stack.push("" + currentChar);
                }else if (currentChar == '{'){
                    stack.push("" + currentChar);
                }else if (currentChar == '('){
                    stack.push("" + currentChar);
                }else if (currentChar == ')'){
                    if (stack.empty()){
                        return false;
                    }
                    String pop = stack.pop();
                    if (!"(".equals(pop)){
                        return false;
                    }
                }else if(currentChar == ']'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    String pop = stack.pop();
                    if (!"[".equals(pop)){
                        return false;
                    }
                }else if (currentChar == '}'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    String pop = stack.pop();
                    if (!"{".equals(pop)){
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



