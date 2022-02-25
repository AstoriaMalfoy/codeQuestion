package newCode.leetcode.editor.cn;


import java.math.BigInteger;
import java.util.Arrays;

/**
* 66_加一
**/
public class PlusOne_66{
    public static void main(String[] args) {
        Solution solution = new PlusOne_66().new Solution();
        int[] ints = solution.plusOne(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(ints));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int digit : digits) {
            stringBuilder.append("" + digit);
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.toString());
        bigInteger = bigInteger.add(BigInteger.ONE);
        String resultStr = bigInteger.toString();
        char[] chars = resultStr.toCharArray();
        int[] result = new int[chars.length];
        for (int i=0;i<result.length;++i){
            result[i] = chars[i] - '0';
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



