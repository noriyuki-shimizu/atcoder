package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        q_3();
    }

    private static void q_1() {
        try(Scanner scan = new Scanner(System.in)) {
            int H = scan.nextInt();
            int W = scan.nextInt();
            int h = scan.nextInt();
            int w = scan.nextInt();

            int result = (H * W) - ((W * h) - (h * w) + (H * w));

            System.out.println(result);
        }
    }

    private static void q_2() {
        try(Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int C = scan.nextInt();

            int[] B = IntStream.range(0, M).map(i -> scan.nextInt()).toArray();
            int[][] A = new int[N][M];

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    A[i][j] = scan.nextInt();
                }
            }

            int cnt = 0;
            int result;
            for(int i=0; i<N; i++) {
                result = 0;
                for(int j=0; j<M; j++) {
                    result += B[j] * A[i][j];
                }
                result += C;

                if(result > 0) {
                    cnt ++;
                }
            }

            System.out.println(cnt);

        }
    }

    private static void q_3() {
        try(Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            int M = scan.nextInt();

            Long[] A = new Long[N];

            Map<Long, Long> AB = new HashMap<>();

            for(int i=0; i<N; i++) {
                A[i] = scan.nextLong();
                AB.put(A[i], scan.nextLong());
            }

            long total = 0;
            while (M > 0) {
                long min = A[0];
                int index = 0;
                for(int i=0; i<A.length; i++) {
                    if (A[i] < min) {
                        min = A[i];
                        index = i;
                    }
                }
                A = remove(A, index);

                long abNum = AB.get(min);

                for(long i=0; i<abNum; i++) {
                    M -= 1;

                    if(M < 0) break;

                    total += min;
                }

            }

            System.out.println(total);
        }
    }

    private static Long[] remove(Long[] target, int removeNum) {
        List<Long> temp = new ArrayList<>(Arrays.asList(target));
        temp.remove(removeNum);
        return temp.toArray(new Long[0]);
    }
}
