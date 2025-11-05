public class BinaryTree_CountLeaves {

    public static int countLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        //      10
        //     /  \
        //    20   30
        //   / \
        //  40  50
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        System.out.println("Leaf count: " + countLeaves(root));
    }
}
