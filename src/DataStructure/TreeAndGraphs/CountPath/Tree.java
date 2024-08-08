package DataStructure.TreeAndGraphs.CountPath;

import java.util.ArrayList;
import java.util.HashMap;

// 주어진 이진트리가 있다.
// 이 트리의 노드에는 정수값이 저장되어 있다. (음의 정수 포함)
// 연결된 노드의 합산이 특정 숫자가 되는 경로의 개수를 찾으시오.
// 경로의 시작과 끝점은 어디든 될 수 있지만 언제나 위에서 아래로만 합산이 되어야 한다.
public class Tree {
    public Node root;

    public Tree(int size) {
        this.root = makeBST(0, size - 1);
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

    // 방법 1.
    public int countPathsWithSum1(int targetSum) {
        return countPathsWithSum1(root, targetSum);
    }

    public int countPathsWithSum1(Node root, int targetSum) {
        if(root == null)
            return 0;
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        int pathsOnLeft = countPathsWithSum1(root.left, targetSum);
        int pathsOnRight = countPathsWithSum1(root.right, targetSum);
        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    public int countPathsWithSumFromNode(Node node, int targetSum, int currSum) {
        if(node == null)
            return 0;
        currSum += node.data;
        int totalPaths = 0;
        if(currSum == targetSum) {
            totalPaths++;
        }
        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currSum);
        return totalPaths;
    }

    // 방법 2.
    public int countPathsWithSum2(int targetSum) {
        ArrayList<Integer> array = new ArrayList<>();
        return countPathsWithSum2(root, targetSum, array);
    }

    public int countPathsWithSum2(Node root, int targetSum, ArrayList<Integer> array) {
        if(root == null) {
            return 0;
        }
        int totalPaths = 0;
        addValue(array, root.data);
        totalPaths = countPaths(array, targetSum);
        totalPaths += countPathsWithSum2(root.left, targetSum, array);
        totalPaths += countPathsWithSum2(root.right, targetSum, array);
        removeLast(array);
        return totalPaths;
    }

    public void addValue(ArrayList<Integer> array, int value) {
        for(int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) + value);
        }
        array.add(value);
    }

    public void removeLast(ArrayList<Integer> array) {
        int value = array.remove(array.size() - 1);
        for(int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) - value);
        }
    }

    public int countPaths(ArrayList<Integer> array, int targetSum) {
        int totalPaths = 0;
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) == targetSum) {
                totalPaths++;
            }
        }
        return totalPaths;
    }

    // 방법 3.
    public int countPathsWithSum3(int targetSum) {
        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        hashTable.put(0, 1);
        return countPathsWithSum3(root, targetSum, 0, hashTable);
    }

    public int countPathsWithSum3(Node node, int targetSum, int currSum, HashMap<Integer, Integer> hashTable) {
        if(node == null) {
            return 0;
        }
        currSum += node.data;
        int sum = currSum - targetSum;
        int totalPaths = hashTable.getOrDefault(sum, 0);
        incrementHashTable(hashTable, currSum, 1);
        totalPaths += countPathsWithSum3(node.left, targetSum, currSum, hashTable);
        totalPaths += countPathsWithSum3(node.right, targetSum, currSum, hashTable);
        incrementHashTable(hashTable, currSum, -1);
        return totalPaths;
    }

    public void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int val) {
        int newCount = hashTable.getOrDefault(key, 0) + val;
        if(newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
