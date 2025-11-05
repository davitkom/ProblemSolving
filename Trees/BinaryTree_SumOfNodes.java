public class BinaryTree_SumOfNodes {

    public static int sum(TreeNode root) {
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    public static void main(String[] args) {
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Sum of all nodes: " + sum(root));
    }
}
