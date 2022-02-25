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

        if (nums.length == 1){
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i=0;i<nums.length;i++){
            tempSum+=nums[i];
            if (tempSum > maxSum){
                maxSum = tempSum;
            }
            if (tempSum < 0){
                tempSum = 0;
            }
        }
        return maxSum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



