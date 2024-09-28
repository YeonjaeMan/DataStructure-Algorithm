package CodingTest.BinarySearch;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 이분탐색 Level 3 문제
/*
1. times 배열 오름차순 정렬을 통해 모든 사람을 심사하는 데 가장 오래 걸리는 시간을 구한다.
2. 임의로 left와 right의 중간값인 시간(mid)을 구하고 해당 시간에 심사할 수 있는 사람이 몇 명인지를 구한다.
3. left와 right를 조절하며 모든 사람(n)이 심사를 받을 수 있는 최소 시간을 구한다.
 */
public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times); // times 배열 오름차순 정렬
        // 이분탐색을 위한 처음과 끝 지점
        long left = 0; // 0 부터
        long right = times[times.length - 1] * (long)n; // (심사하는 데 가장 오래 걸리는 시간) * (사람 수) 까지
        while(left <= right) {
            // left와 right의 중간 값으로 몇 명이 입국심사를 받을 수 있는지 계산하기 위함.
            long mid = (left + right) / 2;
            long sum = 0;
            for(int time : times) {
                // ex. mid = 10, times = {2, 3, 4} 이면
                // 10/2 + 10/3 + 10/4 = 5 + 3 + 2 = 10 명이 심사를 받을 수 있다.
                sum += mid / time;
            }
            if(sum < n) {
                // 시간(mid)으로 심사할 수 있는 사람의 수(sum)가 사람수(n)보다 작으면
                left = mid + 1; // left를 mid + 1로 조절한다.
            } else {
                // 시간(mid)으로 심사할 수 있는 사람의 수(sum)가 사람수(n)보다 크면
                right = mid - 1; // right를 mid - 1로 조절한다.
                answer = mid; // 이 때의 mid가 최소 시간일 수 있으므로 answer에 저장한다.
            }
        }
        return answer;
    }
}
