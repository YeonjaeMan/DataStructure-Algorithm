package DataStructure.TreeAndGraphs.GetIthNode;

import java.util.Random;

public class Tree {
    public Node root;

    public int size() {
        return root == null ? 0 : root.size();
    }

    public void insert(int data) {
        if(root == null)
            root = new Node(data);
        else
            root.insert(data);
    }

    public Node getRandomNode() {
        if(root == null)
            return null;
        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }
}
