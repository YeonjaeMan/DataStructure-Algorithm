package DataStructure.TreeAndGraphs.BalanceCheckTree;

// 주어진 이진트리의 Balance가 맞는지 확인하는 함수를 구현하시오.
// (여기서 Balance가 맞다는 의미는 어떤 노드의 양쪽 서브트리의 길이가 1이상 차이가 나지 않는 것을 뜻함.)
public class BalanceCheckTree {
    public Node root;

    public BalanceCheckTree(int size) {
        root = makeBST(0, size - 1);
    }

    public Node makeBST(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

    public boolean isBalanced(Node root) {
        if(root == null)
            return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int getHeight(Node root) {
        if(root == null)
            return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public int checkHeight(Node root) {
        if(root == null)
            return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalanced2(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public boolean isBalanced3(Node root) {
        Level obj = new Level();
        checkBalanced(root, obj, 0);
        if(Math.abs(obj.min - obj.max) > 1)
            return false;
        else
            return true;
    }

    public void checkBalanced(Node node, Level obj, int level) {
        if(node == null) {
            if(level < obj.min)
                obj.min = level;
            else if(level > obj.max)
                obj.max = level;
            return;
        }
        checkBalanced(node.left, obj, level + 1);
        checkBalanced(node.right, obj, level + 1);
    }
}
