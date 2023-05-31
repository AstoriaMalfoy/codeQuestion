//给出二叉树的根节点 root，树上每个节点都有一个不同的值。
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。 
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数最大为 1000。 
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。 
// to_delete.length <= 1000 
// to_delete 包含一些从 1 到 1000、各不相同的值。 
// 
//
// Related Topics 树 深度优先搜索 数组 哈希表 二叉树 
// 👍 241 👎 0


package newCode.leetcode.editor.cn;

import java.util.*;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
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
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> delSet = new HashSet<>();
            for (int currentValue : to_delete) {
                delSet.add(currentValue);
            }
            List<TreeNode> result = new ArrayList<>();
            delNodes(root,delSet,result,null);
            return result;
        }

        public void delNodes(TreeNode currentNode, Set<Integer> delSet, List<TreeNode> forest,TreeNode parentNode) {
            if (currentNode == null){
                return;
            }
            if (parentNode == null){
                if (!delSet.contains(currentNode.val)){
                    forest.add(currentNode);
                    delNodes(currentNode.left,delSet,forest,currentNode);
                    delNodes(currentNode.right,delSet,forest,currentNode);
                }else{
                    delNodes(currentNode.left,delSet,forest,null);
                    delNodes(currentNode.right,delSet,forest,null);
                }
            }else{
                if (delSet.contains(currentNode.val)){
                    if (parentNode.left == currentNode){
                        parentNode.left = null;
                    }else{
                        parentNode.right = null;
                    }
                    delNodes(currentNode.left,delSet,forest,null);
                    delNodes(currentNode.right,delSet,forest,null);
                }else{
                    delNodes(currentNode.left,delSet,forest,currentNode);
                    delNodes(currentNode.right,delSet,forest,currentNode);
                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}