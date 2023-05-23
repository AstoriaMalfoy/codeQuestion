//我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还
//会给出两个整数 numWanted 和 useLimit 。 
//
// 从 n 个元素中选择一个子集 s : 
//
// 
// 子集 s 的大小 小于或等于 numWanted 。 
// s 中 最多 有相同标签的 useLimit 项。 
// 
//
// 一个子集的 分数 是该子集的值之和。 
//
// 返回子集 s 的最大 分数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
// 
//
// 示例 2： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
// 
//
// 示例 3： 
//
// 
//输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length == labels.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= values[i], labels[i] <= 2 * 10⁴ 
// 1 <= numWanted, useLimit <= n 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 
// 👍 48 👎 0

package newCode.leetcode.editor.cn;

import java.util.*;

public class LargestValuesFromLabels {
    public static void main(String[] args) {
        Solution solution = new LargestValuesFromLabels().new Solution();
        int result = solution.largestValsFromLabels(
                new int[]{9,8,8,7,6},
                new int[]{0,0,0,1,1},
                3, 1);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int result = 0;
            // label计数
            Map<Integer, Integer> countMap = new HashMap<>();
            // sort
            quickSort(values, labels, 0, labels.length);
            // 计数
            int totalCount = 0;
            for (int i = 0; i < values.length && totalCount < numWanted; i++) {
                Integer currentValue;
                if ((currentValue = countMap.get(labels[i])) == null || countMap.get(labels[i]) < useLimit) {
                    // result convert
                    result += values[i];
                    // map conver
                    if (currentValue == null) {
                        currentValue = 1;
                    } else {
                        currentValue++;
                    }
                    countMap.put(labels[i], currentValue);
                    // value convert
                    totalCount++;
                }
            }
            return result;
        }

        public void quickSort(int[] values, int[] labels, int start, int end) {
            if (start >= end) {
                return;
            }
            int middleValue = values[start];
            int slowPoint = start, fasePoint = start + 1;
            for (; fasePoint < end; fasePoint++) {
                if (middleValue <= values[fasePoint]) {
                    swap(values, labels, ++slowPoint, fasePoint);
                }
            }
            swap(values, labels, start, slowPoint);
            quickSort(values, labels, start, slowPoint);
            quickSort(values, labels, slowPoint + 1, end);

        }


        /**
         * swap list
         *
         * @param values
         * @param labels
         * @param positionA
         * @param positionB
         */
        public void swap(int[] values, int[] labels, int positionA, int positionB) {
            if (positionB == positionA) {
                return;
            }
            values[positionA] = values[positionA] + values[positionB];
            values[positionB] = values[positionA] - values[positionB];
            values[positionA] = values[positionA] - values[positionB];

            labels[positionA] = labels[positionA] + labels[positionB];
            labels[positionB] = labels[positionA] - labels[positionB];
            labels[positionA] = labels[positionA] - labels[positionB];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}