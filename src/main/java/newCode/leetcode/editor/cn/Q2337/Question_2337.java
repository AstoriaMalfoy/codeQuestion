package newCode.leetcode.editor.cn.Q2337;

import java.util.Objects;

public class Question_2337 {
    public static void main(String[] args) {
        new Question_2337().run();
    }

    public void run() {
        System.out.println(new Solution().canChange("_","_"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canChange(String start, String target) {
            // 相同
            if (Objects.equals(start,target)){
                return true;
            }
            // 长度不相同
            if (start.length() != target.length()){
                return false;
            }
            // 纯字符不匹配 -- 字符无法越位
            if (!Objects.equals(getCureLitter(start),getCureLitter(target))){
                return false;
            }
            boolean currentDeal = false;
            int startPoint = 0 , targetPoint = 0;
            while (startPoint < start.length() && targetPoint < target.length()){
                if (start.charAt(startPoint) == target.charAt(targetPoint) && (start.charAt(startPoint) == 'L' || start.charAt(startPoint) == 'R')){
                    if (start.charAt(startPoint) == 'L' && startPoint < targetPoint){
                        return false;
                    }else if (start.charAt(startPoint) == 'R' && startPoint > targetPoint){
                        return false;
                    }else{
                        startPoint++;
                        targetPoint++;
                    }
                }
                if (startPoint != start.length() && start.charAt(startPoint) != 'R' && start.charAt(startPoint) != 'L'){
                    startPoint++;
                }
                if (targetPoint != target.length() && target.charAt(targetPoint) != 'R' && target.charAt(targetPoint) != 'L'){
                    targetPoint ++;
                }

            }

            return true;
        }


        public String getCureLitter(String str){
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++){
                if (Objects.equals(str.charAt(i),'L') || Objects.equals(str.charAt(i),'R')){
                    resultBuilder.append(str.charAt(i));
                }
            }
            return resultBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * //给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
     //
     //
     // 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位
     //时才能向 右 移动。
     // 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
     //
     //
     // 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
     //
     //
     //
     // 示例 1：
     //
     // 输入：start = "_L__R__R_", target = "L______RR"
     //输出：true
     //解释：可以从字符串 start 获得 target ，需要进行下面的移动：
     //- 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
     //- 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
     //- 将第二个片段向右移动散步，字符串现在变为 "L______RR" 。
     //可以从字符串 start 得到 target ，所以返回 true 。
     //
     //
     // 示例 2：
     //
     // 输入：start = "R_L_", target = "__LR"
     //输出：false
     //解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
     //但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
     //
     //
     // 示例 3：
     //
     // 输入：start = "_R", target = "R_"
     //输出：false
     //解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。
     //
     //
     //
     // 提示：
     //
     //
     // n == start.length == target.length
     // 1 <= n <= 10⁵
     // start 和 target 由字符 'L'、'R' 和 '_' 组成
     //
     //
     // 👍 31 👎 0

     */
}

