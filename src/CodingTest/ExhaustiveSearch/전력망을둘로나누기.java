package CodingTest.ExhaustiveSearch;

import java.util.ArrayList;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 6번 문제
/*
1. ArrayList<Integer>[] 형태로 Graph에 주어진 wires 연결.
2. 간선 하나를 끊고 dfs로 visited가 true인 정점과 false인 정점의 수를 세고 차이만큼 절댓값 구하기 반복.
3. 절댓값에서 최소값을 min 변수에 따로 저장.
 */
public class 전력망을둘로나누기 {
    private ArrayList<Integer>[] graph;
    private boolean[] visited;
    private int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            visited = new boolean[n + 1];

            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            int cnt = dfs(1);

            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return min;
    }

    private int dfs(int v) {
        visited[v] = true;
        int cnt = 1;

        for(int next : graph[v]) {
            if(!visited[next]) {
                cnt += dfs(next);
            }
        }

        return cnt;
    }
}
