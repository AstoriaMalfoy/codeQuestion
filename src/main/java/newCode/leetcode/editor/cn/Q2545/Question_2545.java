// windows tamplate
package newCode.leetcode.editor.cn.Q2545;


import java.util.Arrays;

public class Question_2545 {
    public static void main(String[] args) {
        new Question_2545().run();
    }

    public void run() {
        int[][] ints = new Solution().sortTheStudents(new int[][]{
                {64766, 11978, 20502, 21365, 79611, 36797, 58431, 89540, 59373, 25955},
                {51305, 66104, 88468, 5333, 17233, 32521, 14087, 42738, 46669, 65662},
                {93306, 92793, 54009, 9715, 24354, 24895, 20069, 93332, 73836, 64359},
                {23358, 84599, 4675, 20979, 76889, 34630, 64098, 23468, 71448, 17848}}, 5);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int[][] sortTheStudents(int[][] score, int k) {
            sortTheStudents(score, k, 0, score.length);
            return score;
        }

        public void sortTheStudents(int[][] score, int k, int start, int end) {
            if (start + 1 >= end) {
                return;
            }
            int middlePositon = start + 1, currentPosition = start + 1;

            while (currentPosition < end) {
                if (score[currentPosition][k] >= score[start][k]) {
                    swap(score, currentPosition, middlePositon);
                    middlePositon++;
                }
                currentPosition++;
            }
            swap(score, start, middlePositon - 1);
            sortTheStudents(score, k, start, middlePositon);
            sortTheStudents(score, k, middlePositon, end);

        }

        public void swap(int[][] score, int positionA, int positionB) {
            if (positionA == positionB) {
                return;
            }
            int[] temp = score[positionA];
            score[positionA] = score[positionB];
            score[positionB] = temp;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * //班里有 m 位学生，共计划组织 n 场考试。给你一个下标从 0 开始、大小为 m x n 的整数矩阵 score ，其中每一行对应一位学生，而 score[
     //i][j] 表示第 i 位学生在第 j 场考试取得的分数。矩阵 score 包含的整数 互不相同 。
     //
     // 另给你一个整数 k 。请你按第 k 场考试分数从高到低完成对这些学生（矩阵中的行）的排序。
     //
     // 返回排序后的矩阵。
     //
     //
     //
     // 示例 1：
     //
     //
     //
     //
     //输入：score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
     //输出：[[7,5,11,2],[10,6,9,1],[4,8,3,15]]
     //解释：在上图中，S 表示学生，E 表示考试。
     //- 下标为 1 的学生在第 2 场考试取得的分数为 11 ，这是考试的最高分，所以 TA 需要排在第一。
     //- 下标为 0 的学生在第 2 场考试取得的分数为 9 ，这是考试的第二高分，所以 TA 需要排在第二。
     //- 下标为 2 的学生在第 2 场考试取得的分数为 3 ，这是考试的最低分，所以 TA 需要排在第三。
     //
     //
     // 示例 2：
     //
     //
     //
     //
     //输入：score = [[3,4],[5,6]], k = 0
     //输出：[[5,6],[3,4]]
     //解释：在上图中，S 表示学生，E 表示考试。
     //- 下标为 1 的学生在第 0 场考试取得的分数为 5 ，这是考试的最高分，所以 TA 需要排在第一。
     //- 下标为 0 的学生在第 0 场考试取得的分数为 3 ，这是考试的最低分，所以 TA 需要排在第二。
     //
     //
     //
     //
     // 提示：
     //
     //
     // m == score.length
     // n == score[i].length
     // 1 <= m, n <= 250
     // 1 <= score[i][j] <= 10⁵
     // score 由 不同 的整数组成
     // 0 <= k < n
     //
     //
     // Related Topics 数组 矩阵 排序
     // 👍 7 👎 0

     */
}
