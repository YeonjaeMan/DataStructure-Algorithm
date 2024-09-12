package CodingTest.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 고득점 알고리즘 Kit 깊이/너비 우선 탐색(BFS/DFS) 5번 문제
// ** 어려움 주의 **
public class 아이템줍기 {
    static char map[][] = new char[101][101]; // 101x101 크기의 맵을 정의 (모든 값은 초기화되어 있음)

    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        // 주어진 직사각형을 맵에 그리기
        for (int i = 0; i < rectangle.length; i++) {
            int y1 = rectangle[i][1]; // 직사각형의 왼쪽 아래 y 좌표
            int x1 = rectangle[i][0]; // 직사각형의 왼쪽 아래 x 좌표
            int y2 = rectangle[i][3]; // 직사각형의 오른쪽 위 y 좌표
            int x2 = rectangle[i][2]; // 직사각형의 오른쪽 위 x 좌표
            draw(y1 * 2, x1 * 2, y2 * 2, x2 * 2); // 좌표를 두 배로 확대하여 그리기
        }

        // BFS를 통해 (Y, X)에서 (itemY, itemX)까지의 최단 거리 계산
        return bfs(Y * 2, X * 2, itemY * 2, itemX * 2);
    }

    public static int bfs(int Y, int X, int findY, int findX) {
        int yy[] = {-1, 1, 0, 0}; // 상하 이동을 위한 y 좌표 변화
        int xx[] = {0, 0, -1, 1}; // 좌우 이동을 위한 x 좌표 변화
        Queue<Integer[]> queue = new LinkedList<>(); // BFS를 위한 큐 생성
        queue.add(new Integer[]{Y, X, 0}); // 시작 좌표와 이동 횟수 0을 큐에 추가
        boolean visited[][] = new boolean[101][101]; // 방문 여부를 체크하기 위한 배열

        while (!queue.isEmpty()) {
            Integer temp[] = queue.poll(); // 큐에서 현재 위치를 가져옴
            int prevY = temp[0]; // 현재 y 좌표
            int prevX = temp[1]; // 현재 x 좌표
            int count = temp[2]; // 현재까지의 이동 횟수

            // 목적지에 도착한 경우 이동 횟수 반환 (2로 나누는 이유는 좌표가 두 배로 확대되었기 때문)
            if (prevY == findY && prevX == findX)
                return count / 2;

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nextY = prevY + yy[i]; // 다음 y 좌표
                int nextX = prevX + xx[i]; // 다음 x 좌표

                // 맵의 경계를 넘어가는지 체크
                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length)
                    continue; // 경계를 넘어가면 무시

                // 이미 방문한 곳이거나 테두리가 아닌 곳은 무시
                if (visited[nextY][nextX] == true || map[nextY][nextX] != '2')
                    continue;

                visited[nextY][nextX] = true; // 현재 위치 방문 처리
                queue.add(new Integer[]{nextY, nextX, count + 1}); // 다음 위치와 이동 횟수 큐에 추가
            }
        }

        return 0; // 목적지에 도달할 수 없는 경우 0 반환
    }

    public static void draw(int y1, int x1, int y2, int x2) {
        // 주어진 좌표 범위에 직사각형 그리기
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                // 이미 그려진 곳이면 무시
                if (map[i][j] == '1') continue;
                map[i][j] = '1'; // 직사각형 내부를 '1'로 표시

                // 테두리 부분은 '2'로 표시
                if (i == y1 || i == y2 || j == x1 || j == x2)
                    map[i][j] = '2';
            }
        }
    }
}
