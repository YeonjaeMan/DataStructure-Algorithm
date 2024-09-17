package CodingTest.Greedy;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 탐욕법(Greedy) 1번 문제
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // (전체 학생 수) - (체육복 없는 학생 수)로 시작
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                // 여벌의 체육복을 가진 학생과 체육복을 가지고 있는 학생이 같을 경우
                if(reserve[j] == lost[i]) {
                    answer++; // 답 증가
                    lost[i] = -1; // 의미없는 수인 -1
                    reserve[j] = -1; // 의미없는 수인 -1
                    break; // 반복 종료
                }
            }
        }
        // 여벌 체육복이 있어 다른 학생에게 체육복을 빌려줄 수 있는 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                // 여벌의 체육복을 가진 학생의 이웃에 위치한 학생일 경우
                if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    answer++; // 답 증가
                    lost[i] = -1; // 의미없는 수인 -1
                    reserve[j] = -1; // 의미없는 수인 -1
                    break; // 반복 종료
                }
            }
        }
        return answer;
    }
}
