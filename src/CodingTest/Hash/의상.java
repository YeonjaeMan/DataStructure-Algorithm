package CodingTest.Hash;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 고득점 알고리즘 Kit 해시 4번
/*
Key | Value
얼굴 | 동그란 안경, 검정 선글라스, (없음)
상의 | 파란색 티셔츠, (없음)
하의 | 청바지, (없음)
겉옷 | 긴 코트, (없음)

1. key - value 각쌍에 (없음)을 추가하여 안입었을 때의 경우를 임의로 추가하기
2. {(없음), (없음), (없음), (없음)}이라면 아무 옷도 입지 않은 것이기 때문에 -1을 해줌
3. 따라서, 3C1 x 2C1 x 2C1 x 2C1 - 1 = 23(가지)의 경우의 수가 나옴
 */
public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }
}
