package newCode.leetcode.editor.cn.Q35;


/**
* 35_搜索插入位置
**/
public class SearchInsertPosition_35{
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition_35().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        return getLastMinThanTarget(nums,0,nums.length,target);
    }


    /**
     * 寻找最后一个小于target的值
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int getLastMinThanTarget(int[] nums,int start,int end,int target){
        // 递归基
        if (start == end){
            if (start < nums.length){

                if (nums[start] < target){
                    return start+1;
                }else{
                    return start;
                }
            }else{
                return nums.length;
            }
        }

        int middle = (start + end) / 2;

        if (nums[middle] < target){
            return getLastMinThanTarget(nums,middle+1,end,target);
        }else{
            return getLastMinThanTarget(nums,start,middle,target);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}


