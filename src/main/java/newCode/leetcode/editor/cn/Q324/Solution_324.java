package newCode.leetcode.editor.cn.Q324;

import java.util.Arrays;

public class Solution_324{
    public static void main(String[] args) {
        Solution s = new Solution_324().new Solution();
        int[] result ;
        s.wiggleSort(result = new int[]{1,2,2,3,6});
        System.out.println(Arrays.toString(result));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        // 无脑解法 : 排序,然后交换顺序
        quickSort(nums,0,nums.length);
        // 交换顺序
        int x = (nums.length + 1) / 2;
        int leftPoint = x - 1 , rightPoint = nums.length-1;

        int[] result = new int[nums.length];
        boolean temp = true;
        for (int i = 0 ; i < nums.length ; i ++){
            if (temp){
                temp = !temp;
                result[i] = nums[leftPoint--];
            }else{
                temp = !temp;
                result[i] = nums[rightPoint--];
            }
        }
        for (int i = 0 ; i < nums.length; i ++){
            nums[i] = result[i];
        }
    }

    /**
     * 快排 左闭右开
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums,int start,int end){
        if (end <= start + 1){
            return;
        }
        int temp = nums[start];
        int lessPoint = start + 1,cursor = start + 1;
        while (cursor < end){
            if (nums[cursor]<temp){
                swap(nums,lessPoint,cursor);
                lessPoint++;
            }
            cursor++;
        }
        swap(nums,start,--lessPoint);
        quickSort(nums,start,lessPoint);
        quickSort(nums,lessPoint+1,end);
    }

    // 交换
    public void swap(int[] nums,int swapA,int swapB){
        if (swapA == swapB){
            return;
        }
        nums[swapA] += nums[swapB];
        nums[swapB] = nums[swapA] - nums[swapB];
        nums[swapA] = nums[swapA] - nums[swapB];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


/**
 *
 *  1  2  2  3  ->  2 1 2 3  -> 3 2 1 2
 *  cp position = length / 2 - 1
 *  cp position = length / 2 + 1
 *     2     3
 *  1     2
 *
 *                m   m1  m2  m3
 * repValue         x   x   x   x
 *                V   v2  v3  v4
 *
 *  v v2 v3 v4 x x x x m m1 m2 m3 m4
 *  v1 v2 x x x x m1 m2
 */
