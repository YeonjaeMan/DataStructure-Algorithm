package CodingTest.DFSBFS;

// 프로그래머스 고득점 알고리즘 Kit 깊이/너비 우선 탐색(DFS/BFS) 2번 문제
public class 네트워크 {
    public int solution(int n, int[][] computers) {
        // 네트워크의 개수
        int answer = 0;
        // 방문한 computer 확인을 위해 boolean 타입의 배열 생성
        boolean[] visited = new boolean[computers.length];
        // computers 배열의 길이만큼 반복하면서
        for(int i = 0; i < computers.length; i++) {
            // visited[i]가 false이면
            if(!visited[i]) {
                // answer 하나 증가
                answer++;
                // dfs 메소드 호출
                dfs(i, computers, visited);
            }
        }
        return answer;
    }

    // i, computers, visited를 인자로 받아 i와 연결된 컴퓨터를 찾는 메소드
    private void dfs(int i, int[][] computers, boolean[] visited) {
        // visited[i]를 true로 바꾼다.
        visited[i] = true;
        // computers 배열의 길이만큼 반복하면서
        for(int j = 0; j < computers.length; j++) {
            // visited[j]가 false이고, computers[i][j]가 1이면
            if(!visited[j] && computers[i][j] == 1) {
                // dfs 재귀 호출을 이용해서 연결된 컴퓨터를 다시 찾는다.
                dfs(j, computers, visited);
            }
        }
    }
}
