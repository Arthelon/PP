import java.util.*;

public class Factorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int n = in.nextInt();
            int result = 0;
            for (int d = 5; d <= n; d *= 5) {
                result += n / d;
            }
            System.out.println(result);
        }
    }
}