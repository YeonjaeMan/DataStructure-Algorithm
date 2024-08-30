package CodingTest.Heap;

import java.util.PriorityQueue;

// 프로그래머스 알고리즘 고득점 Kit 힙 3번
public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++) {
            String[] strs = operations[i].split(" ");
            if(strs[0].equals("I")) {
                minQueue.offer(Integer.valueOf(strs[1]));
                maxQueue.offer(Integer.valueOf(strs[1]));
            } else if(strs[0].equals("D") && strs[1].equals("1") && !maxQueue.isEmpty()) {
                minQueue.remove(maxQueue.poll());
            } else if(strs[0].equals("D") && strs[1].equals("-1") && !minQueue.isEmpty()) {
                maxQueue.remove(minQueue.poll());
            }
        }

        int min = minQueue.isEmpty() ? 0 : minQueue.poll(),
                max = maxQueue.isEmpty() ? 0 : maxQueue.poll();

        return new int[]{max, min} ;
    }
}
