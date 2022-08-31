package newCode.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
* 2170_使数组变成交替数组的最少操作数
**/
public class MinimumOperationsToMakeTheArrayAlternating_2170{
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeTheArrayAlternating_2170().new Solution();
        int i = solution.minimumOperations(new int[]{2,2,2,2});
        System.out.println(i);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(int[] nums) {


        if (nums.length == 1){
            return 0;
        }

        Map<Integer,Integer> firstLinkCount = new HashMap<>();
        Map<Integer,Integer> secondLinkCount = new HashMap<>();

        int numLength = nums.length;
        int lineAMax = 0, lineANextMax = 0;
        int lineAMaxNumber = Integer.MAX_VALUE ,lineANextMaxNumber = Integer.MAX_VALUE;
        int lineBMax = 0, lineBNextMax = 0;
        int lineBMaxNumber = Integer.MAX_VALUE,lineBNextMaxNumber = Integer.MAX_VALUE;

        for (int i=0;i<numLength;++i){
            if (i % 2 == 0){
                Integer count = firstLinkCount.get(nums[i]);
                // 维护map
                if (Objects.nonNull(count)){
                    firstLinkCount.put(nums[i],++count);
                }else{
                    firstLinkCount.put(nums[i], count = 1);
                }
                // 维护最大值和次大值
                if (count > lineAMax){
                    lineAMax = count;
                    lineAMaxNumber = nums[i];
                }else{
                    if (count > lineANextMax){
                        lineANextMax = count;
                        lineANextMaxNumber = nums[i];
                    }
                }
            }else{
                Integer count = secondLinkCount.get(nums[i]);
                if (Objects.nonNull(count)){
                    secondLinkCount.put(nums[i],++count);
                }else{
                    secondLinkCount.put(nums[i],count = 1);
                }

                // 维护最大值和次大值
                if (count > lineBMax){
                    lineBMax = count;
                    lineBMaxNumber = nums[i];
                }else{
                    if (count > lineBNextMax){
                        lineBNextMax = count;
                        lineBNextMaxNumber = nums[i];
                    }
                }
            }

        }
        // 计算结果
        if (lineAMaxNumber!=lineBMaxNumber){
            return nums.length - lineAMax - lineBMax;
        }else{
            return Math.min(
                    nums.length - lineAMax - lineBNextMax,
                    nums.length - lineANextMax - lineBMax
            );
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



