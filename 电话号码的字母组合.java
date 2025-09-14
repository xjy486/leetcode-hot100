import java.util.ArrayList;
import java.util.List;

class Solution {

    // 使用数组映射，更高效简洁
    private static final String[] MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // 传入 StringBuilder 进行路径构建
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    /**
     * 回溯函数
     * 
     * @param digits             输入的数字字符串
     * @param index              当前处理的数字在 digits 中的索引
     * @param currentCombination 当前已经构建的字母组合
     * @param result             最终结果列表
     */
    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result) {
        // 1. 递归终止条件：当组合的长度等于数字的长度时，表示找到了一个完整的组合
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // 2. 获取当前数字对应的字母
        char digit = digits.charAt(index);
        String letters = MAPPING[digit - '0']; // 通过 ASCII 码计算索引

        // 3. 遍历这些字母，并进行递归
        for (char letter : letters.toCharArray()) {
            // 做选择
            currentCombination.append(letter);

            // 进入下一层决策树
            backtrack(digits, index + 1, currentCombination, result);

            // 撤销选择（回溯）
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}