class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int lastIndex = 0, num = nums[0], i = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == num)
                i++;
            if (i == nums.length)
                break;
            nums[++lastIndex] = nums[i];
            num = nums[i];
        }

        return lastIndex + 1;
    }
}