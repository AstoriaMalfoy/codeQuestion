package newCode.leetcode.editor.cn.Q13;


import java.util.Arrays;

/**
 * 13_罗马数字转整数
 **/
public class RomanToInteger_13 {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger_13().new Solution();
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            int length  = s.length();
            int result = 0;
            for (int i = 0; i < length; i++) {
                char currentChar = s.charAt(i);
                if (i + 1 < length){
                    char nextChar = s.charAt(i+1);
                    if (Arrays.stream(VALUES.values()).anyMatch(values -> values.getStr().equals("" + currentChar + nextChar))){
                        result += VALUES.getEnumByStr("" + currentChar + nextChar).getCode();
                        i++;
                    }else{
                        result += VALUES.getEnumByStr("" + currentChar).getCode();
                    }
                }else{
                    result += VALUES.getEnumByStr("" + currentChar).getCode();
                }
            }
            return result;
        }

    }

    enum VALUES {

        /**
         *  罗马数字枚举
         */
        I("I",1),
        V("V",5),
        X("X",10),
        L("L",50),
        C("C",100),
        D("D",500),
        M("M",1000),
        IV("IV",4),
        IX("IX",9),
        XL("XL",40),
        XC("XC",90),
        CD("CD",400),
        CM("CM",900);


        private String str;
        private Integer code;

        VALUES(String str,Integer code){
            this.str = str;
            this.code = code;
        }

        public String getStr(){
            return this.str;
        }

        public Integer getCode(){
            return this.code;
        }

        public static VALUES getEnumByStr(String str){
            return Arrays.stream(VALUES.values()).filter(values -> values.str.equals(str)).findFirst().orElse(null);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



