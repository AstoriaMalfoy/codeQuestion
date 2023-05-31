//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1829 👎 0


package newCode.leetcode.editor.cn;


import practice.D230522_AC;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) {
                return new ArrayList<>();
            }
            if (root.right != null) {
                stack.push(root.right);
            }
            stack.push(new TreeNode(root.val));
            if (root.left != null) {
                stack.push(root.left);
            }
            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.pop();
                if (currentNode.left == null && currentNode.right == null) {
                    result.add(currentNode.val);
                    continue;
                }
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                stack.push(new TreeNode(currentNode.val));
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            }
            return result;
        }

        public void middleIter(TreeNode currentNode, List<Integer> result) {
            if (currentNode == null) {
                return;
            }
            if (currentNode.left != null) {
                middleIter(currentNode.left, result);
            }
            result.add(currentNode.val);
            if (currentNode.right != null) {
                middleIter(currentNode.right, result);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}