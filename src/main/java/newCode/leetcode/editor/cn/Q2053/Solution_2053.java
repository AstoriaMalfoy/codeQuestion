import java.util.*;

/**
* 数组中第 K 个独一无二的字符串	
*/
public class Solution_2053{
    public static void main(String[] args) {
        Solution s = new Solution_2053().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> strCountHashMap = new HashMap<>();
        for (String s : arr) {
            Integer count;
            if (Objects.isNull(count =  strCountHashMap.get(s))){
                strCountHashMap.put(s,1);
            }else{
                strCountHashMap.put(s,count+1);
            }
        }

        for (int  i = 0 , target = 1 ; i < arr.length ; i++){
            Integer strCount = strCountHashMap.get(arr[i]);
            if (strCount == 1){
                if (target == k) {
                    return arr[i];
                }else{
                    target++;
                }
            }
        }
        return "";

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
