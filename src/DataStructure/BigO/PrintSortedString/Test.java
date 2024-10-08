package DataStructure.BigO.PrintSortedString;

// Q : print all strings of length k where the characters are in sorted order.
//     implement a method to generate all strings of length k and then check if each is sorted.
public class Test {
    public static final int C = 26;

    public static void main(String[] args) {
        printSortedStrings(2);
    }

    private static void printSortedStrings(int k) {
        printSortedStrings(k, "");
    }

    private static void printSortedStrings(int k, String prefix) {
        if(k == 0) {
            if(isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for(int i = 0; i < C; i++) {
                char c = ithLetter(i);
                printSortedStrings(k - 1, prefix + c);
            }
        }
    }

    private static boolean isInOrder(String s) {
        for(int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if(prev > curr) {
                return false;
            }
        }
        return true;
    }

    private static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }
}
