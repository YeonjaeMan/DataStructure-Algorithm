package CodingTest.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 고득점 알고리즘 Kit 그래프 Leve 3 문제
public class 가장먼노드 {
    public static int solution(int n, int[][] edge) {
        // 그래프 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 그래프 정점 양방향 연결
        for(int[] v : edge) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }
        // 방문한 노드 확인 용도
        boolean[] visited = new boolean[n + 1];
        // BFS 호출
        return bfs(graph, visited, n);
    }

    private static int bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] depth = new int[n + 1];

        q.add(1);
        visited[1] = true;
        depth[1] = 1;

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int i = 0; i < graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[v] + 1;
                    q.add(next);
                }
            }
        }

        int m = Arrays.stream(depth).max().getAsInt();
        int answer = 0;

        for(int d : depth) {
            if(d == m)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }
}
