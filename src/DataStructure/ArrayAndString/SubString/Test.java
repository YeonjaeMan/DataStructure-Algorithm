package DataStructure.ArrayAndString.SubString;

public class Test {
    public static void main(String[] args) {
        System.out.println(isRotation("string", "ringst"));
        System.out.println(isRotation("string", "ingstr"));
        System.out.println(isRotation("string", "ingstn"));
        System.out.println(isRotation("string", "ringstr"));
    }

    private static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        return isSubString(s1 + s2, s2);
    }

    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }
}
