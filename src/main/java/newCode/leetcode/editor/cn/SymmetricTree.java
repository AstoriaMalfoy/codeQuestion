 //给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 2434 👎 0

  
package newCode.leetcode.editor.cn;

 import java.util.Stack;

 public class SymmetricTree{
  public static void main(String[] args) {
       Solution solution = new SymmetricTree().new Solution();
  } 
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode aTree = stack.pop();
            TreeNode bTree = stack.pop();
            if (aTree == bTree && aTree == null){
                continue;
            }
            if (aTree == null || bTree == null || aTree.val != bTree.val){
                return false;
            }
            stack.push(aTree.left);
            stack.push(bTree.right);

            stack.push(aTree.right);
            stack.push(bTree.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        if (left == right && left == null){
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}