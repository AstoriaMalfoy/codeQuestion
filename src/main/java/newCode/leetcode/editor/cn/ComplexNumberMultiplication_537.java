package newCode.leetcode.editor.cn;


import java.util.Arrays;

/**
* 537_复数乘法
**/
public class ComplexNumberMultiplication_537{
    public static void main(String[] args) {
        Solution solution = new ComplexNumberMultiplication_537().new Solution();
        System.out.println(
                solution.complexNumberMultiply("1+-1i","1+-1i")
        );
    }

    /**
     *  (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i
     *  (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i
     *  a+bi c+di
     *  (a + bi) * (c + di) = ac + adi + bci + bdi^2 = ac-bd + (ad+bc)i
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int POSITIVE = 1;
    private final int NEGATIVE = 2;

    public String complexNumberMultiply(String num1, String num2) {
        int[] splitA = getIndex(num1);
        int[] splitB = getIndex(num2);
        int a = splitA[0],b = splitA[1],c = splitB[0],d = splitB[1];
        Integer resultPartA = (a * c) - (b * d);
        Integer resultPartB = (a * d) + (b * c);
        StringBuilder stringBuilder = new StringBuilder();
        return  stringBuilder.append(resultPartA.toString()).append("+").append(resultPartB.toString()).append("i").toString();
    }

        /**字符串分割
         * XcccXXccci
         * @param str
         * @return
         */
    public int[] getIndex(String str){
        int[] result = new int[3];
        // 首先分割两个数字的符号
        int firstNumebrSymble = 0;
        int secondNumberSymble = 0;

        int action = 0;

        String[] split = str.split("[0-9]{1,3}");
        if (split.length == 3){
            // 两处存在符号 提取第一个数字的符号
            if ("-".equals(split[0])){
                firstNumebrSymble = NEGATIVE;
            }else if("+".equals(split[0])){
                firstNumebrSymble = POSITIVE;
            }
            // 提取操作符号
            if (split[1].length() == 1){
                // 只有一个符号 默认操作为加法 符号为第二个操作数字的符号
                if ("+".equals(split[1])){
                    secondNumberSymble = POSITIVE;
                    action = POSITIVE;
                }else if ("-".equals(split[1])){
                    secondNumberSymble = NEGATIVE;
                    action = POSITIVE;
                }
            }else if (split[1].length() == 2){
                if ('+' == split[1].charAt(0)){
                    action = POSITIVE;
                    if ('+' == split[1].charAt(1)){
                        secondNumberSymble = POSITIVE;
                    }else if ('-' == split[1].charAt(1)){
                        secondNumberSymble = NEGATIVE;
                    }
                }else if ('-' == split[1].charAt(0)){
                    action = NEGATIVE;
                    if ('+' == split[1].charAt(1)){
                        secondNumberSymble = POSITIVE;
                    }else if ('-' == split[1].charAt(1)){
                        secondNumberSymble = NEGATIVE;
                    }
                }
            }

        }
        else{
            if (split[0].length() == 1){
                if ("-".equals(split[0])){
                    secondNumberSymble = NEGATIVE;
                    action = POSITIVE;
                }else if ("+".equals(split[0])){
                    secondNumberSymble = POSITIVE;
                    action = POSITIVE;
                }
            }else if (split[0].length() == 2){
                if ('+' == split[0].charAt(0)){
                    action = POSITIVE;
                }else if ('-' == split[0].charAt(0)){
                    action = NEGATIVE;
                }
                if ('+' == split[0].charAt(1)){
                    secondNumberSymble = POSITIVE;
                }else if ('-' == split[0].charAt(1)){
                    secondNumberSymble = NEGATIVE;
                }
            }
        }

        // 提取数字
        String replaceStr = str.replace('-', '-').replace('+', '-').replace("i", "").replace("--", "-");
        String[] split1 = replaceStr.split("-");
        int point = 0;
        for (String s : split1) {
            if (!"".equals(s.trim())){
                if (point == 0){
                    if (firstNumebrSymble == NEGATIVE){
                        result[point] = 0 - Integer.parseInt(s.trim());
                    }else{
                        result[point] = Integer.parseInt(s.trim());
                    }
                }else{
                    if (secondNumberSymble == NEGATIVE){
                        result[point] = 0 - Integer.parseInt(s.trim());
                    }else{
                        result[point] = Integer.parseInt(s.trim());
                    }
                }
                point++;
            }
        }
        result[point] = action;
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



