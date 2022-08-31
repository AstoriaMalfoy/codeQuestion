package newCode.leetcode.editor.cn.Q513;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Solution_513{
    public static void main(String[] args) {
        Solution s = new Solution_513().new Solution();
        System.out.println(s);
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * @param root
         * @return
         */
        public int findBottomLeftValue(TreeNode root) {
            List<TreeNode> rowNodeCollection = new ArrayList<>();
            rowNodeCollection.add(root);
            TreeNode leftTreeNode = root;
            while (!rowNodeCollection.isEmpty()){
                List<TreeNode> tempTreeNode = new ArrayList<>();
                for (TreeNode treeNode : rowNodeCollection) {
                    if (Objects.nonNull(treeNode.left)){
                        tempTreeNode.add(treeNode.left);
                    }
                    if (Objects.nonNull(treeNode.right)){
                        tempTreeNode.add(treeNode.right);
                    }
                }
                leftTreeNode = rowNodeCollection.get(0);
                rowNodeCollection = tempTreeNode;
            }

            return leftTreeNode.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

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



