package CodingTest.Sort;

import java.util.Arrays;

// 프로그래머스 고득점 알고리즘 Kit 정렬 3번
/*
1. 배열 오름차순 정렬 / citations = [0, 1, 3, 5, 6]
2. citations[i]번 이상 인용된 논문이 (citations.length - 1)편 이상
   0번 이상 인용된 논문이 5편 이상
   1번 이상 인용된 논문이 4편 이상
   3번 이상 인용된 논문이 3편 이상
3. return (citations.length - 1)
 */
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
