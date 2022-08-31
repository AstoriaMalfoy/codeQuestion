package newCode.leetcode.editor.cn;


import java.util.Objects;

/**
* 21_合并两个有序链表
**/
public class MergeTwoSortedLists_21{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists_21().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归基
        if (Objects.isNull(list1)){
            return list2;
        }
        if (Objects.isNull(list2)){
            return list1;
        }

        return new ListNode(
                Math.min(list1.val, list2.val),
                list1.val < list2.val ?
                        mergeTwoLists(list1.next,list2):
                        mergeTwoLists(list1,list2.next)
                );
    }
}
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//leetcode submit region end(Prohibit modification and deletion)

}



