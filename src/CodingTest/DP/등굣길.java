package CodingTest.DP;

// 프로그래머스 고득점 알고리즘 Kit 동적계획법(Dynamic Programming) Level 3 문제
/*
1. dp[i][j] 경로에 도달할 수 있는 경로를 계산한다.
2. 경로 계산은 이전 경로(왼쪽, 위)에 도달할 수 있는 경로를 더한다.
3. 예를 들어, dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 이 되는 것이다.
 */
public class 등굣길 {
    public static int solution(int m, int n, int[][] puddles) {
        // 경로를 저장할 2차원 배열 생성
        int[][] dp = new int[m + 1][n + 1];
        // 효용성 검사를 위한 mod 변수
        int mod = 1_000_000_007;
        // 시작 위치에 1 초기화
        dp[1][1] = 1;
        for(int[] puddle : puddles) {
            // 물 웅덩이가 있는 위치에 -1 저장
            dp[puddle[0]][puddle[1]] = -1;
        }
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                // -1 이라면 물웅덩이가 있는 곳이므로 경로를 구할 수 없다.
                if(dp[i][j] == -1)
                    continue;
                // 위쪽 경로의 경우의 수가 0보다 크다면 현재 경로에 더해줌
                if(dp[i - 1][j] > 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                // 왼쪽 경로의 경우의 수가 0보다 크다면 현재 경로에 더해줌
                if(dp[i][j - 1] > 0)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        System.out.println(solution(4, 3, puddles));
    }
}
