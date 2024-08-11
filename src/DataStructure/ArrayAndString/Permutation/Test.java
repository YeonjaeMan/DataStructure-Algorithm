package DataStructure.ArrayAndString.Permutation;

// 주어진 두개의 문자열이 서로 치환되는지를 알아내는 함수를 구현하시오.
public class Test {
    public static void main(String[] args) {
        System.out.println(permutation1("ABC", "BCA"));
        System.out.println(permutation1("ABC", "BDA"));

        System.out.println(permutation2("ABC", "BCA"));
        System.out.println(permutation2("ABC", "BDA"));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    private static boolean permutation1(String s, String t) {
        if(s.length() != t.length())
            return false;
        return sort(s).equals(sort(t));
    }

    private static boolean permutation2(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] letters = new int[128];
        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if(letters[t.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
