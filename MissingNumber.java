class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = 0, required = (n * (n + 1)) / 2;
        for (int num : nums)
            sum += num;
        return (int) (required - sum);
    }
}