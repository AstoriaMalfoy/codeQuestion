package newCode.leetcode.editor.cn;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
* 14_最长公共前缀
**/
public class LongestCommonPrefix_14{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix_14().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            AtomicInteger tempSize = new AtomicInteger(Integer.MAX_VALUE);
            Arrays.stream(strs).forEach(
                    s -> {
                        if (s.length() < tempSize.get()){
                            tempSize.set(s.length());
                        }
                    }
            );

            int shotSize = tempSize.get();

            StringBuilder stringBuilder = new StringBuilder();

            boolean thisAllSame = true;
            for (int i = 0; i < shotSize && thisAllSame; i++) {
                thisAllSame = true;
                char currentChar = strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].charAt(i) != currentChar){
                        thisAllSame = false;
                    }
                }
                if (thisAllSame){
                    stringBuilder.append("" + currentChar);
                }
            }

            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



