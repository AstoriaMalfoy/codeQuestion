import java.util.*;

public class Solution_438{
    public static void main(String[] args) {
        Solution s = new Solution_438().new Solution();
        System.out.println(s);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * O(n^2)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> tempCharcterMap = getTempMap(p);
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()){
            return result;
        }
        int windowsLeft = 0 , windowsRight = p.length()-1;
        /**
         * O(n)
         */
        while(windowsRight < s.length()){
            if (anagrams(s,windowsLeft,windowsRight,p)){
                result.add(windowsLeft);
            }
        }
        return result;
    }

    private Map<Character, Integer> getTempMap(String p) {
        Map<Character,Integer> result = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Character character = p.charAt(i);

        }
    }

    /**
     *
     * @param s
     * @param windowsLeft
     * @param windowsRight
     * @param p
     * @return
     *
     * O(p.length) - O(n)
     */
    private boolean anagrams(String s, int windowsLeft, int windowsRight, String p) {
        Map<Character,Integer> tempMap = new HashMap<>();
        // O(n)
        for (int i = 0; i < p.length(); i++ , windowsLeft++) {
            Character tempCharacter =  s.charAt(windowsLeft);
            Integer characterCount = null;
            if (Objects.isNull(characterCount =  tempMap.get(tempCharacter))){
                tempMap.put(tempCharacter,0);
            }else{
                tempMap.put(tempCharacter,++characterCount);
            }
        }


        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
