package CodingTest.Sort;

import java.util.Arrays;

// 프로그래머스 알고리즘 고득점 Kit 정렬 2번
/*
1. int 배열 -> String 배열로 저장
2. String 배열 내림차순 정렬 (ex. 6, 10 두 문자열일 때 610 > 106)
 */
public class 가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if(arr[0].equals("0"))
            return "0";
        for(int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }
        return answer.toString();
    }
}
