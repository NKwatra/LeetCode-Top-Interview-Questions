/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return convertToBST(nums, 0, nums.length - 1);
    }

    public TreeNode convertToBST(int[] nums, int beg, int end) {
        if (beg == end)
            return new TreeNode(nums[beg]);
        else if (beg > end)
            return null;
        else {
            int mid = beg + (end - beg) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = convertToBST(nums, beg, mid - 1);
            root.right = convertToBST(nums, mid + 1, end);
            return root;
        }

    }
}