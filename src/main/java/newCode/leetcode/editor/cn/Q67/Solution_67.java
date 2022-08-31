package newCode.leetcode.editor.cn.Q67;

/**
* 二进制求和	
*/
public class Solution_67{
    public static void main(String[] args) {
        Solution s = new Solution_67().new Solution();
        String s1 = s.addBinary("1010", "1011");
        System.out.println(s1);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        String result = new String();
        int pointA = a.length()-1,pointB = b.length()-1;
        int jinwei = 0;
        while (pointA >= 0 || pointB >= 0){
            int currentValue = getPoint(a,pointA--) + getPoint(b,pointB--) + jinwei;
            jinwei = 0;
            if (currentValue == 3){
                currentValue = 1;
                jinwei = 1;
            }
            if (currentValue == 2){
                currentValue = 0;
                jinwei = 1;
            }
            result = "" + currentValue + result;
        }
        if (jinwei == 1){
            result = "" + jinwei  +  result;
        }
        return result;
    }

    private int getPoint(String b, int pointB) {
        if (pointB < 0){
            return 0;
        }else{
            return b.charAt(pointB) - '0';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
