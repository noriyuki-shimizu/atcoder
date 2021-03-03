import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        q_3();
    }

    // q_1 残すのを忘れた、、、

    private static void q_2() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt(); // N
            int d = scan.nextInt(); // D

            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String k = scan.next();
                String[] split = k.split("[.]");

                StringJoiner sj = new StringJoiner(".");
                for(int j=split.length-d; j<split.length; j++) {
                    sj.add(split[j]);
                }
                list.add(sj.toString());
            }

            Map<String, Long> counts = list.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            for(Map.Entry<String, Long> entry : counts.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    // 解けなかった、、、
    private static void q_3() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt(); // 商品の数N
            int x = scan.nextInt(); // クーポンAの枚数 (商品を5%引き)
            int y = scan.nextInt(); // クーポンBの枚数 (商品が1000円以上の場合に100円引き)

            int sum = 0;

            Integer[] priceArray = new Integer[n];
            for(int i=0; i<n; i++) {
                priceArray[i] = scan.nextInt();
            }
            Arrays.sort(priceArray, Collections.reverseOrder());

            for (Integer price : priceArray) {
                if (price >= 1000 && y > 0) {
                    int fivePercentPrice = (int)(price * 0.05);
                    if (fivePercentPrice > 100 && x > 0) {
                        sum += (price - fivePercentPrice);
                        x--;
                    } else {
                        sum += (price - 100);
                        y--;
                    }
                } else if(x > 0) {
                    sum += (int)(price * 0.95);
                    x--;
                } else {
                    sum += price;
                }
            }

            System.out.println(sum);
        }
    }
}
