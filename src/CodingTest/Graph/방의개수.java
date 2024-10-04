package CodingTest.Graph;

import java.util.*;

// 프로그래머스 고득점 알고리즘 Kit 그래프(Graph) Level 5 문제
/*
* 이해 필요..
 */
public class 방의개수 {
    private int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[] arrows) {
        int answer = 0;
        Map<Point, List<Point>> visited = new HashMap<>();
        Point now = new Point(0, 0);

        for(int arrow : arrows) {
            for(int i = 0; i < 2; i++) {
                Point next = new Point(now.x + dx[arrow], now.y + dy[arrow]);

                if(!visited.containsKey(next)) {
                    visited.put(next, makeDefaultList(now));

                    if(visited.get(now) == null) {
                        visited.put(now, makeDefaultList(next));
                    } else {
                        visited.get(now).add(next);
                    }
                } else if(visited.containsKey(next) && !visited.get(next).contains(now)) {
                    visited.get(next).add(now);
                    visited.get(now).add(next);
                    answer++;
                }
                now = next;
            }
        }
        return answer;
    }

    private List<Point> makeDefaultList(Point point) {
        List<Point> list = new ArrayList<>();
        list.add(point);
        return list;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashcode() {
            return Objects.hash(this.x, this.y);
        }

        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }
    }
}
