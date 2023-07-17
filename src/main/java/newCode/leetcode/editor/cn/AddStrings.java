//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 
// 👍 739 👎 0


package newCode.leetcode.editor.cn;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("999999", "100001"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int totalLent = Math.max(num1.length(), num2.length());
            int carry = 0;
            String result = "";
            for (int i = 0; i < totalLent; i++) {
                int a = 0, b = 0;
                if (i < num1.length()) {
                    a = num1.charAt(num1.length() - i - 1) - '0';
                }
                if (i < num2.length()) {
                    b = num2.charAt(num2.length() - i - 1) - '0';
                }
                int current = (a + b + carry) % 10;
                carry = (a + b + carry) / 10;
                result = current + result;
            }
            if (carry != 0) {
                result = carry + result;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}