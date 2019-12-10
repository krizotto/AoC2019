package day5;

public class Day5 {
    public static void main(String[] args) {
        int[] cleanInput = {1002, 12, 2, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19, 5, 23, 2, 10, 23, 27, 2, 27, 13, 31, 1, 10, 31, 35, 1, 35, 9, 39, 2, 39, 13, 43, 1, 43, 5, 47, 1, 47, 6, 51, 2, 6, 51, 55, 1, 5, 55, 59, 2, 9, 59, 63, 2, 6, 63, 67, 1, 13, 67, 71, 1, 9, 71, 75, 2, 13, 75, 79, 1, 79, 10, 83, 2, 83, 9, 87, 1, 5, 87, 91, 2, 91, 6, 95, 2, 13, 95, 99, 1, 99, 5, 103, 1, 103, 2, 107, 1, 107, 10, 0, 99, 2, 0, 14, 0};
//        int test[]={1,1,1,4,99,5,6,0,99};

        List<Integer> input = new ArrayList<>();
        final int goal = 19690720;

        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                refreshArray(input, cleanInput);
                input.set(1, noun);
                input.set(2, verb);
                func(input);

                if (input.get(0).equals(goal)) {
                    System.out.println("Noun: " + noun + "\nVerb: " + verb + "\nAnswer: " + (100 * noun + verb));
                    break;
                }

            }
        }
    }

    private static void refreshArray(List<Integer> input, int[] cleanInput) {
        input.clear();
        for (int i : cleanInput) input.add(i);
    }

    private static void func(List<Integer> test) {
        Iterator<Integer> i = test.iterator();

        while (i.hasNext()) {
            Integer operation = i.next();
            Integer currentOpcode = operation % 100;
            List<String> parameterMode = new ArrayList<>(Arrays.asList(operation.toString().split("")));
            parameterMode.subList(parameterMode.size() - 2, parameterMode.size()).clear();
            while (parameterMode.size() < 3) parameterMode.add(0, "0");
            Collections.reverse(parameterMode);
            Iterator<String> paramMode = parameterMode.iterator();
            Integer first = null, second = null, destination = null;
            String firstMode = "", secondMode = "", destinationMode = "";
            switch (currentOpcode) {
                case 99:
                    break;
                case 1:

                    if (i.hasNext() && paramMode.hasNext()) {
                        first = i.next();
                        firstMode = paramMode.next();
                    }
                    if (i.hasNext() && paramMode.hasNext()) {
                        second = i.next();
                        secondMode = paramMode.next();
                    }
                    if (i.hasNext() && paramMode.hasNext()) {
                        destination = i.next();
                        destinationMode = paramMode.next();
                    }
                    operation1(test, getParameter(test, first, firstMode), getParameter(test, second, secondMode), getParameter(test, destination, destinationMode));
                case 2:
                    if (i.hasNext() && paramMode.hasNext()) {
                        first = i.next();
                        firstMode = paramMode.next();
                    }
                    if (i.hasNext() && paramMode.hasNext()) {
                        second = i.next();
                        secondMode = paramMode.next();
                    }
                    if (i.hasNext() && paramMode.hasNext()) {
                        destination = i.next();
                        destinationMode = paramMode.next();
                    }
                    operation2(test, getParameter(test, first, firstMode), getParameter(test, second, secondMode), getParameter(test, destination, destinationMode));

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + currentOpcode);
            }

        }
    }



    private static Integer getParameter(List<Integer> test, Integer it, String mode) {
        if (mode == "0") return test.get(it);
        if (mode == "1") return it;
        return null;
    }

    private static void operation1(List<Integer> test, Integer param1, Integer param2, Integer dest) {
        int eq;
        eq = param1 + param2;
        test.set(dest, eq);
    }
    private static void operation2(List<Integer> test, Integer param1, Integer param2, Integer dest) {
        int eq = 1;
        eq = param1 * param2;
        test.set(dest, eq);

    }
}