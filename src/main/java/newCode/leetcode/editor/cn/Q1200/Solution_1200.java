
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
* 最小绝对差	题目标题	示例:两数之和
*/
public class Solution_1200{
    public static void main(String[] args) {
        Solution s = new Solution_1200().new Solution();
        int[] arrays = new int[]{4,2,1,3};
        List<List<Integer>> result = s.minimumAbsDifference(arrays);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + "   ");
            }
            System.out.println();
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        quickSort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minValue = arr[arr.length -1 ] - arr[0];
        for (int i = 1 ; i <arr.length; i ++){
            int tempReslut = arr[i] - arr[i-1];
            if (tempReslut < minValue){
                minValue = tempReslut;
                result = new ArrayList<>();
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }else if (tempReslut == minValue){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }

    public void quickSort(int[] array){
        quickSort(array,0,array.length);
    }

    public void quickSort(int[] array,int start,int end){
        if (end <= start + 1){
            return;
        }
        int valueTemp = array[start];
        int left = start + 1 , cuorse = start + 1;
        while(cuorse < end){
            if (array[cuorse] < valueTemp){
                tempValue(array,left,cuorse);
                left++;
            }
            cuorse++;
        }
        left = left - 1;
        tempValue(array,start,left);
        quickSort(array,start,left);
        quickSort(array,left+1,end);
    }

    public void tempValue(int[] arrays,int swapA,int swapB){
        if (swapA == swapB){
            return;
        }
        arrays[swapA] += arrays[swapB];
        arrays[swapB] = arrays[swapA] - arrays[swapB];
        arrays[swapA] = arrays[swapA] - arrays[swapB];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
