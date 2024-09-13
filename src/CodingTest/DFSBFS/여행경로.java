package CodingTest.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 프로그래머스 고득점 알고리즘 Kit 깊이/너비 우선 탐색(DFS/BFS) 6번 문제
public class 여행경로 {
    private boolean[] visited;
    private List<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        // 1. 변수 세팅
        visited = new boolean[tickets.length];
        // 2. 완전탐색 및 정렬
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);
        // 3. 정답 출력
        String[] answer = result.get(0).split(" ");
        return answer;
    }

    private void dfs(int index, String start, String route, String[][] tickets) {
        // 1. 탈출 조건 (비행기 티켓을 모두 사용한 경우)
        if(index == tickets.length) {
            result.add(route);
            return;
        }
        // 2. 백트래킹 알고리즘 사용
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(index + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
