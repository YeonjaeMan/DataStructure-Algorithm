package CodingTest.ExhaustiveSearch;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 5번 문제
/*
1. boolean 타입 visited 배열을 사용해서 방문했는지 체크.
2. 재귀 메소드 dfs를 사용해서 모든 경우의 수 탐색.
3. 탐색하면서 answer와 depth를 비교해서 큰 값 저장.
 */
public class 피로도 {
    private boolean[] visited;
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    private void dfs(int depth, int k, int[][] dg) {
        for(int i = 0; i < dg.length; i++) {
            if(visited[i] || dg[i][0] > k)
                continue;
            visited[i] = true;
            dfs(depth + 1, k - dg[i][1], dg);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}
