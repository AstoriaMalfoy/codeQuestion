package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ LITAO.
 *
 * @author litao
 * @since 2023/5/22 14:42
 */
public class D230522_AC {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ",\n left=" + left +
                    ",\n right=" + right +
                    '}';
        }
    }

    class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root == null) {
                return null;
            }
            if (isDelLeaf(root, 0, limit)) {
                return null;
            }
            return root;
        }

        public boolean isDelLeaf(TreeNode treeNode, int parentSum, int limie) {
            if (treeNode == null) {
                return true;
            }
            if (treeNode.left == null && treeNode.right == null) {
                return parentSum + treeNode.val < limie;
            }

            boolean leftDel = isDelLeaf(treeNode.left, parentSum + treeNode.val, limie);
            boolean rightDEl = isDelLeaf(treeNode.right, parentSum + treeNode.val, limie);
            if (leftDel) {
                treeNode.left = null;
            }
            if (rightDEl) {
                treeNode.right = null;
            }
            return leftDel && rightDEl;
        }

    }

    public static void main(String[] args) {
        D230522_AC d230522AC = new D230522_AC();
        Solution solution = d230522AC.new Solution();
        // [5,4,8,11,null,17,4 ,7,1 ,null,null,5,3]
        TreeNode treeNode = new TreeNode(
                5,
                new TreeNode(
                        4,
                        new TreeNode(11,
                                new TreeNode(7, null, null),
                                new TreeNode(1, null, null)),
                        null
                ),
                new TreeNode(
                        8,
                        new TreeNode(17, null, null),
                        new TreeNode(4,
                                new TreeNode(5, null, null),
                                new TreeNode(3, null, null))
                )
        );

        //  [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]
        TreeNode treeNode1 = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4,
                                new TreeNode(8, null, null),
                                new TreeNode(9, null, null)),
                        new TreeNode(-99,
                                new TreeNode(-99, null, null),
                                new TreeNode(-99, null, null))
                ),
                new TreeNode(
                        3,
                        new TreeNode(-99,
                                new TreeNode(12, null, null),
                                new TreeNode(13, null, null)),
                        new TreeNode(7,
                                new TreeNode(-99, null, null),
                                new TreeNode(14, null, null))
                )
        );
        TreeNode result = solution.sufficientSubset(treeNode1, 1);
        System.out.println(cengSearch(result));
    }


    public static List cengSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(treeNode.val);
        result.addAll(cengSearch(treeNode.left));
        result.addAll(cengSearch(treeNode.right));
        return result;
    }

    /**
     * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
     * 输出：[1,2,3,4,null,null,7,8,9,null,14]
     *
     * 输入：root = [5,4,8,11,null,17,4 ,7,1 ,null,null,5,3], limit = 22
     * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
     *
     *
     * 输入：root = [1,2,-3,-5,null,4,null], limit = -1
     * 输出：[1,null,-3,4]
     */
}
