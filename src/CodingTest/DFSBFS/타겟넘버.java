package CodingTest.DFSBFS;

// 프로그래머스 고득점 알고리즘 Kit 깊이/너비 우선 탐색(DFS/BFS) 1번 문제
/*
1. 재귀호출 DFS 방법을 사용해서 같은 재귀호출 메소드를 두 번 호출. >> +, -
2. 배열의 끝에 도착했을 때 계산한 합과 target 비교.
 */
public class 타겟넘버 {
//    내가 푼 풀이
//    private int answer = 0;
//
//    public int solution(int[] numbers, int target) {
//        int index = 0;
//        int sum = 0;
//
//        dfs(numbers, target, index, sum);
//
//        return answer;
//    }
//
//    private void dfs(int[] numbers, int target, int index, int sum) {
//        if(index > numbers.length) {
//            return;
//        } else if(index == numbers.length) {
//            if(sum == target)
//                answer++;
//            return;
//        }
//
//        dfs(numbers, target, index + 1, sum + numbers[index]);
//        dfs(numbers, target, index + 1, sum - numbers[index]);
//    }

    // 개선한 풀이 방법
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(numbers, target, 0, 0);
        return answer;
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if(sum == target)
                return 1;
            return 0;
        }

        return dfs(numbers, target, index + 1, sum + numbers[index]) + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
