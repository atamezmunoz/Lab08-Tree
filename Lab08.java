import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lab08 {
    /*
     * Definition of tree node
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * Binary tree class
     */
    public static class BinaryTree {
        TreeNode root;

        // Constructors
        BinaryTree(int key) { root = new TreeNode(key); }

        BinaryTree() { root = null; }
    }

    /*
     * Prints tree in preorder traversal
     *
     * @param root -- the root of the tree 
     */
    public void printPreorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            System.out.println("NULL");
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        System.out.println(output);
    }

    /*
     * Prints tree in inorder traversal
     *
     * @param root -- the root of the tree
     */
    public void printInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        System.out.println(res);
    }

    /*
     * Prints tree in postorder traversal
     *
     * @param root -- the root of the tree
     */
    public void printPostorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) System.out.println(ans);

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // create root
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);

        Lab08 lab08 = new Lab08();
        lab08.printPreorderTraversal(tree.root); // [1, 2, 3, 4]
        lab08.printPostorderTraversal(tree.root); // [4, 2, 3, 1]
        lab08.printInorderTraversal(tree.root); // [4, 2, 1, 3]

    }
}
