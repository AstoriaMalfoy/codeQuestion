//有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
//
// 下标为 i 处的奶酪被吃掉的得分为： 
//
// 
// 如果第一只老鼠吃掉，则得分为 reward1[i] 。 
// 如果第二只老鼠吃掉，则得分为 reward2[i] 。 
// 
//
// 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。 
//
// 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。 
//
// 
//
// 示例 1： 
//
// 
//输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
//输出：15
//解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
//总得分为 4 + 4 + 3 + 4 = 15 。
//15 是最高得分。
// 
//
// 示例 2： 
//
// 
//输入：reward1 = [1,1], reward2 = [1,1], k = 2
//输出：2
//解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
//总得分为 1 + 1 = 2 。
//2 是最高得分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == reward1.length == reward2.length <= 10⁵ 
// 1 <= reward1[i], reward2[i] <= 1000 
// 0 <= k <= n 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 
// 👍 29 👎 0


package newCode.leetcode.editor.cn;


public class MiceAndCheese {
    public static void main(String[] args) {
        Solution solution = new MiceAndCheese().new Solution();
        System.out.println(solution.miceAndCheese(new int[]{1}, new int[]{4}, 1));
    }

    // 时间复杂度NlogN
    // 空间复杂度 N
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            // 特例优化
            if (reward1.length <= k) {
                int sum = 0;
                for (int i : reward1) {
                    sum += i;
                }
                return sum;
            }
            int result = 0;
            quickSort(reward1, reward2, 0, reward1.length);
            for (int i = 0; i < reward1.length; i++) {
                if (i < k) {
                    result += reward1[i];
                } else {
                    result += reward2[i];
                }
            }
            return result;
        }


        public void quickSort(int[] rewardA, int[] rewardB, int start, int end) {
            if (start + 1 >= end) {
                return;
            }
            int middleValue = rewardA[start] - rewardB[start];
            int startPosition = start + 1;
            for (int i = start + 1; i < end; i++) {
                if (rewardA[i] - rewardB[i] >= middleValue) {
                    swap(rewardA, rewardB, i, startPosition++);
                }
            }
            startPosition -= 1;
            swap(rewardA, rewardB, start, startPosition);
            quickSort(rewardA, rewardB, start, startPosition);
            quickSort(rewardA, rewardB, startPosition + 1, end);
        }

        private void swap(int[] rewardA, int[] rewardB, int positionA, int positionB) {
            if (positionA != positionB) {
                rewardA[positionA] += rewardA[positionB];
                rewardA[positionB] = rewardA[positionA] - rewardA[positionB];
                rewardA[positionA] = rewardA[positionA] - rewardA[positionB];

                rewardB[positionA] += rewardB[positionB];
                rewardB[positionB] = rewardB[positionA] - rewardB[positionB];
                rewardB[positionA] = rewardB[positionA] - rewardB[positionB];
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}