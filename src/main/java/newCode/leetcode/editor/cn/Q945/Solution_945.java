import java.util.Arrays;

/**
* 使数组唯一的最小增量	题目标题	示例:两数之和
*/
public class Solution_945{
    public static void main(String[] args) {
        Solution s = new Solution_945().new Solution();
        int i = s.minIncrementForUnique(new int[]{1,2,3});
        System.out.println(i);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minIncrementForUnique(int[] nums) {
        // 排序
        quickSort(nums);
        int result = 0;
        for (int  i = 1 ; i < nums.length ; i++){
            if (nums[i] <= nums[i-1]){
                result+=nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return result;
    }

    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length);
    }

    public void quickSort(int[] nums,int start,int end){
        if (end <= start +1 ){
            return;
        }
        int temp = nums[start];
        int leftCourse = start + 1 , course = start + 1;

        while (course < end){
            if (temp > nums[course]){
                swap(nums,leftCourse++,course);
            }
            course++;
        }
        swap(nums,start,leftCourse-1);
        quickSort(nums,start,leftCourse-1);
        quickSort(nums,leftCourse,end);
    }

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
