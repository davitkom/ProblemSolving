public class BinaryTree_SearchValue {

    public static boolean search(TreeNode root, int val) {
        if(root == null) return false;
        if(root.val == val) return true;
        return search(root.left, val) || search(root.right, val);
    }

    public static void main(String[] args) {
        //      5
        //     / \
        //    3   8
        //   / \
        //  1   4
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        int target = 4;
        System.out.println("Searching for " + target + ": " + search(root, target));
    }
}
