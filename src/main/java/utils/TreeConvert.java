package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ LITAO.
 *
 * @author litao
 * @since 2023/5/22 15:45
 */
public class TreeConvert {
    public interface TreeNodeInt {
        int getValue();

        TreeNodeInt getLeft();

        TreeNodeInt getRight();

        void setLeft(TreeNodeInt left);

        void setRight(TreeNodeInt right);

        void setValue(int value);
    }

    public static class TreeNodeBase implements TreeNodeInt{

        private int value;
        private TreeNodeBase left;
        private TreeNodeBase right;

        @Override
        public int getValue() {
            return 0;
        }

        @Override
        public TreeNodeInt getLeft() {
            return null;
        }

        @Override
        public TreeNodeInt getRight() {
            return null;
        }

        @Override
        public void setLeft(TreeNodeInt left) {

        }

        @Override
        public void setRight(TreeNodeInt right) {

        }

        @Override
        public void setValue(int value) {

        }
    }


    public static TreeNodeInt getTreeNodeByList(List<Integer> initDataList){
        Queue queue = new LinkedList<>();
        
        return null;
    }
}
