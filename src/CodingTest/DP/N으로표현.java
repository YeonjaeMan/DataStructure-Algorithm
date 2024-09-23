package CodingTest.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 프로그래머스 고득점 알고리즘 Kit 동적계획법(Dynamic Programming) Leve 3 문제
/*
Hint. 최솟값이 8보다 크면 -1을 return 한다는 조건에서 DP를 사용하는 문제
1. 주어진 숫자 N을 몇 번 사용했는지 저장할 방 8개를 생성한다.
2. 방 8개를 돌면서 각 방에 들어갈 숫자들을 저장한다. 각 방에 들어갈 숫자는 예를 들어 5번째 방이면 (1번째 방, 4번째 방), (2번째 방, 3번째 방) .. 의 쌍으로 연산을 해준다.
3. 연산은 +, -, *, / 를 뜻한다.
4. 연산뿐 아니라 각 방에는 주어진 숫자를 반복한 수가 들어가야한다. 예를 들어 2번째 방에는 55, 3번째 방에는 555 .. 가 들어가야 한다.
5. 반복하면서 주어진 수가 포함되어 있으면 해당 방 번호를 return 한다.
 */
public class N으로표현 {
    public static int solution(int N, int number) {
        // 주어진 숫자와 수가 같다는 것은 N을 한번 사용해서 number를 만들 수 있다는 말이다.
        if(N == number)
            return 1;
        // 방 8개를 저장할 리스트 생성
        List<HashSet<Integer>> dp = new ArrayList<>();
        // 방 8개 생성
        for(int i = 0; i <= 8; i++) {
            // (HashSet 자료구조를 사용해서 중복을 최소화해준다.)
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N); // 1번방에는 주어진 숫자 N만 들어감
        for(int i = 2; i <= 8; i++) {
            // i번째 방 가져오기
            HashSet<Integer> tmp = dp.get(i);
            for(int j = 1; j < i; j++) {
                // ex. i = 5 이면 (1번째 방, 4번째 방) (2번째 방, 3번째 방) (3번째 방, 2번째 방) (4번째 방, 1번째 방) 쌍 연산을 위해 가져온다.
                HashSet<Integer> a = dp.get(j);
                HashSet<Integer> b = dp.get(i - j);
                // j번째 방과 i - j번째 방을 돌면서 연산 시행
                for(int x : a) {
                    for (int y : b) {
                        tmp.add(x + y);
                        tmp.add(x - y);
                        tmp.add(x * y);
                        if (y != 0) // 나누는 수가 0이 아닐 때만 시행
                            tmp.add(x / y);
                    }
                }
            }
            // i번째 반복한 수를 추가 ex. 2번째 방에 55를 넣는다.
            tmp.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            // number가 i번째 방에 있다면 i 리턴
            if(tmp.contains(number)) return i;
        }
        // 어느 방에도 number가 없으면 -1 리턴
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }
}
