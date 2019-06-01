import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Solution {
    public static void main(String[] as) {
        int total = 0;

        String arr = null;
        arr = "10,5,6,7,9,0";

        Solution s = new Solution();

        total = add(arr);
        System.out.println("total " + total);
    }

    public static int add(String numbers) {
        int sum = 0;
        try {

            if (!numbers.isEmpty()) {

                if (isDigit(numbers.charAt(0))) {

                    sum = process(numbers, "\\W+");

                }

            }
        } catch (Exception e) {
            return 0;
        }
        return sum;
    }

    public static int process(String string_input, String delimiter_char) {
        int sum = 0;
        List<Integer> list = null;
        list = Stream.of(string_input.split(delimiter_char)).map(Integer::parseInt).collect(Collectors.toList());
        sum = list.stream().mapToInt(i -> i).sum();
        return sum;
    }
}
