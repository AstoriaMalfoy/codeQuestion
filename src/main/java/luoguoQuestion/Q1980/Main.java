package luoguoQuestion.Q1980;

import java.util.Scanner;


/**
 * 数论DP
 *  input  numnber getCount
 *  str1 x str2
 *  限制 str1 范围 [1-str1 共 str1种
 *  限制 str2 方位 [0-str2 共 str2+1种
 *  如果 x < getCount [1,str),[0,str2]  (srt1-1,str2+1)
 *
 */
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer inputNumber = scanner.nextInt();
        int flagNumber = scanner.nextInt();

        String numberStr = String.valueOf(inputNumber);
        int resultCount = 0;
        for(int i=0;i<numberStr.length();++i){
            int placeCount = getPlaceCount(numberStr, flagNumber, i);
//            System.out.println(placeCount);
            resultCount+=placeCount;
        }
        System.out.println(resultCount);

    }

    /**
     * 判断该位置为 flagNumber 情况下的情况数量
     * @param numberStr
     * @param flagNumber
     * @param i
     * @return
     */
    private static int getPlaceCount(String numberStr, int flagNumber, int i) {
        String xStr = numberStr.charAt(i) + "";
        int x = Integer.parseInt(xStr);
        String strPrefix = numberStr.substring(0,i);
        String strStuffix = numberStr.substring(i+1);
//        System.out.println(strPrefix + "   " + strStuffix);
        // 如果要查找的数为0;
        if(flagNumber == 0){
            // 位于首位
            if(i == 0){
                return 0;
            }else if(i != numberStr.length()-1){
                return (Integer.parseInt(strPrefix)-1) * getBaseValue(strStuffix.length()) + Integer.parseInt(strStuffix)+1;
            }else{
                return Integer.parseInt(strPrefix);
            }
        }else{
            if(i==0){
                if(x > flagNumber){
                    return getBaseValue(strStuffix.length());
                }else if(x == flagNumber){
                    return Integer.parseInt(strStuffix)+1;
                }else{
                    return 0;
                }
            }else if(i != numberStr.length()-1){
                if(x > flagNumber){
                  return (Integer.parseInt(strPrefix)+1)*getBaseValue(strStuffix.length());
                } else if(x == flagNumber){
                    return Integer.parseInt(strPrefix)*getBaseValue(strStuffix.length()) + Integer.parseInt(strStuffix)+1;
                }else{
                    return Integer.parseInt(strPrefix)*getBaseValue(strStuffix.length());
                }
            }else{
                if(x>=flagNumber){
                    return Integer.parseInt(strPrefix)+1;
                }else{
                    return Integer.parseInt(strPrefix);
                }
            }
        }
    }

    private static int getBaseValue(int length) {
        int result =1;
        for(int i=0;i<length;++i){
            result *= 10;
        }
        return result;
    }
}