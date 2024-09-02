package CodingTest.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 4번 문제
/*
1. yellow의 약수 쌍을 list에 저장.
2. (yellow의 가로 + 2) * (yellow의 세로 + 2) - yellow = brown 임을 사용.
 */
public class 카펫 {
    private List<int[]> list;

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        findNum(yellow);
        for(int[] arr : list) {
            if((arr[0] + 2) * (arr[1] + 2) - yellow == brown) {
                answer[0] = arr[0] + 2;
                answer[1] = arr[1] + 2;
                break;
            }
        }
        return answer;
    }

    private void findNum(int yellow) {
        list = new ArrayList<>();
        for(int i = yellow; i >= 1; i--) {
            int j = yellow / i;
            if(i * j == yellow) {
                int[] tmp = {Math.max(i, j), Math.min(i, j)};
                list.add(tmp);
            }
        }
    }
}
