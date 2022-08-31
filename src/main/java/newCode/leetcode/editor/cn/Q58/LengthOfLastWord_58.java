package newCode.leetcode.editor.cn;


/**
* 58_最后一个单词的长度
**/
public class LengthOfLastWord_58{
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord_58().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        String[] wordList = s.split(" ");
        return wordList[wordList.length-1].length();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



