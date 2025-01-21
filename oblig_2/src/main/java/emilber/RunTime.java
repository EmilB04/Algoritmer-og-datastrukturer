package emilber;

import java.io.*;
import java.util.Scanner;

class RunTime {
    public static void lineær(long n) {
        int tmp = 1;
        for (long i = 0; i < n; i++)
            tmp *= 1;
    }

    public static void kvadratisk(long n) {
        int tmp = 1;
        for (long i = 0; i < n; i++)
            for (long j = 0; j < n; j++)
                tmp *= 1;
    }

    public static int logaritmisk(long n) {
        int tmp = 1, iterasjoner = 0;
        for (long i = n; i > 0; i /= 2) {
            tmp *= 1;
            iterasjoner++;
        }
        return iterasjoner;
    }

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        long n, T, T1, T2;
        int valg, iterasjoner = 0;

        System.out.print("1:O(n) 2:O(n²) 3:O(log_n) ? ");
        valg = S.nextInt();
        System.out.print("n? ");
        n = S.nextLong();

        T1 = System.currentTimeMillis();
        if (valg == 1)
            lineær(n);
        else if (valg == 2)
            kvadratisk(n);
        else if (valg == 3)
            iterasjoner = logaritmisk(n);
        T2 = System.currentTimeMillis();

        T = T2 - T1;
        System.out.print("T = " + T + " ms");
        if (valg == 3)
            System.out.print(" (" + iterasjoner + ")");
        System.out.println();
    }
}