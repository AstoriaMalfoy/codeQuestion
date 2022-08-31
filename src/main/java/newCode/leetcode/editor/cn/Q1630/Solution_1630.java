
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* 等差子数组
*/
public class Solution_1630{
    public static void main(String[] args) {
        Solution s = new Solution_1630().new Solution();
        int[] array;
        List<Boolean> booleans = s.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
        System.out.println(booleans);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0 ; i < l.length ; i++ ){
            result.add(isArithet(nums,l[i],r[i]));
        }
        return result;
    }


    /**
     * 判断是不是等差数列    [a,b]
     * @param nums      数列
     * @param start     子区间开始
     * @param end       子区间结束
     * @return
     */
    private Boolean isArithet(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] tempRes = new int[length];
        for (int i = start ; i <= end; i ++){
            tempRes[i-start] = nums[i];
        }
        quickSort(tempRes);
        return checkArray(tempRes);
    }

    private Boolean checkArray(int[] tempRes) {
        if (tempRes.length == 1 || tempRes.length == 2 || tempRes.length == 0){
            return true;
        }
        int tempValue = tempRes[1] - tempRes[0];
        for (int i = 1; i < tempRes.length ; i ++){
            if (!(tempRes[i-1] + tempValue == tempRes[i])){
                return false;
            }
        }
        return true;
    }

    private void quickSort(int[] tempRes) {
        quickSort(tempRes,0,tempRes.length);
    }

    private void quickSort(int[] tempRes, int start, int end) {
        if (end <= start + 1){
            return;
        }
        int middleValue = tempRes[start];
        int middlePoint = start + 1 , currentPoint = start + 1;
        while(currentPoint < end){
            if (tempRes[currentPoint] < middleValue){
                swapValue(tempRes,currentPoint,middlePoint);
                middlePoint++;
            }
            currentPoint++;
        }
        middlePoint--;
        swapValue(tempRes,middlePoint,start);
        quickSort(tempRes,start,middlePoint);
        quickSort(tempRes,middlePoint+1,end);

    }

    private void swapValue(int[] tempRes, int swapA, int swapB) {
        if (swapA == swapB){
            return;
        }
        tempRes[swapA] += tempRes[swapB];
        tempRes[swapB] = tempRes[swapA] - tempRes[swapB];
        tempRes[swapA] = tempRes[swapA] - tempRes[swapB];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
