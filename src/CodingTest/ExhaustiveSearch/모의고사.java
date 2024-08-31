package CodingTest.ExhaustiveSearch;

import java.util.ArrayList;

// 프로그래머스 고득점 알고리즘 Kit 완전탐색 2번 문제
/*
1. 수포자 3명이 문제를 찍는 패턴을 구함.
>> person1 : {1, 2, 3, 4, 5} 반복
>> person2 : {2, 1, 2, 3, 2, 4, 2, 5} 반복
>> person3 : {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} 반복
2. 수포자 3명이 맞힌 답의 수를 구하기 위해서 패턴의 길이가 다르기 때문에 문제의 번호를 패턴의 길이만큼 나눈 나머지 이용.
>> answers[i] == person*[i % person*.length]
3. 답을 가장 많이 맞힌 수포자 or 답을 맞힌 개수가 같으면 오름차순으로 반환해야함.
>> max에 가장 많은 정답의 개수를 저장하고, 이를 이용하여 ArrayList에 .add
 */
public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = {0, 0, 0};
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i % person1.length]) {
                count[0]++;
            }
            if(answers[i] == person2[i % person2.length]) {
                count[1]++;
            }
            if(answers[i] == person3[i % person3.length]) {
                count[2]++;
            }
        }
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        for(int i = 0; i < count.length; i++) {
            if(max == count[i])
                answerList.add(i + 1);
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
