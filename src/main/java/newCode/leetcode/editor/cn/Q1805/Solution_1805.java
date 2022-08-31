
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution_1805{
    public static void main(String[] args) {
        Solution s = new Solution_1805().new Solution();
        int result = s.numDifferentIntegers("0000as00sdf09980asdfa9980");
        System.out.println(result);
        String s1 = s.cutNumber("000jklj0098lkj0098asdadf");
        System.out.println(s1);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDifferentIntegers(String word) {
        return extractedB(word);
    }

    private int extractedB(String word) {
        int lenght = word.length();
        Set<String> hashSet = new HashSet<>();
        Boolean numTail = true , firstZero = true;
        int numberStart = -1 , numberEnd = 0;
        for (int i= 0 ; i < word.length() ; i++){
            char c ;
            if ('0' <= (c = word.charAt(i)) && c <= '9'){
                if (numTail){
                    numTail  = false;
                    numberStart = i;
                }
                if ('0' == c && firstZero){
                    numberStart++;
                }else{
                    firstZero = false;
                }
                if (i!=word.length()-1){
                    continue;
                }else{
                    i++;
                }
            }
            firstZero = true;
            numberEnd = i;
            if (!numTail){
                if (numberStart >= numberEnd){
                    hashSet.add("0");
                }else{
                    hashSet.add(word.substring(numberStart,numberEnd));
                }
            }
            numTail = true;
        }
        return hashSet.size();
    }

    private int extractedA(String word) {
        int lenght = word.length();
        String[] split = word.replaceAll("([A-Za-z])", " ").split(" ");
        Set<String> resultCollection = new HashSet<>();
        for (String s : split) {
            String str = cutNumber(s);
            if (Objects.nonNull(str)){
                resultCollection.add(str);
            }
        }
        return resultCollection.size();
    }

    private String cutNumber(String s) {
        if ("".equals(s) || Objects.isNull(s)){
            return null;
        }
        int zeroFlag = -1;
        for (int i =0 ; i < s.length() ; i++){
            if (s.charAt(i) == '0'){
                zeroFlag++;
            }else{
                break;
            }
        }
        if (zeroFlag == -1){
            return s;
        }
        if (zeroFlag == s.length() -1){
            return "0";
        }
        return s.substring(zeroFlag+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
