package newCode.leetcode.editor.cn.Q1413;

public class Question_1413{
    public static void main(String[] args){
        new Question_1413().run();
    }
    public void run(){
        System.out.println(new Solution().minStartValue(new int[]{1,-2,-3}));
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minStartValue(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int startValue = 0;
        for (int num : nums) {
            startValue += num;
            if (startValue < minValue){
                minValue = startValue;
            }
        }
        return (0-minValue)+1 <= 0 ? 1 : (0-minValue)+1 ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

