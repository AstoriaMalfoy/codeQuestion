package newCode.leetcode.editor.cn;


import java.util.Arrays;

/**
* 917_仅仅反转字母
**/
public class ReverseOnlyLetters_917{
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters_917().new Solution();
        String s = solution.reverseOnlyLetters("AB-CD-E");
        System.out.println(s);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    final int a = 'a';
    final int z = 'z';
    final int A = 'A';
    final int Z = 'Z';

    public String reverseOnlyLetters(String s) {

        char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if ( isCharacter( startChar ) ){
                if ( isCharacter( endChar ) ){
                    // revers
                    chars[start] = chars[end];
                    chars[end] = startChar;
                    start ++ ;
                    end -- ;
                }else{
                    end -- ;
                }
            }else{
                start ++ ;
            }
//            System.out.println(String.copyValueOf(chars));
        }
        return String.copyValueOf(chars);
    }

    public Boolean isCharacter(char c){
        return (a <= c && c <= z) || ( A <= c && c <= Z );
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



