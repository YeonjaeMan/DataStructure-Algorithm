package CodingTest.DFSBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 고득점 알고리즘 Kit 깊이/너비 우선 탐색(DFS/BFS) 4번 문제
public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        // words 배열에 정답인 target이 없으면 0 반환
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // Queue를 사용해서 BFS 구현
        Queue<String> queue = new LinkedList<>();
        // 방문 확인 용도
        boolean[] visited = new boolean[words.length];
        int level = 0;
        queue.offer(begin); // begin부터 시작

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                for(int j = 0; j < words.length; j++) {
                    // 방문한 적이 없으면서 current와 words[j]가 한글자 차이만 난다면
                    if(!visited[j] && canTransform(current, words[j])) {
                        // words[j]가 target인지 확인
                        if(target.equals(words[j])) {
                            return level;
                        }

                        queue.offer(words[j]); // 큐에 words[j] 넣고,
                        visited[j] = true; // 방문 표시해주기
                    }
                }
            }
        }

        return 0;
    }

    // 문자열이 한 글자만 차이나는지 확인하는 메소드 >> true or false
    private boolean canTransform(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
