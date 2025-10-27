class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 1.入
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }
            d.offerLast(i);
            // 2.出
            if (i - d.peekFirst() >= k) {
                d.pollFirst();
            }
            // 3.更新
            if (i >= k - 1)
                ans.add(nums[d.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}