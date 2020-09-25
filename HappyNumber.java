class Solution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        HashSet<Integer> st = new HashSet<>();
        st.add(n);
        while (n != 1) {
            n = transformNum(n);
            if (st.contains(n))
                return false;
            st.add(n);
        }

        return true;
    }

    public int transformNum(int n) {
        int newNum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            newNum += (digit * digit);
        }
        return newNum;
    }
}

// O(1) space solution below, COMING SOON