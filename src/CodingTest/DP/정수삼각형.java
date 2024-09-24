package CodingTest.DP;

// 프로그래머스 고득점 알고리즘 Kit 동적계획법(Dynamic Programming) Level 3 문제
/*
1. 삼각형 위에서부터 더한 값을 갱신한다.
2. 삼각형 마지막 깊이에서 최댓값을 구한다.
 */
public class 정수삼각형 {
    public static int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0]; // 삼각형 다음 층의 시작은 이전 층의 첫번째 요소를 더해준다.
            triangle[i][triangle[i].length - 1] += triangle[i - 1][triangle[i - 1].length - 1]; // 삼각형 다음 층의 끝은 이전 층의 마지막 요소를 더해준다.
            // 처음과 마지막을 제외하고 반복해준다.
            for(int j = 1; j < triangle[i].length - 1; j++) {
                // 최댓값을 구하는 것이기 때문에 j-1번째와 j번째 중 큰 수를 더해준다.
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        // 삼각형의 마지막 줄에서 최댓값을 구한다.
        for(int i = 0; i < triangle.length; i++) {
            if(answer < triangle[triangle.length - 1][i])
                answer = triangle[triangle.length - 1][i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(solution(triangle));
    }
}
