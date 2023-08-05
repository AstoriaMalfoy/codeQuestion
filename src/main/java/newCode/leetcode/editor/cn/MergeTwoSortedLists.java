//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 
// 👍 3212 👎 0


package newCode.leetcode.editor.cn;


 class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode listNode1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode result = solution.mergeTwoLists(listNode1,listNode2);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1== null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode resultListNode = new ListNode();
            ListNode resultCur = resultListNode;
            ListNode leftCur = list1;
            ListNode rightCur = list2;

            while (leftCur != null || rightCur != null) {
                if (leftCur != null && rightCur != null) {
                    if (leftCur.val > rightCur.val) {
                        resultCur.next = new ListNode(rightCur.val);
                        rightCur = rightCur.next;
                    } else {
                        resultCur.next = new ListNode(leftCur.val);
                        leftCur = leftCur.next;
                    }
                } else if (leftCur != null) {
                    resultCur.next = new ListNode(leftCur.val);
                    leftCur = leftCur.next;
                } else {
                    resultCur.next = new ListNode(rightCur.val);
                    rightCur = rightCur.next;
                }
                resultCur = resultCur.next;
            }
            return resultListNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
