public class BinaryTree_Height {

    public static int height(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // Example Tree
        //      1
        //     / \
        //    2   3
        //   /
        //  4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println("Height of tree: " + height(root));
    }
}
