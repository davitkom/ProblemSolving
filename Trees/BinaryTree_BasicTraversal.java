import java.util.*;

public class BinaryTree_BasicTraversal {

    // Inorder Traversal (Left, Root, Right)
    public static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Preorder Traversal (Root, Left, Right)
    public static void preorder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal (Left, Right, Root)
    public static void postorder(TreeNode root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // Example Tree
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

        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println("\nPreorder Traversal:");
        preorder(root);
        System.out.println("\nPostorder Traversal:");
        postorder(root);
    }
}
