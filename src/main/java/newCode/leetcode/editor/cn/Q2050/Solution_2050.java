
import java.util.*;

/**
* 并行课程 III	
*/
public class Solution_2050{
    public static void main(String[] args) {
        Solution s = new Solution_2050().new Solution();
        int i = s.minimumTime(5, new int[][]{{1,5},{2,5},{3,5},{3,4},{4,5}}, new int[]{1,2,3,4,5});
        System.out.println(i);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] csList = new int[n+1];

        Map<Integer,List<Integer>> treeMap = new HashMap<>();
        Map<Integer,Integer> resultCache = new HashMap<>();
        for (int[] relation : relations) {
            List<Integer> rel = treeMap.get(relation[1]);
            if (Objects.isNull(rel)){
                rel = new ArrayList<>();
            }
            rel.add(relation[0]);
            treeMap.put(relation[1],rel);
            csList[relation[0]] = 1;
        }

        List<Integer> rootTree = new ArrayList<>();
        for (int i = 1 ; i <= n ; i ++){
            if (csList[i] == 0){
                rootTree.add(i);
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i : rootTree) {
            int tempVlaue ;
            if (maxTime < (tempVlaue = getMaxClass(i,treeMap,time,resultCache))){
                maxTime = tempVlaue;
            }
        }

        return maxTime;
    }

    private int getMaxClass(int i, Map<Integer, List<Integer>> treeMap, int[] time, Map<Integer, Integer> resultCache) {
        List<Integer> subList = treeMap.get(i);
        if (Objects.isNull(subList)){
            return time[i-1];
        }
        int maxTime = Integer.MIN_VALUE;
        for (Integer subClass : subList) {
            Integer res = resultCache.get(subClass);
            if (Objects.isNull(res)){
                res = getMaxClass(subClass,treeMap,time,resultCache);
            }
            resultCache.put(subClass,res);
            if (res > maxTime) {
                maxTime = res;
            }
        }
        return maxTime + time[i-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
