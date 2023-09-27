import java.util.*;

public class BinaryTree {
    private TreeNode root;
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode mot = new TreeNode(1);
        TreeNode hai = new TreeNode(2);
        TreeNode ba = new TreeNode(3);
        TreeNode bon = new TreeNode(4);
        TreeNode nam = new TreeNode(5);
        TreeNode sau = new TreeNode(6);
        TreeNode bay = new TreeNode(7);

        root = mot;
        mot.left = hai;
        mot.right = ba;
        hai.left = bon;
        hai.right = nam;
        ba.left = sau;
        ba.right = bay;
    }

    // root, sub-left, sub-right traversal (recursion)
    public void recursivePreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    // root, sub-left, sub-right traversal (loop + Stack)
    public void iterativePreOrder() {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    // sub-left, root, sub-right traversal (recursion)
    public void recursiveInOrder(TreeNode root) {
        if (root == null) return;
        recursiveInOrder(root.left);
        System.out.print(root.data + " ");
        recursiveInOrder(root.right);
    }

    // sub-left, root, sub-right traversal (loop + Stack)
    public void iterativeInOrder() {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void iterativeInOrder2() {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    // sub-left, sub-right, root traversal (recursion)
    public void recursivePostOrder(TreeNode root) {
        if (root == null) return;
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.data + " ");
    }

    // sub-left, sub-right, root traversal (loop + Stack)
    public void iterativePostOrder() {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp != null) {
                    current = temp;
                } else {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }
            }
        }
    }

    public void iterativePostOrder2() {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode temp = stack.peek().right;
            if (temp != null) {
                current = temp;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                }
            }
        }
    }

    // root, sub-left, sub-right traversal (loop + Queue)
    public void levelOrder() {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
    }

    public TreeNode invert() {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp2 = node.left;
            node.left = node.right;
            node.right = temp2;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    public int height() {
        Queue<TreeNode> queue = new LinkedList<>();
        int levelCount = 0;
        queue.offer(root);
        while (true) {
            int nodeQuantityAtLevel = queue.size();
            if (nodeQuantityAtLevel == 0) return levelCount;
            while (nodeQuantityAtLevel > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                nodeQuantityAtLevel--;
            }
            levelCount++;
        }
    }

    public List<List<Integer>> LeetCode102() {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.data);
        result.add(new ArrayList<>(rootList));
        while (!queue.isEmpty()) {
            int nodeQuantityAtLevel = queue.size();
            if (nodeQuantityAtLevel == 0) return result;
            else {
                List<Integer> tempList = new ArrayList<>();
                while (nodeQuantityAtLevel > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        tempList.add(node.left.data);
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        tempList.add(node.right.data);
                        queue.offer(node.right);
                    }
                    nodeQuantityAtLevel--;
                }
                result.add(tempList);
            }
        }
        return result;
    }

    public List<List<Integer>> LeetCode102_FIXED() {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < sizeOfQueue; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                tempList.add(queue.poll().data);
            }
            result.add(tempList);
        }
        return result;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left > result) result = left;
        if (right > result) result = right;
        return result;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.data > root.data) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
//        tree.recursivePreOrder(tree.root);
//        System.out.println();
//        tree.iterativePreOrder();
//        System.out.println();
//        tree.recursiveInOrder(tree.root);
//        System.out.println();
//        tree.iterativeInOrder2();
//        System.out.println();
//        tree.recursivePostOrder(tree.root);
//        System.out.println();
//        tree.iterativePostOrder2();
//        System.out.println();
//        tree.levelOrder();
        tree.invert();
        tree.levelOrder();
    }
}
