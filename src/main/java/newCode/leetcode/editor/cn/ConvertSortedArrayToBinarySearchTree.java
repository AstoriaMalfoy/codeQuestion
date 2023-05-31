//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 
// 👍 1318 👎 0


package newCode.leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     *  x x+1
     *  x-x x+1+1 x+1
     *
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums,0,nums.length);
        }

        public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
            if (start >= nums.length || start == end){
                return null;
            }
            if (start + 1 > end){
                return new TreeNode(nums[start]);
            }
            int middle = (start + end) / 2;
            TreeNode currentNode = new TreeNode(nums[middle]);
            currentNode.left = sortedArrayToBST(nums,start,middle);
            currentNode.right = sortedArrayToBST(nums,middle+1,end);
            return currentNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}