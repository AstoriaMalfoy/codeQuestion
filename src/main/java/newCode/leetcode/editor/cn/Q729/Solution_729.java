package newCode.leetcode.editor.cn.Q729;

import java.util.*;

/**
* 我的日程安排表
*/
public class Solution_729{
    public static void main(String[] args) {
        MyCalendar s = new Solution_729().new MyCalendar();

    }
//leetcode submit region begin(Prohibit modification and deletion)
//class MyCalendar {
//
//
//    private List<Node> calendarList = new ArrayList<>();
//
//    public MyCalendar() {
//
//    }
//
//
//    public boolean book(int start, int end) {
//        Boolean contain = checkContain(start, end);
//        if (!contain){
//            calendarList.add(new Node(start,end));
//        }
//        return !contain;
//    }
//
//    private Boolean checkContain(int start, int end) {
//        for (Node node : calendarList) {
//            if (node.conotain(start,end)){
//                return true;
//            }
//        }
//        return false;
//
//    }
//
//
//    private class Node{
//
//        public Integer left;
//        public Integer right;
//
//        public Node(Integer left, Integer right) {
//            this.left = left;
//            this.right = right;
//        }
//
//        public boolean conotain(int start,int end){
//            if (left!=end){
//                return !(start >= right || end <=left);
//            }else{
//                return (start>=left && left <end);
//            }
//        }
//    }
//
//}
class MyCalendar {
    Set<Integer> tree;
    Set<Integer> lazy;      // 记录已经被全部预定的节点的ID

    public MyCalendar() {
        tree = new HashSet<Integer>();
        lazy = new HashSet<Integer>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 1000000000, 1)) {
            return false;
        }
        update(start, end - 1, 0, 1000000000, 1);
        return true;
    }

    /**
     *
     * [] 左闭右闭
     *
     * @param start 需要判断的左区间
     * @param end   需要判断的右区间
     * @param l     线段树节点左区间
     * @param r     线段树节点右区间
     * @param idx   节点编号
     * @return
     */
    public boolean query(int start, int end, int l, int r, int idx) {
        if (start > r || end < l) {
            return false;
        }
        /* 如果该区间已被预订，则直接返回 */
        if (lazy.contains(idx)) {
            return true;
        }
        if (start <= l && r <= end) {
            return tree.contains(idx);
        } else {
            int mid = (l + r) >> 1;
            if (end <= mid) {
                return query(start, end, l, mid, 2 * idx);
            } else if (start > mid) {
                return query(start, end, mid + 1, r, 2 * idx + 1);
            } else {
                return query(start, end, l, mid, 2 * idx) | query(start, end, mid + 1, r, 2 * idx + 1);
            }
        }
    }

    public void update(int start, int end, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        if (start <= l && r <= end) {
            tree.add(idx);
            lazy.add(idx);
        } else {
            int mid = (l + r) >> 1;
            update(start, end, l, mid, 2 * idx);
            update(start, end, mid + 1, r, 2 * idx + 1);
            tree.add(idx);
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
