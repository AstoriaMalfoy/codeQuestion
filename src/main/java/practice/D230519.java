package practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by IntelliJ LITAO.
 *
 * @author litao
 * @since 2023/5/19 14:35
 */
public class D230519 {
    public static void main(String[] args) {
        String inpuStr = "AABBCA";
        new D230519().getDiffAndRep(inpuStr,1);
    }

    public Integer getResult(String inputStr){
        /**
         * 暴力：
         *
         */

        return 0;
        /**
         * fn(list,k)       -- list中，相同元素数量为k的元素数量
         * f(list,R) = f(list,1) + f(list,2) + f(list,3) + ... + f(list,R)  R = list.size()
         * f(list,2) = f(list,1) * (f(list,1) - 1) + fn(list,2)    -- 两个完全不相同的
         * 
         *             
         */
    }

    public int getDiffAndRep(String str,int lestCount){
        int[] tempResult = new int[str.length()+1];
        HashMap<Character,Integer> dictMap = new HashMap<>();
        for (int i = 0 ; i < str.length() ; i ++){
            if (dictMap.containsKey(str.charAt(i))){
                int value = dictMap.get(str.charAt(i)) + 1;
                dictMap.put(str.charAt(i),value);
                tempResult[value]++;
            }else{
                dictMap.put(str.charAt(i),1);
                tempResult[1]++;
            }
        }
        System.out.println(Arrays.toString(tempResult));
        return tempResult[lestCount];
    }

}
