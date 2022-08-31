

import apple.laf.JRSUIUtils;

import java.util.*;

/**
* 二叉树中所有距离为 K 的结点	
*/
public class Solution_863{
    public static void main(String[] args) {
        new Solution_863().test();
    }

    public void test(){
        Solution s = new Solution_863().new Solution();
        TreeNode tempNode = null;
        TreeNode treeNode = new TreeNode(3,
                tempNode = new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),new TreeNode(1,
                    new TreeNode(0),
                    new TreeNode(8))
                );
        TreeNode case2 = new TreeNode(0,
                 new TreeNode(1,new TreeNode(3),tempNode = new TreeNode(2)),
                null);

        /**
         *      0
         *   2        1
         * null  null 3
         */
        TreeNode case3 = new TreeNode(
                0,
                new TreeNode(2,null,null),
                new TreeNode(1,tempNode = new TreeNode(3),null)
        );



        TreeNode case4 = new TreeNode(
                0,
                new TreeNode(1,null,new TreeNode(2,null,tempNode = new TreeNode(3,null,new TreeNode(4)))),
                null
        );

        List<Integer> integers = s.distanceK(case4, tempNode, 0);
        System.out.println(integers);
    }
//leetcode submit region begin(Prohibit modification and deletion)
//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x,TreeNode leftNode,TreeNode right){
        this.val = x;
        this.left = leftNode;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 构建从根节点到目标节点的路径数组;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        search(stack,target);
        Set<Integer> reslut = new HashSet<>();
        TreeNode expNode = null;
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            findDisk(pop,k--,reslut,expNode);
            expNode = pop;

        }
//        reslut.remove(target.val);
        return new ArrayList<>(reslut);
    }

    private void findDisk(TreeNode node, int i, Set<Integer> reslut,TreeNode expectNode) {
        if (i<0){
            return;
        }
        if (Objects.isNull(node)){
            return;
        }
        if (i == 0 ){
            reslut.add(node.val);
        }
        if (Objects.isNull(expectNode)){
            findDisk(node.left,i-1,reslut,expectNode);
            findDisk(node.right,i-1,reslut,expectNode);
        }else{
            if (!expectNode.equals(node.left)){
                findDisk(node.left,i-1,reslut,expectNode);
            }
            if (!expectNode.equals(node.right)){
                findDisk(node.right,i-1,reslut,expectNode);
            }
        }
    }

    public Boolean search(Stack<TreeNode> stack,TreeNode targer){
        TreeNode peek = stack.peek();
        if (Objects.isNull(peek)){
            return false;
        }
        if (peek.val == targer.val){
            return true;
        }
        stack.push(peek.left);
        Boolean search = search(stack, targer);
        if (!search){
            stack.pop();
        }else{
            return true;
        }
        stack.push(peek.right);
        search = search(stack, targer);
        if (!search){
            stack.pop();
        }else{
            return true;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
