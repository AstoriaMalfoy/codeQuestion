package newCode.leetcode.editor.cn;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* 307_区域和检索 - 数组可修改
**/
public class RangeSumQueryMutable_307{
    public static void main(String[] args) {
        Solution solution = new RangeSumQueryMutable_307().new Solution();
        Integer result = solution.getResult();
        System.out.println(result);
    }


    class Solution{
        public Integer getResult(){
            RangeSumQueryMutable_307.NumArray numArray = new NumArray(new int[]{1,3,5});
            numArray.update(0,2);
            numArray.update(1,2);
            int i = numArray.sumRange(0, 2);
            return i;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private class Node{
            public Integer leftLimit;
            public Integer rightLimit;
            public Integer sum;
            public NumArray.Node leftChildNode;
            public NumArray.Node rightChildNode;
        }

        private Node treeNode;

        List<Integer> nums = null;

        public NumArray(int[] nums) {
            treeNode = getSubTreeNode(nums,0,nums.length-1);
        }

        public void update(int index, int val) {
            updateSum(treeNode,index,val);
        }

        public int sumRange(int left, int right) {
            return getSum(treeNode,left,right);
        }

        /**
         * 构建线段树
         * @param nums        需要构建线段树的数列
         * @param start       构建线段树的左区间
         * @param end         构建线段树的右区间
         * @return            根据左右区间构建的线段树root节点 (左闭右闭)
         */
        Node getSubTreeNode(int[] nums,Integer start,Integer end){
            Node node = new Node();
            if (end <= start){
                node.sum = nums[start];
                node.leftChildNode = node.rightChildNode = null;
                node.leftLimit = node.rightLimit = start;
                return node;
            }
            Integer mid ;
            node.leftChildNode = getSubTreeNode(nums,start, mid =  (start + end) >> 1 );
            node.rightChildNode = getSubTreeNode(nums,mid + 1 , end);
            node.leftLimit = start;
            node.rightLimit = end;
            node.sum = 0;
            if (Objects.nonNull(node.leftChildNode)){
                node.sum += node.leftChildNode.sum;
            }
            if (Objects.nonNull(node.rightChildNode)){
                node.sum += node.rightChildNode.sum;
            }
            return node;
        }

        /**
         * 计算开闭区间的和
         * @param rootNode  节点
         * @param start     左区间
         * @param end       右区间
         * @return
         */
        public int getSum(Node rootNode,int start,int end){
            if (Objects.isNull(rootNode)) {
                return 0;
            }
            // 判断当前节点是否能直接计算出结果
            if (start <= rootNode.leftLimit && rootNode.rightLimit <= end){
                return rootNode.sum;
            }else{
                // 无法直接从根节点获取结果
                return getSum(Objects.isNull(rootNode.leftChildNode) ? null : rootNode.leftChildNode,start,end) +
                        getSum(Objects.isNull(rootNode.rightChildNode) ? null : rootNode.rightChildNode, start,end);
            }
        }

        /**
         * 更新节点的值
         * @param node
         * @param position
         * @param value
         */
        public int updateSum(Node node,int position,int value){
            if (Objects.isNull(node)){
                return 0;
            }
            if (node.leftLimit == node.rightLimit && node.rightLimit == position){
                int result = (value - node.sum);
                node.sum = value;
                return result;
            }
            if (node.leftLimit <= position && position <= node.rightLimit){
                int leftNodeSum = updateSum(Objects.isNull(node.leftChildNode) ? null : node.leftChildNode,position,value);
                int rightNodeSum = updateSum(Objects.isNull(node.rightChildNode) ? null : node.rightChildNode ,position,
                        value);
                node.sum += leftNodeSum ;
                node.sum += rightNodeSum;
                return leftNodeSum + rightNodeSum;
            }
            return 0;
        }

    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}



