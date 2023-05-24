//给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
//
// 
// 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。 
// 青蛙无法跳回已经访问过的顶点。 
// 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。 
// 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。 
// 
//
// 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。 
//
// 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10⁻⁵ 的结果将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//输出：0.16666666666666666 
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙
//在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//输出：0.3333333333333333
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 
// 👍 68 👎 0


package newCode.leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.*;

public class FrogPositionAfterTSeconds {
    public static void main(String[] args) {
        Solution solution = new FrogPositionAfterTSeconds().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double frogPosition(int n, int[][] edges, int t, int target) {
            if (n == 1) {
                return target == 1 ? 1 : 0;
            }

            Map<Integer,List<Integer>> preDict = new HashMap<>();
            for (int[] edge : edges) {
                // index 0
                if (preDict.containsKey(edge[0])){
                    preDict.get(edge[0]).add(edge[1]);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(edge[1]);
                    preDict.put(edge[0],list);
                }
                // index 1
                if (preDict.containsKey(edge[1])){
                    preDict.get(edge[1]).add(edge[0]);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(edge[0]);
                    preDict.put(edge[1],list);
                }
            }

            Map<Integer, List<Integer>> outerDict = new HashMap<>();
            Map<Integer, Integer> inerDict = new HashMap<>();

            convertDict(preDict,outerDict,inerDict,0,1);

            // 不存在目标点 直接返回0
            if (!inerDict.containsKey(target)) {
                return 0;
            }
            //回溯路径，获取完整路径
            List<Integer> nline = new ArrayList<>();
            int currentValue = target;
            while (currentValue != 1) {
                nline.add(currentValue);
                if (!inerDict.containsKey(currentValue)) {
                    return 0;
                }
                currentValue = inerDict.get(currentValue);
            }
            // 经过ts无法到达target,返回0
            nline.add(1);
            if (nline.size() - 1 > t) {
                return 0;
            }
            // 不是刚好到达，并且目标节点还有子节点，直接返回0
            if (nline.size() - 1 < t && outerDict.containsKey(target)){
                return 0;
            }
            int sum = 1;
            for (int i = nline.size() - 1; i > 0; i--) {
                List<Integer> list = outerDict.get(nline.get(i));
                if (list == null) {
                    continue;
                }
                sum *= list.size();

            }
            if (sum == 1) {
                return 1;
            }
            return 1.0D / sum;
        }

        /**
         * 维护节点的入度和出度
         * @param preDict
         * @param outerDict
         * @param inerDict
         * @param parent
         * @param current
         */
        private void convertDict(Map<Integer, List<Integer>> preDict, Map<Integer, List<Integer>> outerDict, Map<Integer, Integer> inerDict, int parent,int current) {
            List<Integer> currentOuter = preDict.get(current);
            currentOuter.remove(Integer.valueOf(parent));
            if (!currentOuter.isEmpty()){
                outerDict.put(current,currentOuter);
                for (Integer integer : currentOuter) {
                    convertDict(preDict,outerDict,inerDict,current,integer);
                }
            }
            if (current != 1){
                inerDict.put(current,parent);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}