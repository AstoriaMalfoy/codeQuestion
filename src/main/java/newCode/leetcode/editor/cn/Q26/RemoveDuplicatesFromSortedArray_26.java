package newCode.leetcode.editor.cn.Q26;


/**
* 26_删除有序数组中的重复项
**/
public class RemoveDuplicatesFromSortedArray_26{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray_26().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int start = 0;
            for (int i = 1 ; i < nums.length; ++i){
                if (nums[i] != nums[start]){
                    start ++;
                    nums[start] = nums[i];
                }
            }
            return start+1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



