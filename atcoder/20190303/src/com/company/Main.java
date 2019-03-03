package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        q_3();
    }

    private static void q_1() {
        try (Scanner scan = new Scanner(System.in)) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            System.out.println(b / a < c ? b / a : c);
        }
    }

    private static void q_2() {
        try(Scanner scan = new Scanner(System.in)) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            int min = Math.min(a, b);

            int cnt = 0;
            for (; min >= 1; min--) {
                if (a % min == 0 && b % min == 0) {
                    cnt ++;
                    if(cnt == c) {
                        break;
                    }
                }
            }

            System.out.println(min);
        }
    }

    private static void q_3() {
        try(Scanner scan = new Scanner(System.in)) {
            String str = scan.next();

            int cnt = 0;
            while (true) {
                if(str.indexOf("01") == -1 && str.indexOf("10") == -1) {
                    break;
                }

                cnt += count(str, "01");

                str = str.replace("01", "");

                cnt += count(str, "10");

                str = str.replace("10", "");
            }

            System.out.println(cnt);
        }
    }

    private static int count(String str, String item) {
        Pattern p = Pattern.compile(item);
        Matcher m = p.matcher(str);
        int count = 0;
        int s = 0;
        while (m.find(s)) {
            count++;
            s = m.end();
        }

        return count*2;
    }
}
