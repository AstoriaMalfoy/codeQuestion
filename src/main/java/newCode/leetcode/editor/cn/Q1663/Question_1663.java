// windows tamplate
package newCode.leetcode.editor.cn.Q1663;


public class Question_1663 {
    public static void main(String[] args) {
        new Question_1663().run();
    }

    public void run() {
        String smallestString = new Solution().getSmallestString(5, 130);
        System.out.println(smallestString);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getSmallestString(int n, int k) {
            StringBuilder result = new StringBuilder();
            // 拆分 xa 1t yz
            // 存在 x + 1 + y = n
            // 存在 x + t + 26y = k
            // 存在 1 <= t <= 26 MAXy

            // t + 26y - 1 - y = k - n
            // t + 25 y = k - n + 1
            // 25y = k - n + 1 - t     其中 1<=t<=26

            int zCount = (k - n) / 25;
            int tValue = 0;
            while (true) {
                tValue = k - zCount * 26 - (n - zCount - 1);
                if (0 <= tValue && tValue <= 26) {
                    break;
                }
                // 数据修正
                if (tValue < 0) {
                    zCount--;
                }
                if (tValue > 26) {
                    zCount++;
                }
            }
            tValue -=1;
            int tCount = tValue == 0 ? 0 : 1;
            for (int i = 0; i < n - zCount - tCount; i++) {
                result.append('a');
            }
            if (tValue != 0){
                result.append((char) ('a' + (tValue)));
            }
            for (int i = 0; i < zCount; i++) {
                result.append('z');
            }
            return result.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * //小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
     //
     // 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
     //
     // 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
     //
     // 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
     //
     //
     // x 是 y 的一个前缀；
     // 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
     //
     //
     //
     //
     // 示例 1：
     //
     //
     //输入：n = 3, k = 27
     //输出："aay"
     //解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
     //
     // 示例 2：
     //
     //
     //输入：n = 5, k = 73
     //输出："aaszz"
     //
     //
     //
     //
     // 提示：
     //
     //
     // 1 <= n <= 10⁵
     // n <= k <= 26 * n
     //
     //
     // Related Topics 贪心 字符串
     // 👍 96 👎 0

     */
}
