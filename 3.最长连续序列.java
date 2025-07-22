class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        int currentLen;
        // 转为set集合
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<Integer> numsSet = new HashSet<>(Arrays.asList(boxedNums));
        for (Integer num : numsSet) {
            // num是当前序列的起点，num-1不存在
            if (!numsSet.contains(num - 1)) {
                currentLen = getCurrentLength(num, numsSet);
                maxLen = getMax(currentLen, maxLen);
            }
            // 不是当前序列的起点，num-1存在
            // else{
            // int start = getStart(num,numsSet);
            // currentLen = getCurrentLength(start,numsSet);
            // maxLen = getMax(currentLen,maxLen);
            // }
        }
        return maxLen;
    }

    public int getCurrentLength(int num, Set<Integer> set) {
        int length = 0;
        do {
            length += 1;
            num += 1;
        } while (set.contains(num));
        return length;
    }

    public int getStart(int num, Set<Integer> set) {
        do {
            num -= 1;
        } while (set.contains(num));
        return num + 1;
    }

    public int getMax(int a, int b) {
        return a > b ? a : b;
    }
}
/**
 * else分支的代码是多余的，因为在主循环中已经处理了所有可能的情况。
 * 只需要处理num是当前序列的起点的情况即可。加上反而会超时
 */