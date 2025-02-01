public class factorial {
    public static int doFactorial(int n) {
        int output = 1;
        if (n > 1) {
            output = n * doFactorial(n - 1);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(doFactorial(6));
    }
}