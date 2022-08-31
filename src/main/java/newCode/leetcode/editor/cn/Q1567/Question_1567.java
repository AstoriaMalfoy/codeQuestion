package newCode.leetcode.editor.cn.Q1567;

public class Question_1567{
    public static void main(String[] args){
        new Question_1567().run();
    }

    public void run(){
//        int maxLen = new Solution().getMaxLen(new int[]{-1,2});
//        int maxLen = new Solution().getMaxLen(new int[]{2,-1});
//        int maxLen = new Solution().getMaxLen(new int[]{1,-2,-3,4});
//        int maxLen = new Solution().getMaxLen(new int[]{0,1,-2,-3,-4});
//        int maxLen = new Solution().getMaxLen(new int[]{-1,-2,-3,0,1});
        int maxLen = new Solution().getMaxLen(new int[]{-16,0,-14,4,-13,-17,-19,-17,-21,-11,12});
        System.out.println(maxLen);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxLen(int[] nums) {
        int result = 0;
        int lessCount=0;
        int leftLessPoint=-1,rightLessPoint=-1;
        int start = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                if (lessCount % 2 == 0){
                    if(i - start > result){
                        result = i - start;
                    }
                }else{
                    if (leftLessPoint - start >result){result = leftLessPoint - start ;}
                    if (i-leftLessPoint-1 > result){result = i-leftLessPoint-1;}
                    if (rightLessPoint - start > result){result = rightLessPoint - start;}
                    if (i - rightLessPoint-1 > result){result = i - rightLessPoint-1;}
                }
                start = i+1;
                lessCount=0;leftLessPoint=-1;rightLessPoint=-1;
            }else{
                if (nums[i] < 0){
                    if (lessCount==0){
                        leftLessPoint = i;
                    }
                    rightLessPoint = i;
                    lessCount++;
                }
            }
        }
        if (lessCount % 2 == 0){
            if(nums.length - start > result){
                result = nums.length - start;
            }

        }else{
            if (leftLessPoint - start >result){result = leftLessPoint - start ;}
            if (nums.length-leftLessPoint-1 > result){result = nums.length-leftLessPoint-1;}
            if (rightLessPoint - start > result){result = rightLessPoint - start;}
            if (nums.length - rightLessPoint-1 > result){result = nums.length - rightLessPoint-1;}
        }
        return result;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}

