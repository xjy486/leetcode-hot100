class Solution {
    public List<List<Integer>> adj;
    public List<Integer> visited; // or int[] for slightly better performance

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize inside the method for safety
        adj = new ArrayList<>();
        visited = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
            visited.add(0);
        }

        // 1. Build the graph correctly (Your first fix)
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 2. Only check unvisited nodes (Your second fix)
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0) {
                if (hasCycleInDfs(i)) { // Renamed for clarity
                    return false;
                }
            }
        }

        return true;
    }

    // This function returns TRUE if a cycle is found
    public boolean hasCycleInDfs(int node) {
        visited.set(node, 1); // Mark as visiting

        for (Integer neighbor : adj.get(node)) {
            if (visited.get(neighbor) == 1) {
                return true; // Cycle detected!
            }
            if (visited.get(neighbor) == 0) {
                if (hasCycleInDfs(neighbor)) {
                    return true; // Propagate cycle signal
                }
            }
            // If visited.get(neighbor) == 2, do nothing.
        }

        visited.set(node, 2); // Mark as visited and safe
        return false; // No cycle found from this path
    }
}