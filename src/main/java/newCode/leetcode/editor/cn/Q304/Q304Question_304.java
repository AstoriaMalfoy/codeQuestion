package newCode.leetcode.editor.cn.Q304;

public class Q304Question_304 {
    public static void main(String[] args){
        new Q304Question_304().run();
    }

    public void run(){
        new NumMatrix(new int[][]{});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    int[][] matrix = null;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i=row1;i<=row2;i++){
            for (int j = col1;j<=col2;j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

