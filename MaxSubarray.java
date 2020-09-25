// Divide and Conquer O(nlogn)
class Solution {
    public int maxSubArray(int[] nums) {
        return findMaxSubArray(nums, 0, nums.length - 1);
    }

    int findMaxSubArray(int[] nums, int beg, int end) {
        if (end == beg)
            return nums[beg];

        int mid = beg + (end - beg) / 2;
        int leftMax = findMaxSubArray(nums, beg, mid);
        int rightMax = findMaxSubArray(nums, mid + 1, end);
        long sum = (long) nums[mid] + nums[mid + 1], maxSum = sum;
        int i = mid - 1, j = mid + 2;
        while (i >= beg) {
            sum += nums[i];

            if (sum > maxSum)
                maxSum = sum;
            i--;
        }

        sum = maxSum;

        while (j <= end) {
            sum += nums[j];

            if (sum > maxSum)
                maxSum = sum;
            j++;
        }

        return (int) Math.max(leftMax, Math.max(rightMax, maxSum));
    }
}

// Kadane algo O(n)
class Solution {
    public int maxSubArray(int[] nums) {

        if (nums.length == 1)
            return nums[0];
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum += num;

            if (currSum > maxSum)
                maxSum = currSum;

            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
}