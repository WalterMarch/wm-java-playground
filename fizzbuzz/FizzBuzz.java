public class FizzBuzz {
    public static void main(String[] args) {
        final int MAX = 100;
        for (int i = 1; i <= MAX; i++) {
            String output = "";
            output += (i % 3 == 0) ? "Fizz" : "";
            output += (i % 5 == 0) ? "Buzz" : "";

            // Java has a ternary operator, as above, but you can only use it 
            // to assign the results to a variable, not decide what to print.

            if (output.length() == 0) {
                System.out.println(i);
            } else {
                System.out.println(output);
            }
        }
    }
}