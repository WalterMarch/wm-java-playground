import java.util.TreeSet;

public class factors {
    public static void main(String[] args) {
        final int NUMBER = 100;
        TreeSet<Integer> factorSet = new TreeSet<>();

        factorSet.add(1);
        factorSet.add(NUMBER);

        for (int i = 2; i < NUMBER; i++) {
            if (NUMBER % i == 0) {
                factorSet.add(i);
                factorSet.add(NUMBER / i);
            }
        }
        System.out.println(factorSet.toString());
    }
}