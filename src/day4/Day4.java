package day4;

public class Day4 {
    public static void main(String[] args) {
        final int LOWEST = 353096;
        final int HIGHEST = 843212;

        int totalNumbers = 0;
        for (int i = LOWEST; i <= HIGHEST; i++) {
            String s = Integer.toString(i);
            if (notDecreasingTest(s) && doubleNumberTest(s)) totalNumbers += 1;
        }
        System.out.println("Total numbers matching criteria: " + totalNumbers);
    }

    private static Boolean notDecreasingTest(String s) {
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        return true;
    }

    private static Boolean doubleNumberTest(String s) {
        for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) == s.charAt(i + 1)) return true;
        return false;
    }

    private static Boolean doubleNumberTestV2(String s) {
        int[] count = new int[10];
        boolean repeat = false;
        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            int val = Integer.parseInt(String.valueOf(current));

            if (current == next) {
                repeat = true;
                count[val] += 1;
            } else if (repeat) {
                count[val] += 1;
                repeat = false;
            }
            if (i == s.length() - 2 && repeat) {
                count[val] += 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] == 2) return true;
        }
        return false;
    }
}