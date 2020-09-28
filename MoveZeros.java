class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1)
            return;
        int lastNonZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[++lastNonZero] = nums[i];
                if (i != lastNonZero)
                    nums[i] = 0;
            }
        }
    }
}