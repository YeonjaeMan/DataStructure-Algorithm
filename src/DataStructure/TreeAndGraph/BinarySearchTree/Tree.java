package DataStructure.TreeAndGraph.BinarySearchTree;

public class Tree {
    public Node root;

    public Node search(Node root, int key) {
        if(root == null || root.data == key) {
            return root;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        } else if(data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if(root == null) {
            return null;
        }
        if(data < root.data) {
            root.left = delete(root.left, data);
        } else if(data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public int findMin(Node root) {
        int min = root.data;
        while(root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
