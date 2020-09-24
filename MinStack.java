class MinStack {
    private int minValue;
    Stack<Integer> st;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minValue) {
            st.push(minValue - x);
            minValue = x;
        }
        st.push(x);
    }

    public void pop() {
        int val = st.pop();
        if (val == minValue) {
            int diff = st.pop();
            minValue += diff;
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */