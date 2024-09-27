package CodingTest.DP;

// 프로그래머스 고득점 알고리즘 Kit 동적계획법(Dynamic Programming) Level 4 문제
/*
1. 첫번째 집을 방문한 경우 >> dpO, 방문하지 않은 경우 >> dpX 로 나눈다.
2. 점화식을 사용해 dp를 채운다.
3. 첫번째 집을 방문한 경우와 첫번째 집을 방문하지 않은 경우 두 개를 비교해서 최댓값을 구한다.
 */
public class 도둑질 {
    public static int solution(int[] money) {
        int[] dpO = new int[money.length];
        int[] dpX = new int[money.length];

        dpO[0] = money[0]; // 첫번째 집 방문 O
        dpO[1] = money[0]; // 두번째 집 방문 X

        dpX[0] = 0; // 첫번째 집 방문 X
        dpX[1] = money[1]; // 두번째 집 방문 O

        for(int i = 2; i < money.length; i++) {
            dpO[i] = Math.max(money[i] + dpO[i - 2], dpO[i - 1]); // 첫번째 집을 방문한 경우, 현재 집과 이전 집을 비교
            dpX[i] = Math.max(money[i] + dpX[i - 2], dpX[i - 1]); // 첫번째 집을 방문하지 않은 경우, 현재 집과 이전 집을 비교
        }

        // 첫번째 집을 방문한 경우 마지막 집을 방문하지 않기 때문에 money.length - 2
        // 첫번째 집을 방문하지 않은 경우 마지막 집을 방문할 수 있기 때문에 money.lengh - 1
        return Math.max(dpO[money.length - 2], dpX[money.length - 1]);
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        System.out.println(solution(money));
    }
}
