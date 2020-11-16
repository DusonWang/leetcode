package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                list.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                list.add("Buzz");
            } else if (i % 5 == 0) {
                list.add("FizzBuzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }
}
