import sun.swing.StringUIClientPropertyKey;

import java.util.Objects;

/**
* 统计打字方案数
*/
public class Solution_2266{
    public static void main(String[] args) {
        Solution s = new Solution_2266().new Solution();
        int result = s.countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555");
        System.out.println(result);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final Integer divValue = 1000000007;



    public int countTexts(String pressedKeys) {
        Long result = 1L;
        char currentChar = pressedKeys.charAt(0);
        int start = 0;
        for (int i = 0 ; i < pressedKeys.length() ; i++){
            if (currentChar != pressedKeys.charAt(i)){
                String sameWord = pressedKeys.substring(start, i);
                result*=getSameWordCount(sameWord);
                if (result > divValue){
                    result %= divValue;
                }
                currentChar = pressedKeys.charAt(i);
                start=i;
            }
        }
        String substring = pressedKeys.substring(start);
        result*=getSameWordCount(substring);
        if (result > divValue){
            result %= divValue;
        }
        return result.intValue();
    }

    private Long getSameWordCount(String sameWord) {
        Long result = 0L;
        if (sameWord.length() == 0){
            return 1L;
        }
        if (sameWord.charAt(0)=='7' || sameWord.charAt(0)=='9'){

            Long a = 0L , b = 0L , c = 0L , d = 1L;
            for (int i = 0 ; i <sameWord.length() ; i++){
                Long tempRes = a + b + c + d;
                if(tempRes > divValue){
                    tempRes %= divValue;
                }
                a=b;b=c;c=d;d=tempRes;
                result = tempRes;

            }
        }else{
            Long a = 0L , b = 0L , c = 0L , d = 1L;
            for (int i = 0 ; i <sameWord.length() ; i++){
                Long tempRes = b + c + d;
                if(tempRes > divValue){
                    tempRes %= divValue;
                }
                b=c;c=d;d=tempRes;
                result = tempRes;

            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
