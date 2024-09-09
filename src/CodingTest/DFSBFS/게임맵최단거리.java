package CodingTest.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 고득점 알고리즘 Kit DFS/BFS 3번 문제
public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 상하좌우 이동을 위한 배열
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // 방문 배열
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 추가
        queue.offer(new int[]{0, 0, 1}); // x, y, 거리
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 도착 지점에 도달한 경우
            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            // 상하좌우로 이동
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // 경계 검사 및 방문 여부 확인
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && maps[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, distance + 1});
                }
            }
        }

        // 도착할 수 없는 경우
        return -1;
    }
}
