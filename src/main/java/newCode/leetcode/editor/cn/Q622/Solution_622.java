package newCode.leetcode.editor.cn.Q622;

/**
* 设计循环队列	
*/
public class Solution_622{
    public static void main(String[] args) {
        MyCircularQueue obj = new Solution_622().new MyCircularQueue(8);
        /**
         * Your MyCircularQueue object will be instantiated and called as such:
         */
        boolean b = obj.enQueue(3);
        boolean b1 = obj.enQueue(9);
        boolean b2 = obj.enQueue(5);
        boolean b3 = obj.enQueue(0);
        boolean b4 = obj.deQueue();
        boolean b5 = obj.deQueue();
        boolean empty = obj.isEmpty();
        boolean empty1 = obj.isEmpty();
        int rear = obj.Rear();
        int rear1 = obj.Rear();
        boolean b6 = obj.deQueue();
        System.out.println("De");

    }
//leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {


        private int[] valueArea;
        private int caption = 0 ;
        private int size = 0;
        private int headPos = -1;
        private int tailPos = -1;
        private int currentPos = -1;

        public MyCircularQueue(int k) {
            valueArea = new int[k];
            caption = k;
        }

        // 插入
        public boolean enQueue(int value) {
            if (size == caption){
                return false;
            }
            currentPos = (currentPos + 1 ) % caption;
            valueArea[currentPos] = value;
            size ++;
            if (size == 1){
                headPos = currentPos;
            }
            tailPos = currentPos;
            return true;
        }

        // 删除
        public boolean deQueue() {
            if (size == 0){
                return false;
            }
            headPos = headPos + 1 == caption ? 0 : headPos + 1;
            size--;
            if (size == 0){
                reinit();
            }
            return true;
        }

        private void reinit() {
            currentPos = -1;
            headPos = -1;
            tailPos = -1;
        }

        public int Front() {
            if (size == 0) {
                return  -1;
            }
            int tempValue = valueArea[headPos];
//            headPos = (headPos + 1) % caption;
//            size --;
//            if (size == 0){
//                reinit();
//            }
            return tempValue;
        }

        public int Rear() {
            if (size == 0) {
                return -1;
            }
            int tempValue =  valueArea[tailPos];
//            tailPos = tailPos - 1 == -1 ? caption-1:tailPos-1;
//            size--;
//            if (size == 0){
//                reinit();
//            }
            return tempValue;
        }

        public boolean isEmpty() {
            return size == 0 ;
        }

        public boolean isFull() {
            return caption == size;
        }
    }
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
