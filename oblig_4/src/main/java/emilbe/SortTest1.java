package emilbe;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class SortTest1 {
    public static void main(String[] args) {
        System.out.printf("%10s%10s%10s%10s\n", "n", "tA", "tL", "tL/tA");
        System.out.println("------------------------------------");

        for (int n = 1_000_000; n <= 10_000_000; n += 1_000_000) {
            // Fyller array med tilfeldige tall
            int A[] = new int[n];
            Random r = new Random();
            for (int i = 0; i < n; i++)
                A[i] = r.nextInt(2 * n);

            // Oppretter en lenket liste og fyller den med de samme
            // tallene i samme rekkefølge som i arrayen
            LinkedList<Integer> L = new LinkedList<Integer>();
            for (int i = n - 1; i >= 0; i--)
                L.addFirst(Integer.valueOf(A[i]));

            long tA, tL, t;
            // Tar tiden på sortering av array
            t = System.currentTimeMillis();
            Arrays.sort(A);
            tA = System.currentTimeMillis() - t;

            // Tar tiden på sortering av liste
            t = System.currentTimeMillis();
            Collections.sort(L);
            tL = System.currentTimeMillis() - t;

            // Skriver ut resultater
            System.out.printf("%10d%10d%10d%10.1f\n", n, tA, tL, (float) tL / (float) tA);
        }
    }
}
