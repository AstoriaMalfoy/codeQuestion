package newCode.leetcode.editor.cn.Q1775;


import java.util.HashMap;
import java.util.Objects;

public class Question_1775 {
    public static void main(String[] args) {
        new Question_1775().run();
    }

    public void run() {
        System.out.println(new Solution().minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
        System.out.println(new Solution().minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(new Solution().minOperations(new int[]{6, 6}, new int[]{1}));
        System.out.println(new Solution().minOperations(new int[]{5,2,1,5,2,2,2,2,4,3,3,5}, new int[]{1,4,5,5,6,3,1,3,3}));
        System.out.println(new Solution().minOperations(new int[]{3,3,2,4,2,6,2}, new int[]{6,2,6,6,1,1,4,6,4,6,2,5,4,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int minOperations(int[] nums1, int[] nums2) {
            if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
                return -1;
            }

            int result = 0;
            HashMap<Integer, Integer> num1Dict = new HashMap<>(), num2Dict = new HashMap<>();
            int num1Sum = 0, num2Sum = 0;
            // num1Dict
            for (int currentValue : nums1) {
                num1Sum += currentValue;
                if (Objects.isNull(num1Dict.get(currentValue))) {
                    num1Dict.put(currentValue, 1);
                } else {
                    num1Dict.put(currentValue, num1Dict.get(currentValue) + 1);
                }
            }
            // num2Dict
            for (int currentValue : nums2) {
                num2Sum += currentValue;
                if (Objects.isNull(num2Dict.get(currentValue))) {
                    num2Dict.put(currentValue, 1);
                } else {
                    num2Dict.put(currentValue, num2Dict.get(currentValue) + 1);
                }
            }

            HashMap<Integer, Integer> maxHashDict, minHashDict;
            if (num1Sum > num2Sum) {
                maxHashDict = num1Dict;
                minHashDict = num2Dict;
            } else {
                maxHashDict = num2Dict;
                minHashDict = num1Dict;
            }

            Integer targetStep = Math.abs(num1Sum - num2Sum);
            for (int i = 1; i < 6; i++) {
                if (targetStep == 0 ){
                    break;
                }
                if (Objects.nonNull(minHashDict.get(i))){

                    // 先由小的集合的最小值开始做加法 --  最小值的加法空间最大
                    int hopeMinStep = targetStep / (6 - i);
                    int currnetStep = hopeMinStep > minHashDict.get(i) ? minHashDict.get(i) : hopeMinStep;
                    if (hopeMinStep < minHashDict.get(i) && targetStep % (6 - i) != 0) {
                        result += hopeMinStep + 1;
                        break;
                    } else {
                        result += currnetStep;
                    }
                    targetStep -= currnetStep * (6 - i);
                }
                if (Objects.nonNull(maxHashDict.get( 7 - i))){

                    // 由较大的集合做减法，
                    int tempCurrentValue = 7 - i;
                    int hopeMaxStep = targetStep / (tempCurrentValue - 1);
                    int currentStep = hopeMaxStep > maxHashDict.get(tempCurrentValue) ? maxHashDict.get(tempCurrentValue) : hopeMaxStep;
                    if (hopeMaxStep < maxHashDict.get(tempCurrentValue) && targetStep % (tempCurrentValue - 1) != 0){
                        result += hopeMaxStep + 1;
                        break;
                    }else{
                        result += currentStep;
                    }
                    targetStep -= currentStep* (tempCurrentValue - 1);
                }

            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     *
     // 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
     //
     // 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
     //
     // 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
     //
     //
     //
     // 示例 1：
     //
     // 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
     // 输出：3
     // 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
     // - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
     // - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
     // - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
     //
     //
     // 示例 2：
     //
     // 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
     // 输出：-1
     // 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
     //
     //
     // 示例 3：
     //
     // 输入：nums1 = [6,6], nums2 = [1]
     // 输出：3
     // 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
     // - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
     // - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
     // - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
     //
     //
     //
     //
     // 提示：
     //
     //
     // 1 <= nums1.length, nums2.length <= 10⁵
     // 1 <= nums1[i], nums2[i] <= 6
     //
     //
     // Related Topics 贪心 数组 哈希表 计数
     // 👍 184 👎 0

     */
}
