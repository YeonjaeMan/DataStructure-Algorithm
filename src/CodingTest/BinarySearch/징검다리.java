package CodingTest.BinarySearch;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 이분탐색(Binary Search) Level 4 문제
/*
1. rocks 배열 오름차순 정렬한다.
2. 임의의 mid 값을 이용해서 바위간 거리를 구해가면서 n개의 바위를 제거해 나간다.
3. 그 중 최솟값의 최댓값을 구한다.
* 참고 : https://hy-ung.tistory.com/49
 */
public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = distance;

        Arrays.sort(rocks);

        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for(int rock : rocks) {
                if(rock - prev < mid) {
                    cnt++;
                } else {
                    prev = rock;
                }

                if(cnt > n) break;
            }

            if(distance - prev < mid && cnt <= n) {
                cnt++;
            }

            if(cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}
