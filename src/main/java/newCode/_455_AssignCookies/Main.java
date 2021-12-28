package newCode._455_AssignCookies;

import java.util.Arrays;

/**
 * @author litao34
 * @ClassName Main
 * @Description https://leetcode.com/problems/assign-cookies/
 * @CreateDate 2021/12/28-7:25 PM
 **/
public class Main {


    private class Solution {


        /**
         *
         * @param g childCount
         * @param s cookiesCount
         * @return how many child full
         */
        public int findContentChildren(int[] g, int[] s) {
            // 双游标
            // 针对 g s 排序
            Arrays.sort(g);
            Arrays.sort(s);

            int result = 0;

            int cursor_g=0,cursor_s=0;
            int g_size = g.length,s_size = s.length;
            //  child游标
            for (; cursor_g < g_size; cursor_g++) {
                // cookies 游标
                while(cursor_s < s_size && s[cursor_s] < g[cursor_g]){
                    cursor_s++;
                }

                if (cursor_s < s_size &&  g[cursor_g] <= s[cursor_s]){
                    result++;
                    // 当前并饼干已经被吃掉了
                    cursor_s++;
                }
            }
            // 外层 O(n) 内层总共O(n) 排序 O(nlogn)  -> O(nlog(n))
            return result;
        }
    }


    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(new Main(). new Solution().findContentChildren(g,s) );
    }
}
