public class BinaryTree_Symmetric {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return (a.val == b.val)
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 4  3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Tree symmetric? " + isSymmetric(root));
    }
}
