class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // sort(intervals,0,intervals.length-1);
        int[] current_interval = intervals[0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (current_interval[1] >= intervals[i][0]) {
                current_interval[1] = Math.max(current_interval[1], intervals[i][1]);
            } else {
                result.add(Arrays.copyOf(current_interval, current_interval.length));
                current_interval = intervals[i];

            }

        }
        result.add(current_interval);
        return result.toArray(new int[result.size()][]);
    }

    // public void sort(int[][] arrays, int start, int end) {
    // if(start> end) return;
    // int left = start;
    // int right = end;
    // int[] base = Arrays.copyOf(arrays[right],2);
    // while(left < right) {
    // while(left < right && arrays[left][0] <= base[0]) {
    // left++;
    // }
    // arrays[right] = Arrays.copyOf(arrays[left],2);
    // while(left < right && arrays[right][0] >= base[0]) {
    // right--;
    // }
    // arrays[left] = Arrays.copyOf(arrays[right],2);
    // }
    // arrays[left] = Arrays.copyOf(base,2);
    // sort(arrays, start, left - 1);
    // sort(arrays, left + 1, end);
    // }
}