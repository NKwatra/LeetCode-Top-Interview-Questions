// Iterative Solution 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[] { root.left, root.right });
        return checkSymmetric(st);
    }

    public boolean checkSymmetric(Stack<TreeNode[]> st) {
        while (!st.isEmpty()) {
            TreeNode[] top = st.pop();
            TreeNode leftChild = top[0];
            TreeNode rightChild = top[1];

            if ((leftChild == null && rightChild != null) || (leftChild != null && rightChild == null))
                return false;

            if (leftChild != null && rightChild != null) {
                if (leftChild.val != rightChild.val)
                    return false;
                st.push(new TreeNode[] { leftChild.left, rightChild.right });
                st.push(new TreeNode[] { leftChild.right, rightChild.left });
            }

        }

        return true;
    }

}

// Recursive Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return left.val == right.val && checkSymmetric(left.left, right.right)
                && checkSymmetric(left.right, right.left);
    }
}