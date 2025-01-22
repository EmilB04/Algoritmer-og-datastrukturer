package emilber;

import java.util.Scanner;

public class Oblig_02 {

    private static void superlinear(long n) {
        for (long i = 0; i < n; i++) {
            for (long j = 1; j < n; j *= 2) {
                // Do nothing
            }
        }
    }

    private static void cubical(long n) {
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                for (long k = 0; k < n; k++) {
                    // Do nothing
                }
            }
        }
    }

    private static void exponential(long n) {
        long squared = (long) Math.pow(2, n);
        for (long i = 0; i < squared; i++) {
            // Do nothing
        }
    }
    private static void combinatorical(long n) {
        long nFaculty = 1;
        for (long i = 1; i <= n; i++) {
            nFaculty *= i;
        }
        for (long i = 0; i < nFaculty; i++) {
            // Do nothing
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn tall for algoritmen du vil teste: ");
        System.out.println("1: Superlineær algoritme \n2: Kubisk algoritme \n3: Eksponentiell algoritme \n4: Kombinatorisk algoritme");
        int choice = scanner.nextInt();
        System.out.println("Skriv inn tall for n: ");
        long n = scanner.nextLong();
        long startTime = System.currentTimeMillis();

        if (choice == 1) {
            superlinear(n);
        } 
        else if (choice == 2) {
            cubical(n);
        } 
        else if (choice == 3) {
            exponential(n);
        }
        else if (choice == 4) {
            combinatorical(n);
        }
        else {
            System.out.println("Ugyldig valg");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tid brukt: " + (endTime - startTime) + "ms");
        scanner.close();
    }
    // Superlineær algoritme 500_050_000 = 10 sekunder
    // Kubisk 2500 = 10 sekunder
    // Eksponentiell --
    // Kombinatorisk 15_500_000_000 (15 milliarder) = 10 sekunder
}
