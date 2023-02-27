package newCode.leetcode.editor.cn.Q1007;

import javax.print.attribute.HashAttributeSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Question_1007 {
    public static void main(String[] args) {
        new Question_1007().run();
    }

    public void run() {
        int i = new Solution().minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            Set<Integer> repeatValue = new HashSet<>(2);
            repeatValue.add(tops[0]);
            repeatValue.add(bottoms[0]);
            for (int i = 1; i < tops.length ; i++){
                Set<Integer> tempSet = new HashSet<>(2);
                if (repeatValue.contains(tops[i])){
                    tempSet.add(tops[i]);
                }
                if (repeatValue.contains(bottoms[i])){
                    tempSet.add(bottoms[i]);
                }
                if (tempSet.size() == 0){
                    return -1;
                }
                repeatValue = tempSet;

            }
            final int[] result = {tops.length};
            repeatValue.forEach(re->{
                long revalueCountA = Arrays.stream(tops).filter(d -> {
                    return d == re;
                }).count();
                long revalueCountB = Arrays.stream(bottoms).filter(d -> {
                    return d == re;
                }).count();
                int maxLong = revalueCountA > revalueCountB ? (int)revalueCountA : (int)revalueCountB;
                if (tops.length - maxLong < result[0]){
                    result[0] = (int) (tops.length - maxLong);
                }
            });
            return result[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * //在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列
     //平铺形成的 —— 该平铺的每一半上都有一个数字。）
     //
     // 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
     //
     // 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
     //
     // 如果无法做到，返回 -1.
     //
     //
     //
     // 示例 1：
     //
     //
     //输入：tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
     //输出：2
     //解释：
     //图一表示：在我们旋转之前， tops 和 bottoms 给出的多米诺牌。
     //如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
     //
     //
     // 示例 2：
     //
     //
     //输入：tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
     //输出：-1
     //解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。
     //
     //
     //
     //
     // 提示：
     //
     //
     // 2 <= tops.length <= 2 * 10⁴
     // bottoms.length == tops.length
     // 1 <= tops[i], bottoms[i] <= 6
     //
     //
     // 👍 107 👎 0

     */
}

