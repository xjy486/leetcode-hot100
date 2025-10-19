class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(Integer x: set) {
            if(set.contains(x-1)) {
                continue;
            }
            int y = x + 1;
            while(set.contains(y)){
                y += 1;
            }
            ans = Math.max(ans,y-x);
        }
        return ans;
    }
}