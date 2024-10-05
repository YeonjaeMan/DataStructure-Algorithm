package CodingTest.BinarySearch;

import java.util.Arrays;

// 프로그래머스 PCCP 기출문제 2번 Level 2 문제
public class 퍼즐게임챌린지 {
    public static int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = diffs[0]; // diffs의 최솟값은 항상 1
        int right = Arrays.stream(diffs).max().getAsInt(); // diffs의 최댓값

        // left와 right가 만날 때까지 while문 반복
        while(left <= right) {
            int level = (left + right) / 2; // limit에 만족하는 최솟값을 찾는 문제이므로 이진탐색 사용
            long total = times[0]; // diffs[0]은 항상 level보다 같거나 작으므로 times[0]으로 초기화

            // 시간 계산
            for(int i = 1; i < diffs.length; i++) {
                if(level >= diffs[i])
                    total += times[i];
                else
                    total += (long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            }

            if(total <= limit) { // 조건 만족 시
                answer = level; // answer에 담고,
                right = level - 1; // right를 옮김
            } else { // 불만족 시
                left = level + 1; // left를 옮김
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        long limit = 3456789012L;
        System.out.println(solution(diffs, times, limit));
    }
}
