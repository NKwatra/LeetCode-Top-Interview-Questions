class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                char top;
                if (!st.isEmpty())
                    top = st.pop();
                else
                    return false;

                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '['))
                    return false;

            }
        }

        return st.isEmpty();

    }
}