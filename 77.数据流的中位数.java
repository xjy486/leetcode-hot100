class MedianFinder {
    public PriorityQueue<Integer> minHeap;
    public PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 大根堆存左半边元素，小根堆存右半边元素，并且大根堆的元素数量-小根堆元素数量始终大于等于1
        // 1.新来的元素全部加入大根堆，然后大根堆堆顶元素弹入小根堆
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() - maxHeap.size() > 0) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int count = minHeap.size() + maxHeap.size();
        if (count % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek() * 1.0;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */