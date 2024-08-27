package CodingTest.Heap;

import java.util.PriorityQueue;

// 프로그래머스 고득점 알고리즘 Kit 힙 1번 문제
// 1. 우선순위 큐에 스코빌 지수를 넣는다.
// 2. 섞은 음식의 스코빌 지수를 계산한다.
// 3. 우선순위 큐의 가장 앞단의 수와 K를 비교한다.
// ex. 1-2-3-9-10-12에서 1+(2*2) 계산 -> K=7과 비교 -> 우선순위 큐에 삽입
//     -> 3-5-9-10-12에서 3+(5*2) 계산 -> K=7과 비교 -> 끝
public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }
        while(heap.peek() < K) {
            if(heap.size() <= 1)  {
                return -1;
            }
            heap.add(heap.poll() + heap.poll() * 2);
            answer++;
        }
        return answer;
    }
}
