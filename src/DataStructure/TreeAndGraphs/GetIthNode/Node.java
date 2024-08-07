package DataStructure.TreeAndGraphs.GetIthNode;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public int size;

    public Node(int data) {
        this.data = data;
        this.size = 1;
    }

    public void insert(int data) {
        if(data <= this.data) {
            if(left == null) {
                left = new Node(data);
            } else {
                left.insert(data);
            }
        } else {
            if(right == null) {
                right = new Node(data);
            } else {
                right.insert(data);
            }
        }
        size++;
    }

    public int size() {return size;}

    public Node find(int data) {
        if(data == this.data) {
            return this;
        } else if(data < this.data) {
            return left != null ? left.find(data) : null;
        } else if(data > this.data) {
            return right != null ? right.find(data) : null;
        } else {
            return null;
        }
    }

    public Node getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size();
        if(i < leftSize) {
            return left.getIthNode(i);
        } else if(i == leftSize) {
            return this;
        } else {
            return right.getIthNode(i - (leftSize + 1));
        }
    }
}
