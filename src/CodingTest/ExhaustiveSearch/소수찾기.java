package CodingTest.ExhaustiveSearch;

import java.util.HashSet;
import java.util.Set;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 3번 문제
/*
1. Set 자료구조를 이용해 가능한 경우의 수 중복 없이 저장
2. 에라토스테네스의 체 원리를 이용해 Set에 저장되어 있는 경우들 소수 판별
 */
public class 소수찾기 {
    private Set<Integer> set = new HashSet<>();
    private boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        dfs(numbers, "", 0);
        for(Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    private void dfs(String numbers, String s, int depth) {
        if(depth > numbers.length()) {
            return;
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
