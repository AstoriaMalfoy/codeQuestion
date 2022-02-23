package newCode.leetcode.editor.cn;


/**
* 53_最大子数组和
**/
public class MaximumSubarray_53{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray_53().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // 边界条件 只有一个元素
        if (nums.length == 1){
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int tempSum = nums[0];
        for (int i=1;i<nums.length;i++){
        }
        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



