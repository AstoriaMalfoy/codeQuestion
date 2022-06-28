package newCode.leetcode.editor.cn;


import java.util.*;

/**
*
**/
public class Solution_114{
    public static void main(String[] args) {
        String s = new Solution_114().new Solution().alienOrder(new String[]{"zy","zx"}); //yxz
        System.out.println(s);
    }



//    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public String alienOrder(String[] words) {
//
//            // 记录有向图的边
//            Map<Character,List<Character>> sortMap = new HashMap<>();
//            // 记录所以节点的入度
//            Map<Character,Integer> hasMorCharacter = new HashMap<>();
//            // 维护点
//            Set<Character> allCharacter = new HashSet<>();
//            for (int i = 0; i < words.length -1 ; i ++){
//                CharacterRes characterRes = getCharaRes(words[i],words[i+1]);
//                if (Objects.nonNull(characterRes)){
//                    if (Objects.equals(characterRes.lessCharacter,characterRes.bigCharacter)){
//                        allCharacter.add(characterRes.lessCharacter);
//                        List<Character> characters = sortMap.get(characterRes.bigCharacter);
//                        if (Objects.isNull(characters)){
//                            characters = new ArrayList<>();
//                        }
//                        sortMap.put(characterRes.bigCharacter,characters);
//                    }else{
//                        // 维护点
//                        allCharacter.add(characterRes.lessCharacter);
//                        allCharacter.add(characterRes.bigCharacter);
//                        // 维护向量边
//                        List<Character> characters = sortMap.get(characterRes.bigCharacter);
//                        if (Objects.isNull(characters)){
//                            characters = new ArrayList<>();
//                        }
//                        characters.add(characterRes.lessCharacter);
//                        sortMap.put(characterRes.bigCharacter,characters);
//                        // 维护点 入度
//                        Integer inDegree = hasMorCharacter.get(characterRes.lessCharacter);
//                        if (Objects.isNull(inDegree)){
//                            inDegree = 0;
//                        }
//                        hasMorCharacter.put(characterRes.lessCharacter,++inDegree);
//                    }
//                }
//            }
//            // 选择一个
//            String result = "";
//            for (Character character : allCharacter) {
//                if (Objects.isNull(hasMorCharacter.get(character))){
//                    // 选择一个入度为0的节点
//                    String tempStr =  getDegreeStr(sortMap,character);
//                    if (tempStr.length() > result.length()){
//                        result = tempStr;
//                    }
//                }
//            }
//            return result;
//        }
//
//        // 有向图深度遍历 选择最长的路径
//        private String getDegreeStr(Map<Character, List<Character>> sortMap, Character character) {
//            StringBuilder result = new StringBuilder();
//            result.append(character);
//            List<Character> childChar = sortMap.get(character);
//            if (Objects.isNull(childChar)){
//                return String.valueOf(character);
//            }
//            // 广度遍历
//            String maxStr = "";
//            for (Character c : childChar) {
//                String tempStr = "";
//                if ( (tempStr =  getDegreeStr(sortMap,c)).length() > maxStr.length()){
//                    maxStr =tempStr;
//                }
//            }
//            result.append(maxStr);
//            return result.toString();
//        }
//
//        // 获取有向图中的一个边
//        private CharacterRes getCharaRes(String word, String word1) {
//            if (word.equals(word1)){
//                CharacterRes characterRes = new CharacterRes();
//                characterRes.bigCharacter = word.charAt(0);
//                characterRes.lessCharacter = word.charAt(0);
//                return characterRes;
//            }
//            int l1 = word.length() , l2 = word1.length();
//            for (int i =0 ; i < Math.min(l1,l2) ; i ++){
//                if (word.charAt(i) != word1.charAt(i)){
//                    CharacterRes characterRes = new CharacterRes();
//                    characterRes.bigCharacter = word.charAt(i);
//                    characterRes.lessCharacter = word1.charAt(i);
//                    return characterRes;
//                }
//            }
//            return null;
//        }
//    }
//
//    class CharacterRes{
//        Character lessCharacter;
//        Character bigCharacter;
//    }
//    //leetcode submit region end(Prohibit modification and deletion)


    class Solution {
        static final int VISITING = 1, VISITED = 2;
        Map<Character, List<Character>> edges = new HashMap<Character, List<Character>>();
        Map<Character, Integer> states = new HashMap<Character, Integer>();
        boolean valid = true;
        char[] order;
        int index;

        public String alienOrder(String[] words) {
            int length = words.length;
            for (String word : words) {
                int wordLength = word.length();
                for (int j = 0; j < wordLength; j++) {
                    char c = word.charAt(j);
                    edges.putIfAbsent(c, new ArrayList<Character>());
                }
            }
            for (int i = 1; i < length && valid; i++) {
                addEdge(words[i - 1], words[i]);
            }
            order = new char[edges.size()];
            index = edges.size() - 1;
            Set<Character> letterSet = edges.keySet();
            for (char u : letterSet) {
                if (!states.containsKey(u)) {
                    dfs(u);
                }
            }
            if (!valid) {
                return "";
            }
            return new String(order);
        }

        public void addEdge(String before, String after) {
            int length1 = before.length(), length2 = after.length();
            int length = Math.min(length1, length2);
            int index = 0;
            while (index < length) {
                char c1 = before.charAt(index), c2 = after.charAt(index);
                if (c1 != c2) {
                    edges.get(c1).add(c2);
                    break;
                }
                index++;
            }
            if (index == length && length1 > length2) {
                valid = false;
            }
        }

        public void dfs(char u) {
            states.put(u, VISITING);
            List<Character> adjacent = edges.get(u);
            for (char v : adjacent) {
                if (!states.containsKey(v)) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (states.get(v) == VISITING) {
                    valid = false;
                    return;
                }
            }
            states.put(u, VISITED);
            order[index] = u;
            index--;
        }
    }


}



