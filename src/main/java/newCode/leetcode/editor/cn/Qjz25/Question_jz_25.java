package newCode.leetcode.editor.cn.Qjz25;

import java.util.Objects;
import java.util.function.ObjLongConsumer;

public class Question_jz_25 {
    public static void main(String[] args) {
        new Question_jz_25().run();
    }

    public void run() {
        Solution.ListNode listNode = new Solution().mergeTwoLists(
                new Solution().new ListNode(1, new Solution().new ListNode(2, new Solution().new ListNode(4))),
                new Solution().new ListNode(1, new Solution().new ListNode(3, new Solution().new ListNode(4)))
        );
        System.out.println(listNode);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (Objects.isNull(l1)){
                return l2;
            }
            if (Objects.isNull(l2)){
                return l1;
            }
            ListNode result = new ListNode();
            ListNode l1Point = l1,l2Point = l2 , resPoint = result;
            Boolean firstNode = true;
            while(Objects.nonNull(l1Point) || Objects.nonNull(l2Point)){
                if (Objects.isNull(l1Point)){
                    resPoint.next = new ListNode(l2Point.val);
                    resPoint = resPoint.next;
                    l2Point = l2Point.next;
                }else if (Objects.isNull(l2Point)){
                    resPoint.next = new ListNode(l1Point.val);
                    resPoint = resPoint.next;
                    l1Point = l1Point.next;
                }else{
                    if (l1Point.val > l2Point.val){
                        if (firstNode){
                            resPoint.val = l2Point.val;
                            firstNode = false;
                        }else{
                            resPoint.next = new ListNode(l2Point.val);
                            resPoint = resPoint.next;
                        }
                        l2Point = l2Point.next;
                    }else{
                        if (firstNode){
                            resPoint.val = l1Point.val;
                            firstNode = false;
                        }else{
                            resPoint.next = new ListNode(l1Point.val);
                            resPoint = resPoint.next;
                        }
                        l1Point = l1Point.next;
                    }
                }
            }
            return result;
        }

        public class ListNode {
            int val;
            ListNode next;

            public ListNode(int x) {
                val = x;
                next = null;
            }
            public ListNode(){

            }
            public ListNode(int x,ListNode listNode){
                val = x;
                next = listNode;
            }

            public String toString(){
                String str =   val + "->" ;
                if (Objects.nonNull(next)){
                    str += next.toString();
                }
                return str;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     //
     // 示例1：
     //
     // 输入：1->2->4, 1->3->4
     //输出：1->1->2->3->4->4
     //
     // 限制：
     //
     // 0 <= 链表长度 <= 1000
     //
     // 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     //
     // 👍 315 👎 0

     */
}

