public class BinarySearchTree {
    private TreeNode root;
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode recursiveInsert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = recursiveInsert(root.left, value);
        } else {
            root.right = recursiveInsert(root.right, value);
        }

        return root;
    }

    public TreeNode iterativeInsert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);

        TreeNode current = root;
        while (true) {
            if (value < current.value) {
                if (current.left != null) current = current.left;
                else {
                    current.left = new TreeNode(value);
                    break;
                }
            } else {
                if (current.right != null) current = current.right;
                else  {
                    current.right = new TreeNode(value);
                    break;
                }
            }
        }

        return root;
    }

    public TreeNode recursiveSearch(TreeNode root, int value) {
        if (root == null || root.value == value) return root;
        if (value < root.value) return recursiveSearch(root.left, value);
        else return recursiveSearch(root.right, value);
    }

    public TreeNode iterativeSearch(int value) {
        TreeNode current = root;
        while (current != null) {
            if (value == current.value) return current;
            else if (value < current.value) current = current.left;
            else current = current.right;
        }
        return null;
    }

}
