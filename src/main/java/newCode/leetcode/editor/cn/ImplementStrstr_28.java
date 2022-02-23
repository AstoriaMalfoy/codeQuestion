package newCode.leetcode.editor.cn;


import com.sun.tools.javac.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

/**
* 28_实现 strStr()
**/
public class ImplementStrstr_28{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr_28().new Solution();
        int i = solution.strStr("mississippi", "issip");
        System.out.println(i);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        // 目标串比子串长度短
        if (haystack.length() < needle.length()){
            return -1;
        }
        // 目标串和子串长度相同
        if (haystack.length() == needle.length()){
            if (haystack.equals(needle)){
                return 0;
            }else{
                return -1;
            }
        }
        // 子串比目标串长度短 需要进行比较
        int result = -1;
        int subPoint = 0;
        int targetPoint = 0;
        boolean allEqual = false;
        boolean hasMatch = false;

        int firstChar = -1;

        while(targetPoint < haystack.length() && subPoint < needle.length()){
            if (haystack.charAt(targetPoint) == needle.charAt(subPoint)){
                // 匹配成功 创建配置
                hasMatch  = true;
                if (subPoint == 0){
                    result = targetPoint;
                }
                targetPoint ++;
                subPoint++;
                // 子串已经完全匹配 退出循环 完成匹配
                if (subPoint == needle.length()){
                    allEqual = true;
                    break;
                }
            }else{
                if (hasMatch){
                    // 第一次异常匹配 匹配丢失 目标串位置回溯 子串移到开头 从新位置进行匹配检测
                    targetPoint = targetPoint - subPoint + 1;
                    subPoint = 0;

                    hasMatch = false;
                }else{
                    // 第二次异常匹配 说明当前位置和子串首位置不相同 目标串向后移动
                    targetPoint++;
                }
            }
        }

        if (allEqual){
            return result;
        }else{
            return -1;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



