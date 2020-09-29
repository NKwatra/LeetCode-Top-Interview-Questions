class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[] {-1,-1};
        if(nums.length == 1)
            return nums[0] ==  target ? new int[] {0,0} : new int[] {-1,-1};
        int[] positions = new int[2];
        positions[0] = findValue(nums,0,nums.length -1, target, true);
        positions[1] = findValue(nums,0, nums.length -1, target, false);
        return positions;
    }
    
    public int findValue(int[] nums , int beg, int end, int target, boolean first)
    {
        int position = -1, mid;
        while(beg < end)
        {
            mid = beg + (end - beg) / 2;
            if(nums[mid] == target)
            {
                position = mid;
                if(first)
                    end = mid -1;
                else
                    beg = mid + 1;
            }
            else if(nums[mid]< target)
            {
                beg = mid + 1;
            }else
            {
                end = mid -1;
            }
        }
        
        return nums[beg] == target ? beg : position;
    }
}