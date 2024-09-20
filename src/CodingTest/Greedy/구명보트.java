package CodingTest.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 고득점 알고리즘 Kit 탐욕법(Greedy) 4번 문제
/*
1. 최대 2명의 인원이 보트를 탈 수 있기 때문에 두개의 포인터 변수를 사용한다.
2. (가장 가벼운 사람 + 가장 무거운 사람)을 짝짓기 위해 정렬을 사용한다.
 */
public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        List<Integer> list = new ArrayList<>();
        for (int p : people) {
            list.add(p);
        }

        int left = 0; // 시작 인덱스
        int right = list.size() - 1; // 끝 인덱스

        while (left <= right) {
            // 가장 무거운 사람과 가장 가벼운 사람을 짝짓기
            if (list.get(left) + list.get(right) <= limit) {
                // 둘을 함께 보낼 수 있음
                left++;
            }
            // 무거운 사람만 보냄
            right--;
            answer++;
        }

        return answer;
    }
}
