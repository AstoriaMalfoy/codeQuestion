//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 
// 👍 1370 👎 0


package newCode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        Map<TreeNode,Integer> hightDict = new HashMap<>();

        public boolean isBalanced(TreeNode root) {
            if (root == null){
                return true;
            }
            return Math.abs(hight(root.left) - hight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int hight(TreeNode currentNode){
            if (hightDict.containsKey(currentNode)){
                return hightDict.get(currentNode);
            }

            if (currentNode == null){
                return 0;
            }
            int currnetHight = Math.max(hight(currentNode.left),hight(currentNode.right)) + 1;
            hightDict.put(currentNode,currnetHight);
            return currnetHight;
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}