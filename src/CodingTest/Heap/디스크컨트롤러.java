package CodingTest.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 고득점 알고리즘 Kit 힙 2번 문제
public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int jobsIdx = 0;
        int count = 0;
        int end = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while(count < jobs.length) {
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }
            if(pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}
