class Solution {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int zeroCount = 0;
        int num = 5;
        while (num <= n) {
            zeroCount += (n / num);
            num *= 5;
        }

        return zeroCount;
    }
}