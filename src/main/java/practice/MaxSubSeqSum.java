package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSubSeqSum {
    public static void main(String[] args) {
        //int[] arrays = new int[]{1,23,4,6,5365,43,5,6,5,24,3,12,5,432,4,5,54,32,4,1,5,43,2,5};
        //System.out.println(new MaxSubSeqSum().getMaxSubSequenceSum(arrays));
        System.out.println(
                Arrays.toString(
                new MaxSubSeqSum().addNegabinary(
                new int[]{1,1},
                new int[]{1,1}
        )));
        System.out.println(
                Arrays.toString(
                new MaxSubSeqSum().addNegabinary(
                new int[]{1,1,1,1,1},
                new int[]{1,0,1}
        )));
    }

    public int getMaxSubSequenceSum(int[] arrays){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i=0;i<arrays.length;i++){
            currentSum += arrays[i];
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
            if (currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int maxLen = Math.max(arr1.length, arr2.length);
        int jinwei = 0 , jiewei = 0;
        ArrayList<Integer> resultList = new ArrayList();
        for (int i = 1 ; i <= maxLen ; i ++){
            int currnetValue;
            int currentA = 0 , currentB = 0;
            if (arr1.length - i >= 0){
                currentA = arr1[arr1.length - i];
            }
            if (arr2.length -i >= 0){
                currentB = arr2[arr2.length - i];
            }
            if (currentA + currentB + jinwei + jiewei < 0){
                // 借位
                currnetValue = (2 + currentA + currentB + jinwei + jiewei) % -2;
                jinwei = 0;
                jiewei = 1;
                resultList.add(currnetValue);
            }else{
                // 进位
                currnetValue = (currentA + currentB + jinwei + jiewei) % -2;
                jinwei = (currentA + currentB + jiewei + jinwei) / -2;
                jiewei = 0;
                resultList.add(currnetValue);
            }
        }
        if (jinwei == -1){
            resultList.add(1);
            resultList.add(1);
        }
        if (jiewei == 1){
            resultList.add(1);
        }
        int resultLenth = resultList.size();
        for (int i = resultList.size() -1 ; i >0 ; i --){
            if (resultList.get(i) == 0){
                resultLenth --;
            }else{
                break;
            }
        }

        int[] result = new int[resultLenth];
        for (int i = 0 ; i < resultLenth ; i ++){
            result[i] = resultList.get(resultLenth - i - 1);
        }

        return result;
    }

}
