import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        q_3();
    }

    private static void q_1() {
        try (Scanner scan = new Scanner(System.in)) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            System.out.println(b % a == 0 ? b + a : b - a);
        }
    }

    private static void q_2() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt(); // n人
            int m = scan.nextInt(); // m種類

            Map<Integer, Integer> a = new HashMap<>();
            for(int i=0; i<n; i++) {
                int k = scan.nextInt();
                for(int j=0; j<k; j++) {
                    int am = scan.nextInt();
                    a.merge(am, 1, Integer::sum);
                }
            }

            int cnt = 0;

            for (Integer val : a.values()) {
                if(val == n) {
                    cnt ++;
                }
            }

            System.out.println(cnt);

        }
    }

    private static void q_3() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = Integer.parseInt(scan.next());
            int[] l = IntStream.range(0, n).map(i -> Integer.parseInt(scan.next())).toArray();

            int min = Arrays.stream(l).min().getAsInt();
            int remnant = Arrays.stream(l).sum() - min;

            int result = remnant % min;

            if(result <= 0 || min < result) {
                System.out.println(min);
            } else {
                System.out.println(result);
            }
        }
    }
}
