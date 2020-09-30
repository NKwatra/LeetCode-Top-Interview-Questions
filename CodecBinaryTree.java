/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val);
        sb.append(",");
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                sb.append(curr.left.val);
                q.add(curr.left);
            } else {
                sb.append(1001);
            }
            sb.append(",");
            if (curr.right != null) {
                sb.append(curr.right.val);
                q.add(curr.right);
            } else {
                sb.append(1001);
            }
            sb.append(",");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] segments = data.split(",");
        int val = Integer.parseInt(segments[0]);
        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        int i = 1;
        q.add(root);

        while (i < segments.length) {
            TreeNode curr = q.poll();
            int left = Integer.parseInt(segments[i++]);
            if (left == 1001)
                curr.left = null;
            else {
                curr.left = new TreeNode(left);
                q.add(curr.left);
            }
            int right = Integer.parseInt(segments[i++]);
            if (right == 1001)
                curr.right = null;
            else {
                curr.right = new TreeNode(right);
                q.add(curr.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));