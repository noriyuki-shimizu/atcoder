import java.util.*;

public class Main {

    public static void main(String[] args) {
        q_3();
    }

    private static void q_1() {
        try(Scanner scan = new Scanner(System.in)) {
            String b = scan.next();

            switch (b) {
                case "A":
                    System.out.println("T");
                    break;
                case "T":
                    System.out.println("A");
                    break;
                case "C":
                    System.out.println("G");
                    break;
                case "G":
                    System.out.println("C");
                    break;
            }
        }
    }

    private static void q_2() {
        try(Scanner scan = new Scanner(System.in)) {
            String S = scan.next();

            List<Integer> cntList = new ArrayList<>();
            int cnt = 0;

            for(int i=0; i<S.length(); i++) {
                char b = S.charAt(i);

                switch (b) {
                    case 'A':
                        cnt ++;
                        break;
                    case 'T':
                        cnt ++;
                        break;
                    case 'C':
                        cnt ++;
                        break;
                    case 'G':
                        cnt ++;
                        break;
                    default:
                        cntList.add(cnt);
                        cnt = 0;
                }
            }
            cntList.add(cnt);

            Integer result = Collections.max(cntList);

            System.out.println(result);
        }
    }

    private static void q_3() {
        try(Scanner scan = new Scanner(System.in)) {
           int N = scan.nextInt();
           int Q = scan.nextInt();

           String S = scan.next();

           List<Integer> cntList = new ArrayList<>();

           for(int i=0; i<Q; i++) {
               int l = scan.nextInt() - 1;
               int r = scan.nextInt();

               int cnt = 0;

               String s = S.substring(l, r);

               System.out.println(s);

               String[] resultArr = s.split("AC");

               for(int j=0; j<resultArr.length; j++) {
                   if(resultArr[j].equals("")) {
                       cnt ++;
                   }
               }

               cntList.add(cnt);
           }

           cntList.forEach(cnt -> System.out.println(cnt));

        }
    }

}
