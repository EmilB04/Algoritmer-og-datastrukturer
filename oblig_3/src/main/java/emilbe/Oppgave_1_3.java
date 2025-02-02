package emilbe;

import java.util.Scanner;

public class Oppgave_1_3 {
    // Oppgave 1 //
    public static long C_rekursiv(int n, int m) {
        if (m == 0 || m == n) {
            return 1;
        } 
        else {
            return C_rekursiv(n-1, m-1) + C_rekursiv(n-1, m);
        }
    }

    // Oppgave 3 //
    public static void printBinomialCoefficients() {
        Scanner scanner = new Scanner(System.in);

        // Input fra bruker - n
        System.out.print("Skriv inn verdien for n: ");
        int n = scanner.nextInt();

        // Skriver ut binomialkoeffesientene for n
        System.out.println("Binomialkoeffesientene for n = " + n + " er:");
        for (int m = 0; m <= n; m++) {
            System.out.println("C(" + n + "," + m + ") = " + C_rekursiv(n, m));
        }
        scanner.close();
    }
    
    // Override for oppgave 3. Brukes i oppgave 4
    public static void printBinomialCoefficients(int n) {
        System.out.println("Binomialkoeffesientene for n = " + n + " er:");
        for (int m = 0; m <= n; m++) {
            System.out.println("C(" + n + "," + m + ") = " + C_rekursiv(n, m));
        }
    }

    // Oppgave 5 - Ikke-rekursiv metode - Pascal's trekant
    public static long C_interativ(int n, int m) {
        long[][] pascal = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        return pascal[n][m];
    }


    public static void main(String[] args) {
        // Oppgave 1
        System.out.println("Oppgave 1");
        System.out.println(C_rekursiv(5, 3));

        // Oppgave 3
        System.out.println("Oppgave 3");
        printBinomialCoefficients();

        // Oppgave 4 //
        System.out.println("Oppgave 4 started med n = 30 om 4 sekunder");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printBinomialCoefficients(30);

        // Oppgave 5
        System.out.println("Oppgave 5");
        System.out.println(C_interativ(5, 3));

        //TODO: Oppgave 4 6 og 7
    }
}