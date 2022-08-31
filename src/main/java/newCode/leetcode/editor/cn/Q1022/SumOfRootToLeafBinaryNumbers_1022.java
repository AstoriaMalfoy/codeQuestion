package newCode.leetcode.editor.cn;


import java.util.Objects;

/**
* 1022_从根到叶的二进制数之和
**/
public class SumOfRootToLeafBinaryNumbers_1022{


    public static void main(String[] args) {
        TreeNode node = new SumOfRootToLeafBinaryNumbers_1022().getNode();
        Solution solution = new SumOfRootToLeafBinaryNumbers_1022().new Solution();
        int i = solution.sumRootToLeaf(node);
        System.out.println(i);
    }
    public TreeNode getNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        return root;
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

    public int sumRootToLeaf(TreeNode root) {
        return getSum(root,"");
    }

    int getSum(TreeNode node,String pre){
        int leftSum = 0 , rightSum = 0;
        String childValue = pre + String.valueOf(node.val);

        if (Objects.isNull(node.left) &&  Objects.isNull(node.right)){
            leftSum = binToTen(childValue);
        }else if (Objects.isNull(node.left)){
            rightSum = getSum(node.right,childValue);
        }else if (Objects.isNull(node.right)){
            leftSum = getSum(node.left,childValue);
        }else{
            leftSum = getSum(node.left,childValue);
            rightSum = getSum(node.right,childValue);
        }
        return leftSum + rightSum;
    }

    private int binToTen(String rightBinValue) {
//        System.out.println(rightBinValue + "  "  +Integer.parseInt(rightBinValue,2));
        return Integer.parseInt(rightBinValue,2);
    }

}

 public class TreeNode {
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

//leetcode submit region end(Prohibit modification and deletion)

}



