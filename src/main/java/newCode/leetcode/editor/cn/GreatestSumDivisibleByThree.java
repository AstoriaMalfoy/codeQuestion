//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 
// 👍 251 👎 0


package newCode.leetcode.editor.cn;

import java.util.Arrays;

public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
        int[] nums = new int[]{5,2,2,2};
        System.out.println(solution.maxSumDivThree(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumDivThree(int[] nums) {
            int result = 0;
            qucikSort(nums, 0, nums.length);
            boolean[] inResultFlag = new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 3 == 0 && !inResultFlag[i]) {
                    result += nums[i];
                    inResultFlag[i] = true;
                } else {
                    for (int j = nums.length - 1; j > i; j--) {
                        if (!inResultFlag[j] && (nums[i] + nums[j]) % 3 == 0) {
                            result += nums[i] + nums[j];
                            inResultFlag[i] = true;
                            inResultFlag[j] = true;
                            break;
                        }
                    }
                }
            }
            return result;
        }


        public void qucikSort(int[] nums, int start, int end) {
            if (end <= start + 1) {
                return;
            }
            int temp = start + 1;
            int tempValue = nums[start];
            for (int i = start + 1; i < end; i++) {
                if (nums[i] < tempValue) {
                    swap(nums, temp, i);
                    temp++;
                }
            }
            temp--;
            swap(nums, start, temp);
            qucikSort(nums, start, temp);
            qucikSort(nums, temp + 1, end);
        }


        public void swap(int[] nums, int swapA, int swapB) {
            if (swapA == swapB) {
                return;
            }
            nums[swapA] += nums[swapB];
            nums[swapB] = nums[swapA] - nums[swapB];
            nums[swapA] = nums[swapA] - nums[swapB];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}