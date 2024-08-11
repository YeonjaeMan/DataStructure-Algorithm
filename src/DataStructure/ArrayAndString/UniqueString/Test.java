package DataStructure.ArrayAndString.UniqueString;

import java.util.HashMap;

// 주어진 문자열의 문자들이 모두 고유한지를 확인하는 함수를 구현하시오.
// 만약 별도의 저장공간을 사용하지 못하는 경우에는 어떻게 해결할지도 추가로 설명하시오.
public class Test {
    public static void main(String[] args) {
        System.out.println(isUnique1("abcdefgghijk"));
        System.out.println(isUnique1("abcdefghijk"));

        System.out.println(isUnique2("abcdefgghijk"));
        System.out.println(isUnique2("abcdefghijk"));

        System.out.println(isUnique3("abcdefgghijk"));
        System.out.println(isUnique3("abcdefghijk"));
    }

    // 아스키 코드를 이용한 방법
    private static boolean isUnique1(String str) {
        if(str.length() > 128)
            return false;
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    // 해시맵을 이용한 방법
    private static boolean isUnique2(String str) {
        HashMap<Integer, Boolean> hashmap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if(hashmap.containsKey(c)) {
                return false;
            }
            hashmap.put(c, true);
        }
        return true;
    }

    // 비트연산과 쉬프트연산을 이용한 방법
    private static boolean isUnique3(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
