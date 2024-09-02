package CodingTest.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 4번 문제
public class 카펫 {
    private List<int[]> list;

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        findNum(yellow);
        for(int[] arr : list) {
            if((arr[0] + 2) * (arr[1] + 2) - brown == yellow) {
                answer[0] = arr[0] + 2;
                answer[1] = arr[1] + 2;
                break;
            }
        }
        return answer;
    }

    // 시간 초과..
    private void findNum(int yellow) {
        list = new ArrayList<>();
        for(int i = yellow; i >= 1; i--) {
            for(int j = 1; j <= yellow / 2 + 1; j++) {
                if(i * j == yellow) {
                    int[] tmp = {i, j};
                    list.add(tmp);
                    break;
                }
            }
        }
    }
}
