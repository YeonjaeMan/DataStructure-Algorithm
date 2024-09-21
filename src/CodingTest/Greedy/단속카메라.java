package CodingTest.Greedy;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 탐욕법(Greedy) Level 3 문제
/*
1. 경로의 끝 지점을 기준으로 오름차순 정렬
2. 경로의 끝 지점을 업데이트해주면서 단속카메라 설치
 */
public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        int checked = Integer.MIN_VALUE; // 경로의 끝 지점을 기억할 변수 선언
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]); // 경로의 끝 지점을 기준으로 오름차순
        for(int[] route : routes) {
            if(checked >= route[0] && checked <= route[1])
                continue; // 이전 경로의 끝 지점이 현재 경로에 포함이 될 경우 넘어감
            else {
                answer++; // 카메라 설치
                checked = route[1]; // 경로의 끝 지점 업데이트
            }
        }
        return answer;
    }
}
