package CodingTest.Greedy;

// 프로그래머스 고득점 알고리즘 Kit 탐욕법(Greedy) 3번 문제
public class 큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int start = 0;
        int end = k;

        // answer의 길이가 number.length() - k가 될 때까지 반복
        while (answer.length() != number.length() - k) {
            char max = Character.MIN_VALUE; // 초기값을 가장 작은 문자로 설정
            int maxIdx = start;

            // 현재 범위에서 최대값 찾기
            for (int i = start; i <= end; i++) {
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    maxIdx = i;
                }
            }

            answer.append(max); // 최대값 추가
            start = maxIdx + 1; // 최대값 다음 인덱스부터 시작
            end = end + 1; // answer의 길이에 따라 남은 자리 수 조정
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}
