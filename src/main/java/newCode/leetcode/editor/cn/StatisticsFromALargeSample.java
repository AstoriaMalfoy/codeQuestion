//我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 在样本中出现的次数。
//
// 计算以下统计数据: 
//
// 
// minimum ：样本中的最小元素。 
// maximum ：样品中的最大元素。 
// mean ：样本的平均值，计算为所有元素的总和除以元素总数。 
// median ： 
// 
// 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。 
// 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。 
// 
// mode ：样本中出现次数最多的数字。保众数是 唯一 的。 
// 
//
// 以浮点数数组的形式返回样本的统计信息 [minimum, maximum, mean, median, mode] 。与真实答案误差在 10⁻⁵ 内的答案
//都可以通过。 
//
// 
//
// 示例 1： 
//
// 
//输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
//解释：用count表示的样本为[1,2,2,2,3,3,3,3]。
//最小值和最大值分别为1和3。
//均值是(1+2+2+2+3+3+3+3) / 8 = 19 / 8 = 2.375。
//因为样本的大小是偶数，所以中位数是中间两个元素2和3的平均值，也就是2.5。
//众数为3，因为它在样本中出现的次数最多。 
//
// 示例 2： 
//
// 
//输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
//0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
//解释：用count表示的样本为[1,1,1,1,2,2,3,3,3,4,4]。
//最小值为1，最大值为4。
//平均数是(1+1+1+1+2+2+2+3+3+4+4)/ 11 = 24 / 11 = 2.18181818…(为了显示，输出显示了整数2.18182)。
//因为样本的大小是奇数，所以中值是中间元素2。
//众数为1，因为它在样本中出现的次数最多。
// 
//
// 
//
// 提示： 
//
// 
// count.length == 256 
// 0 <= count[i] <= 10⁹ 
// 1 <= sum(count) <= 10⁹ 
// count 的众数是 唯一 的 
// 
//
// Related Topics 数组 数学 概率与统计 
// 👍 42 👎 0


package newCode.leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.Arrays;

public class StatisticsFromALargeSample {
    public static void main(String[] args) {
        Solution solution = new StatisticsFromALargeSample().new Solution();
        System.out.println(Arrays.toString(solution.sampleStats(new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] sampleStats(int[] count) {
            Double minValue = (double) -1;
            Double maxValue = (double) -1;
            Double totalSum = 0D;
            Double totalCount = 0D;
            int mostValue = -1, mostCount = -1;
            for (int i = 0; i < count.length; i++) {
                // 最小值
                if (minValue == -1 && count[i] != 0) {
                    minValue = (double) i;
                }
                // 最大值
                if (count[i] != 0) {
                    maxValue = (double) i;
                }
                // 平均数
                totalCount += count[i];
                totalSum += (long) count[i] * i;
                // 众数
                if (count[i] > mostCount) {
                    mostValue = i;
                    mostCount = count[i];
                }
            }
            boolean odd = !(totalCount % 2 == 0);
            Long currentCount = 0L;
            Long middleIndex = (long) (totalCount / 2);
            int middleValue = -1;
            int middleValueLeft = -1, middleValueRight = -1;
            for (int i = 0; i < count.length; i++) {
                if (odd) {
                    // 奇数
                    if (currentCount < middleIndex + 1 && middleIndex + 1 <= currentCount + count[i]) {
                        middleValue = i;
                        break;
                    }
                    currentCount += count[i];
                } else {
                    // 偶数
                    if (currentCount < middleIndex && middleIndex <= currentCount + count[i]) {
                        middleValueLeft = i;
                    }
                    if (currentCount < middleIndex + 1 && middleIndex + 1 <= currentCount + count[i]) {
                        middleValueRight = i;
                    }
                    currentCount += count[i];
                    if (middleValueLeft != -1 && middleValueRight != -1) {
                        break;
                    }
                }
            }
            double middleVluaeResult = odd ? middleValue : (middleValueLeft  +middleValueRight) / 2D;
            return new double[]{minValue,maxValue,totalSum / totalCount , middleVluaeResult,mostValue};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}