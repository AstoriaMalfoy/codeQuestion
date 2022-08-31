package newCode.leetcode.editor.cn.Q640;

public class Question_640{
    public static void main(String[] args){
        new Question_640().run();
    }
    public void run(){
//        String result = new Solution().solveEquation("x+5-3+x=0");
//        String result = new Solution().solveEquation("x+5-3+x=6+x-2");
//        String result = new Solution().solveEquation("x=x");
//        String result = new Solution().solveEquation("2x=x");
//        String result = new Solution().solveEquation("x+1=x-2");
        String result = new Solution().solveEquation("-x=-1");
        System.out.println(result);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        equation = "x+5-3+x=0"
    public static final String noResult = "No solution";
    public static final String noLimit = "Infinite solutions";

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String reverStr = reverse(split[0],split[1]);
        if (!(reverStr.charAt(0)=='-' || reverStr.charAt(0)=='+')){
            reverStr = "+" + reverStr + "+0";
        }else{
            reverStr = reverStr + "+0";
        }
        // 拆分 构建X数量 构建常量数量
        int course = 0;
        int xCount = 0,cCount =0;
        boolean containX = false;
        for (int i=0;i<reverStr.length();i++){
            if (reverStr.charAt(i)=='x'){
                containX = true;
            }
            if ((reverStr.charAt(i)=='-' || reverStr.charAt(i)=='+') && course!=i){
                String subStr = reverStr.substring(course,i);
                if (subStr.charAt(0)=='-'){
                    if (containX){
                        xCount-=getXIndex(subStr.substring(1));
                    }else{
                        cCount-=strToInt(subStr.substring(1));
                    }
                }else if(subStr.charAt(0) == '+'){
                    if (containX){
                        xCount+=getXIndex(subStr.substring(1));
                    }else{
                        cCount+=strToInt(subStr.substring(1));
                    }
                }

                course=i;containX = false;
            }
        }

        if (xCount == 0){
            if (cCount == 0){
                return noLimit;
            }else{
                return noResult;
            }
        }else{
            if (cCount == 0){
                return "x=0";
            }else{
                return "x=" + String.valueOf(cCount/(-xCount));
            }
        }

    }

    private int getXIndex(String substring) {
        String newStr = substring.replace("x", "");
        if (newStr.equals("")){
            newStr = "1";
        }
        return strToInt(newStr);
    }

    private int strToInt(String newStr) {
        int result = 0;
        for (int i = 0 ; i <newStr.length(); i++){
            result = result * 10 + (newStr.charAt(i) - '0');
        }
        return result;
    }

    private String reverse(String leftStr, String rightStr) {
        StringBuilder result = new StringBuilder();
        result.append(leftStr);
        // 符号预先处理
        if (!(rightStr.charAt(0)=='+' || rightStr.charAt(0) == '-')){
            rightStr = "+" + rightStr + "+0";
        }else{
            rightStr = rightStr + "+0";
        }
        int subLineStart = 0;
        int strLength = rightStr.length();
        for (int i=0;i<strLength;i++){
            if ((rightStr.charAt(i)=='+' || rightStr.charAt(i)=='-')&&subLineStart!=i){
                String tempStr = rightStr.substring(subLineStart,i);
                if (tempStr.charAt(0)=='-'){
                    result.append("+").append(tempStr.substring(1));
                }
                if (tempStr.charAt(0)=='+'){
                    result.append("-").append(tempStr.substring(1));
                }
                subLineStart = i;
            }
        }
        return result.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

