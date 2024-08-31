package CodingTest.ExhaustiveSearch;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 1번 문제
// 1. sizes[i] 정렬
// 2. sizes[i][0] 중 가장 큰 값, sizes[i][1] 중 가장 큰 값 구하기
public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int w_max = Integer.MIN_VALUE;
        int h_max = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        for(int[] rec : sizes) {
            if(rec[0] > w_max)
                w_max = rec[0];
            if(rec[1] > h_max)
                h_max = rec[1];
        }
        return w_max * h_max;
    }
}
