class Solution {
    public int climbStairs(int n) {
        if (n < 3)
            return n;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 3; i <= n; i++) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        return list.get(list.size() - 1);
    }
}