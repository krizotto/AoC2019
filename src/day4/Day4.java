package day4;

public class Day4 {
    private static final int CODE_LENGTH = 6;

    public static void main(String[] args) {
        final int LOWEST = 353096;
        final int HIGHEST = 843212;

        int totalNumbers = 0;
        for (int i = LOWEST; i <= HIGHEST; i++) {
            String s = Integer.toString(i);
            if (notDecreasingTest(s)) {
                if (doubleNumberTest(s)) totalNumbers += 1;
            }
        }
        System.out.println(totalNumbers);
    }

    public static Boolean notDecreasingTest(String s) {
        for (int i = 0; i < CODE_LENGTH - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        }
        return true;
    }

    public static Boolean doubleNumberTest(String s) {
        for (int i = 0; i < CODE_LENGTH - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return true;
        }
        return false;
    }
}
