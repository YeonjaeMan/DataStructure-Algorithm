package CodingTest.ExhaustiveSearch;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 7번 문제
/*
자리수와 자리수에 해당 문자를 이용하여 몇번째 문자열인지 계산.
 */
public class 모음사전 {
    private int[] digit_array = {781, 156, 31, 6, 1};
    private Map<Character, Integer> map;

    public 모음사전() {
        map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
    }

    public int solution(String word) {
        int answer = 0;
        for(int i = 0; i < word.length(); i++) {
            answer += calculate(i, word.charAt(i)) + 1;
        }
        return answer;
    }

    private int calculate(int digit, char letter) {
        return digit_array[digit] * map.get(letter);
    }
}
