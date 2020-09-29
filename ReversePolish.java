class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;
        if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        Stack<Integer> st = new Stack<>();
        int op1, op2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 + op2);
                    break;
                case "-":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 - op2);
                    break;
                case "*":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 * op2);
                    break;
                case "/":
                    op2 = st.pop();
                    op1 = st.pop();
                    st.push(op1 / op2);
                    break;
                default:
                    st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}