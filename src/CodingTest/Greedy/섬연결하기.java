package CodingTest.Greedy;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 탐욕법(Greedy) Level 3 문제
/*
1. costs를 오름차순으로 정렬한다.
2. Union-Find 알고리즘을 사용하여 각 노드의 부모를 find하고, union하면서 최소 비용을 계산한다.
 */
public class 섬연결하기 {
    private int[] parent;

    // 노드의 부모를 찾는 메소드
    private int find(int node) {
        // 노드의 부모가 자신이면 자신을 반환
        if(parent[node] == node)
            return node;
        // 아니면 재귀호출을 사용해 자신을 반환할 때까지 부모의.. 부모의.. 노드를 찾아서 반환
        else
            return parent[node] = find(parent[node]);
    }

    // 두개의 노드를 연결하는 메소드
    private void union(int node1, int node2) {
        node1 = find(node1); // node1의 부모를 찾기
        node2 = find(node2); // node2의 부모를 찾기
        // node1과 node2의 부모가 다르면
        if(node1 != node2) {
            // node2의 부모에 node1을 넣어 연결
            parent[node2] = node1;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n]; // n개의 노드의 부모를 저장할 공간
        for(int i = 0; i < n; i++) {
            parent[i] = i; // 자기자신이 부모가 되도록 초기화
        }
        // costs[i][2] 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        for(int[] cost : costs) {
            // cost[0]과 cost[1]의 부모가 같지 않다면 연결되어 있지 않다는 뜻이므로
            if(find(parent[cost[0]]) != find(parent[cost[1]])) {
                // cost[0]과 cost[1]을 연결해준다.
                union(cost[0], cost[1]);
                // costs 배열이 cost[2]를 기준으로 오름차순 정렬되어 있으므로 최소값이 answer에 더해진다.
                answer += cost[2];
            }
        }
        return answer;
    }
}
