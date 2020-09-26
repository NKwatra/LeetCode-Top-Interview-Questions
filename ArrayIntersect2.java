class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums1)
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (mp.containsKey(num)) {
                intersection.add(num);
                mp.put(num, mp.get(num) - 1);
                if (mp.get(num) == 0)
                    mp.remove(num);
            }
        }

        int[] ans = new int[intersection.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = intersection.get(i);
        return ans;
    }
}