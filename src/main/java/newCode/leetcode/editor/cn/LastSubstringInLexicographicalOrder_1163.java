package newCode.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * xxx[result1]xxxxx[result2]xxxxxx[result3]xxx
**/
public class LastSubstringInLexicographicalOrder_1163{
    public static void main(String[] args) {
        Solution solution = new LastSubstringInLexicographicalOrder_1163().new Solution();
        String result = solution.lastSubstring("cacacb");
        System.out.println(result);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String lastSubstring(String s) {
        int strLength = s.length();
        int fixPoint = 0;
        int movPoint = 0;

        Boolean loop = false;

        int loopStrBegin = 0;
        for (int i = 1; i < strLength ; i ++ ){
            if (loop){
                // 循环状态下 首字母判断 特殊条件
                if (s.charAt(i) > s.charAt(fixPoint)){
                        loop =false;
                        fixPoint = i;
                        movPoint = i;
                }

                // 循环的朴素情况
                // 循环状态下 字符相同 同时后移 判断后续
                if (s.charAt(movPoint) == s.charAt(i)){
                    movPoint ++ ;
                }
                // 循环状态下 当前串字符小于循环串 设置循环串为当前串 打破循环状态
                if (s.charAt(movPoint) < s.charAt(i)){
                    loop = false;
                    fixPoint = loopStrBegin;
                    movPoint = loopStrBegin;
                }
                // 循环状态下 当前串字符大于循环串 当前串数值更大 打破循环
                if (s.charAt(movPoint) > s.charAt(i)){
                    loop = false;
                    movPoint = fixPoint;
                }
            }else{
                // 非循环状态 平凡状态
                if (s.charAt(i) < s.charAt(fixPoint)){
                    // 目标串小于当前串的首字母 当前串依旧最大
                    continue;
                }
                if (s.charAt(i) == s.charAt(fixPoint)){
                    // 相同 进入循环
                    loop = true;
                    loopStrBegin = i;
                    // 当前字母和当前串字母位置差一并且元素相同 设置全串元素相同标志位
                }
                if (s.charAt(i) > s.charAt(fixPoint)){
                    fixPoint = i;
                }
            }
        }


        return s.substring(fixPoint);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



