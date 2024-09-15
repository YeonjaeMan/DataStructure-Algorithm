package CodingTest.Greedy;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 탐욕법(Greedy) 1번 문제
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // (전체 학생 수) - (체육복 없는 학생 수)로 시작
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] == lost[i]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
