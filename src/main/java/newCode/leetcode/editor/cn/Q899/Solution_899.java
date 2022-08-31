
/**
* 有序队列	
*/
public class Solution_899{
    public static void main(String[] args) {
        Solution s = new Solution_899().new Solution();
        String result = s.orderlyQueue("baaca", 3);
        System.out.println(result);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String orderlyQueue(String s, int k) {
        if ( k == 1){
            return oneCharacterStr(s);
        }else{
            return orderStr(s);
        }
    }

    private String orderStr(String s) {
        int[] charaCount = new int[26];
        for (int i = 0 ; i < s.length(); i++){
            charaCount[s.charAt(i) - 'a'] ++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < 26 ; i ++){
            while (charaCount[i] > 0){
                charaCount[i]--;
                result.append((char) ('a' + i) + "");
            }
        }
        return result.toString();
    }

    private String oneCharacterStr(String s) {
        String tempStr = s;
        for (int i = 0 ; i < s.length() ; i++){
            StringBuilder subStr = new StringBuilder().append(s.substring(i)).append(s.substring(0,i));
            if (tempStr.compareTo(subStr.toString()) > 0){
                tempStr = subStr.toString();
            }
        }
        return tempStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
