package emilbe;

import java.util.Scanner;

public class Oppgave_5_6 {
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

    // Oppgave 6 - Skriv ut Pascal's trekant // 
    public static void printPascalsTriangle() {
        Scanner scanner = new Scanner(System.in);

        // Input fra bruker - n
        System.out.print("Skriv inn verdien for n: ");
        int n = scanner.nextInt();

        // Skriver ut binomialkoeffesientene for n
        System.out.println("Pascals trekant for n = " + n + " er:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println("C(" + i + "," + j + ") = " + C_interativ(i, j));
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Oppgave 5");
        System.out.println(C_interativ(5, 3));

        System.out.println("Oppgave 6");
        printPascalsTriangle();
    }
}
