public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0)
            return 0;
        int ans = 0, mask;
        for (int i = 0; i < 32; i++) {
            mask = n & (1 << i);
            ans = ans << 1;
            if (mask != 0)
                ans += 1;
        }

        return ans;
    }
}