//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 287 👎 0


package newCode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        int result = solution.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,1},{1,1,0}});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1]==1){return -1;}
            if (grid.length==1&&grid[0].length==1){
                return 1;
            }
            
            Set<Integer> alreadyRun = new HashSet<>();
            Set<Integer> currentRow = new HashSet<>();
            rowGet(grid, alreadyRun, currentRow, 0, 0);
            return littlePath(grid, alreadyRun, currentRow, 1);
        }

        public void rowGet(int[][] grid, Set<Integer> alreadyRun, Set<Integer> currentRow, int x, int y) {
            int leftLimit = 0, rightLimit = grid[0].length - 1, topLimit = 0, buttonLimit = grid.length - 1;
            int currentFlag = x * 100 + y;
            alreadyRun.add(currentFlag);
            // left
            int leftFlag = x * 100 + y - 1;
            if (y - 1 >= leftLimit && grid[x][y - 1] == 0 && !alreadyRun.contains(leftFlag)) {
                currentRow.add(leftFlag);
            }
            // right
            int rightFlag = x * 100 + y + 1;
            if (y + 1 <= rightLimit && grid[x][y + 1] == 0 && !alreadyRun.contains(rightFlag)) {
                currentRow.add(rightFlag);
            }
            // top
            int topFlag = (x - 1) * 100 + y;
            if (x - 1 >= topLimit && grid[x - 1][y] == 0 && !alreadyRun.contains(topFlag)) {
                currentRow.add(topFlag);
            }
            // button
            int buttonFlag = (x + 1) * 100 + y;
            if (x + 1 <= buttonLimit && grid[x + 1][y] == 0 && !alreadyRun.contains(buttonFlag)) {
                currentRow.add(buttonFlag);
            }
            // left-top
            int leftTopFlag = (x - 1) * 100 + (y - 1);
            if (x - 1 >= topLimit && y - 1 >= leftLimit && grid[x - 1][y - 1] == 0 && !alreadyRun.contains(leftTopFlag)) {
                currentRow.add(leftTopFlag);
            }
            // right-top
            int rightTopFlag = (x - 1) * 100 + (y + 1);
            if (x - 1 >= topLimit && y + 1 <= rightLimit && grid[x - 1][y + 1] == 0 && !alreadyRun.contains(rightTopFlag)) {
                currentRow.add(rightTopFlag);
            }
            // left-button
            int leftButton = (x + 1) * 100 + (y - 1);
            if (x + 1 <= buttonLimit && y - 1 >= leftLimit && grid[x + 1][y - 1] == 0 && !alreadyRun.contains(leftButton)) {
                currentRow.add(leftButton);
            }
            // right-button
            int rightButtonFlag = (x + 1) * 100 + (y + 1);
            if (x + 1 <= buttonLimit && y + 1 <= rightLimit && grid[x + 1][y + 1] == 0 && !alreadyRun.contains(rightButtonFlag)) {
                currentRow.add(rightButtonFlag);
            }
        }

        public int littlePath(int[][] grid, Set<Integer> alreadyRun, Set<Integer> currentRow, int result) {
            int resultVlua = (grid.length - 1) * 100 + (grid[0].length - 1);
            if (currentRow.contains(resultVlua)) {
                return result + 1;
            }
            if (currentRow.isEmpty()) {
                return -1;
            }
            alreadyRun.addAll(currentRow);
            Set<Integer> newCurrentRow = new HashSet<>();
            for (Integer innerFlag : currentRow) {
                int x = innerFlag / 100;
                int y = innerFlag % 100;
                rowGet(grid, alreadyRun, newCurrentRow, x, y);
            }
            return littlePath(grid, alreadyRun, newCurrentRow, result + 1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}