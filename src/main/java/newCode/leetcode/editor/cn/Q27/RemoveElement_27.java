package newCode.leetcode.editor.cn.Q27;


/**
* 27_移除元素
**/
public class RemoveElement_27{
    public static void main(String[] args) {
        Solution solution = new RemoveElement_27().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int temp = -1;
        for(int i = 0 ;i < nums.length; i++){
            if ( nums[i] != val){
                temp++;
                nums[temp] = nums[i];
            }
        }
        return temp+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



