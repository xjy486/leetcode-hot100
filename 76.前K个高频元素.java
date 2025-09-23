class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 按频率升序排序的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(key);
            } else {
                int currMin = minHeap.peek();
                if (map.get(currMin) < map.get(key)) {
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }
        }

        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}