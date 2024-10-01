package CodingTest.Graph;

// 프로그래머스 고득점 알고리즘 Kit 그래프(Graph) Leve 3 문제
/*
플로이드 와샬 알고리즘 : n명의 선수가 있을 때, 각 선수는 n-1번의 승패를 알 수 있어야 순위를 확정지을 수 있다.
 */
public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for(int[] result : results) {
            graph[result[0]][result[1]] = 1; // result[0]이 result[1]에게 이김
            graph[result[1]][result[0]] = -1; // result[1]이 result[0]에게 짐
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    // 예를 들어, 1이 2를 이겼고 2가 5를 이겼다면
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1; // 1이 5에게 이김
                        graph[j][i] = -1; // 5가 1에게 짐
                    }
                    if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        // 플로이드 와샬 알고리즘을 사용해서 순위가 확정된 사람 찾는 과정
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                // graph[i][j]가 0이 아니라는 것은 승(1), 패(-1)가 있다는 것이므로 수를 세준다.
                if(graph[i][j] != 0)
                    cnt++;
            }
            // n - 1이면 플로이드 와샬에 의해 순위를 확정지을 수 있으므로 답 증가
            if(cnt == n - 1)
                answer++;
        }
        return answer;
    }
}
