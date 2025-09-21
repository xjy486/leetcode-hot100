class MinStack {

    private Deque<Integer> data_stack;
    private Deque<Integer> min_stack;

    public MinStack() {
        data_stack = new ArrayDeque<>();
        min_stack = new ArrayDeque<>();
    }

    public void push(int val) {
        data_stack.push(val);

        if (min_stack.isEmpty() || min_stack.peek() > val) {
            min_stack.push(val);
        } else {
            min_stack.push(min_stack.peek());
        }
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */