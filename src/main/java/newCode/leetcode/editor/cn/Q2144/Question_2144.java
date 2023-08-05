package newCode.leetcode.editor.cn.Q2144;


public class Question_2144 {
    public static void main(String[] args) {
        new Question_2144().run();
    }

    public void run() {
        int[] list = new int[]{1,2,3};
        int i = new Solution().minimumCost(list);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCost(int[] cost) {
            // sort fisrt repeat quick sort
            quickStart(cost);
            int result = 0;
            for (int i = cost.length - 1 ; i  >= 0 ; ){
                if (i >= 0){
                    result += cost[i];
                }
                if (i-1>=0){
                    result += cost[i-1];
                }
                i = i-3;
            }

            return result;
        }

        // quick start
        public void quickStart(int[] list) {
            quickStartAct(list, 0, list.length);
        }

        // left close , right open
        public void quickStartAct(int[] list, int start, int end) {
            if (start + 1 >= end) {
                return;
            }

            int tempValue = list[start];
            // quick slow point
            int currentPosition = start + 1, middlePosition = start + 1;
            while (currentPosition < end) {
                if (list[currentPosition] < tempValue) {
                    swap(list, currentPosition, middlePosition);
                    middlePosition++;
                }
                currentPosition++;
            }
            swap(list,start,middlePosition - 1);
            quickStartAct(list, start, middlePosition -1 );
            quickStartAct(list, middlePosition, end);

        }

        // swap
        public void swap(int[] list, int positionA, int positionB) {
            if (positionA == positionB) {
                return;
            }
            list[positionA] = list[positionA] + list[positionB];
            list[positionB] = list[positionA] - list[positionB];
            list[positionA] = list[positionA] - list[positionB];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * //一家商店正在打折销售糖果。每购买 两个 糖果，商店会 免费 送一个糖果。
     //
     // 免费送的糖果唯一的限制是：它的价格需要小于等于购买的两个糖果价格的 较小值 。
     //
     //
     // 比方说，总共有 4 个糖果，价格分别为 1 ，2 ，3 和 4 ，一位顾客买了价格为 2 和 3 的糖果，那么他可以免费获得价格为 1 的糖果，但不能获得
     //价格为 4 的糖果。
     //
     //
     // 给你一个下标从 0 开始的整数数组 cost ，其中 cost[i] 表示第 i 个糖果的价格，请你返回获得 所有 糖果的 最小 总开销。
     //
     //
     //
     // 示例 1：
     //
     // 输入：cost = [1,2,3]
     //输出：5
     //解释：我们购买价格为 2 和 3 的糖果，然后免费获得价格为 1 的糖果。
     //总开销为 2 + 3 = 5 。这是开销最小的 唯一 方案。
     //注意，我们不能购买价格为 1 和 3 的糖果，并免费获得价格为 2 的糖果。
     //这是因为免费糖果的价格必须小于等于购买的 2 个糖果价格的较小值。
     //
     //
     // 示例 2：
     //
     // 输入：cost = [6,5,7,9,2,2]
     //输出：23
     //解释：最小总开销购买糖果方案为：
     //- 购买价格为 9 和 7 的糖果
     //- 免费获得价格为 6 的糖果
     //- 购买价格为 5 和 2 的糖果
     //- 免费获得价格为 2 的最后一个糖果
     //因此，最小总开销为 9 + 7 + 5 + 2 = 23 。
     //
     //
     // 示例 3：
     //
     // 输入：cost = [5,5]
     //输出：10
     //解释：由于只有 2 个糖果，我们需要将它们都购买，而且没有免费糖果。
     //所以总最小开销为 5 + 5 = 10 。
     //
     //
     //
     //
     // 提示：
     //
     //
     // 1 <= cost.length <= 100
     // 1 <= cost[i] <= 100
     //
     //
     // 👍 10 👎 0

     */
}

