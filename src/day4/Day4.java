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
                if (doubleNumberTestV2(s)) {
                    totalNumbers += 1;
                    System.out.println(s);
                }

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

    public static Boolean doubleNumberTestV2(String s) {
        int[] count = new int[10];
        boolean positive = false;
        for (int i = 0; i < CODE_LENGTH - 1; i++) {
            int val = Integer.parseInt(String.valueOf(s.charAt(i)));
            count[val] += 1;
            if (s.charAt(i) == s.charAt(i + 1)) {
                positive = true;
                if (i == CODE_LENGTH - 2) count[val] += 1;
            } else if (!positive) count[val] -= 1;

        }
        int repeat2 = 0;
        int repeatMore = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] == 2) repeat2 = i;
            if (count[i] > 2) repeatMore = i;
        }
        return repeat2 >= repeatMore;
    }
}
