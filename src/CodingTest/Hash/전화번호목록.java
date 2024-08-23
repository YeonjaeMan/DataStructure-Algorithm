package CodingTest.Hash;

import java.util.HashMap;
import java.util.Map;

// 고득점 알고리즘 Kit 해시 3번 문제
/*
* 1. 해시 테이블에 <전화번호, 인덱스> 를 저장
* 2. 해시 테이블의 키값에 phone_book[i]의 0부터 j(phone_book[i].length() - 1)까지의 서브문자열이 있는지 확인
* ex) phone_book = {"12", "123"}
* "123"에서 "1", "12"까지만 서브문자열 추출 후 해시 테이블의 키값에 포함되어있는지 확인
*/
public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j)))
                    return false;
            }
        }
        return true;
    }
}
