package emilbe;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class SortTest2 {
    public static void main(String[] args) {
        for (int n = 15; n <= 15; n += 1) {
            int[] A = new int[n];
            Random r = new Random();
            int third = n / 3;

            // De første n/3 verdiene i stigende sortert rekkefølge
            for (int i = 0; i < third; i++) {
                A[i] = i;
            }

            // De neste n/3 verdiene som tilfeldige tall større eller lik 0 og mindre enn 2*n
            for (int i = third; i < 2 * third; i++) {
                A[i] = r.nextInt(2 * n);
            }

            // De siste n/3 verdiene i stigende sortert rekkefølge
            for (int i = 2 * third; i < n; i++) {
                A[i] = i - third;
            }

            // Oppretter en lenket liste og fyller den med de samme tallene
            LinkedList<Integer> L = new LinkedList<>();
            for (int value : A) {
                L.add(value);
            }

            // Skriver ut usortert liste
            System.out.println("Usortert: " + Arrays.toString(A));

            Arrays.sort(A);
            Collections.sort(L);

            // Skriver ut sortert liste
            System.out.println("Sortert: " + Arrays.toString(A));
        }
    }
}
