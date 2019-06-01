import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Solution {
    public static void main(String[] as) {
        int total = 0;

        String arr = null;
        //arr = "10,5,6,7,9,0";
        // arr = "10\n,5,6,7,9,0";
        //arr = "//,\n10,5,6,7,9,0";
        arr = "//,\n1001,5,6,7,9,0";

        Solution s = new Solution();

        total = add(arr);
        System.out.println("total " + total);
    }

    public static int add(String numbers) {
        int sum = 0;
        try {

            if (!numbers.isEmpty()) {

                if (isDigit(numbers.charAt(0))) {
                    //handles the normal input like 1,2,3,4 or 1\n,2,3,4
                    sum = process(numbers, "\\W+");

                }
                if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
                    //handle the input with format //@\n1@2@3

                    String mychar = Character.toString(numbers.charAt(2));//extracting the delimiter

                    String[] after_Split = numbers.split("\n");//splitting the string from \n
                    String spl = after_Split[1];

                    sum = process(spl, mychar);

                }

            }
        } catch (Exception e) {
            return 0;
        }
        return sum;
    }

    public static int process(String string_input, String delimiter_char) {
        int sum = 0;
        try {
            List<Integer> list = null;
            List<Integer> positive = new ArrayList<>();
            List<Integer> negative = new ArrayList<>();

            list = Stream.of(string_input.split(delimiter_char)).map(Integer::parseInt).filter(i -> i < 1000).collect(Collectors.toList());// putting every character from string into list after spliting using the delimiter

            if (!list.isEmpty()) {

                list.stream().forEach(i -> (i < 0 ? negative : positive).add(i));

                if (!negative.isEmpty()) {
                    throw new Exception();
                } else {
                    sum = positive.stream().mapToInt(i -> i).sum();// sum of list of numbers in positive list

                }
            }
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("negatives not allowed");
            return 0;
        }
        return sum;

    }

}
