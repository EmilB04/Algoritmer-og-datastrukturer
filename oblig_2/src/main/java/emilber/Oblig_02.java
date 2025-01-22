package emilber;

import java.util.Scanner;

public class Oblig_02 {

    private static void superlinear(long n) {
        int tmp = 1;
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                tmp *= 1;
            }
        }
    }

    private static void cubical(long n) {
        int tmp = 1;
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                for (long k = 0; k < n; k++) {
                    tmp *= 1;
                }
            }
        }
    }

    private static void exponential(long n) {
        int tmp = 1;
        long squared = (long) Math.pow(2, n);
        for (long i = 0; i < squared; i++) {
            tmp *= 1;
        }
    }
    private static void combinatorical(long n) {
        int tmp = 1;
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn tall for algoritmen du vil teste: ");
        System.out.println("1: Superlineær algoritme \n2: Kubisk algoritme \n3: Eksponentiell algoritme");
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
        else {
            System.out.println("Ugyldig valg");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tid brukt: " + (endTime - startTime) + "ms");
        scanner.close();
    }
    // Superlineær algoritme: 125_000 = 10 sekunder
    // Kubisk 2500 = 10 sekunder
}
