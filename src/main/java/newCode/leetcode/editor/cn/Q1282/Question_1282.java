package newCode.leetcode.editor.cn.Q1282;

import java.util.*;

public class Question_1282{
    public static void main(String[] args){
        new Question_1282().run();
    }
    public void run(){
//        List<List<Integer>> lists = new Solution().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        List<List<Integer>> lists = new Solution().groupThePeople(new int[]{2,1,3,3,3,2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int size = groupSizes.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i<size ; i++){
            List<Integer> tempList = map.get(groupSizes[i]);
            if (Objects.isNull(tempList)){
                List<Integer> elemList = new ArrayList<>();
                elemList.add(i);
                map.put(groupSizes[i],elemList);
            }else{
                tempList.add(i);
            }
        }
        for (Integer integer : map.keySet()) {
            List<Integer> integers = map.get(integer);
            List<List<Integer>> split = split(integers, integer);
            result.addAll(split);
        }
        return result;
    }

    private List<List<Integer>> split(List<Integer> numList, Integer count) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int i=0,j=0;i<numList.size();i++){
            if (j<count){
                subList.add(numList.get(i));
                j++;
            }else{
                result.add(subList);
                subList = new ArrayList<>();
                subList.add(numList.get(i));
                j=1;
            }
        }
        result.add(subList);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

