package emilbe;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Topologisk sortering

public class TopSort {
    int n; // Antall noder i grafen
    boolean nabo[][]; // Nabomatrise
    String data[]; // Data i hver node

    // TopSort(): Konstruktør
    // Leser inn grafen fra fil, ingen feilsjekking
    public TopSort(String filNavn) {
        // Filformat:
        // ant.noder
        // node# data ant.naboer nabo# nabo# ...
        // node# data ant.naboer nabo# nabo# ...
        // ...
        try {
            // Åpner datafil for lesing
            Scanner in = new Scanner(new File(filNavn), "UTF-8");
            // Leser antall noder
            n = in.nextInt();
            // Oppretter nabomatrisen
            nabo = new boolean[n][n];
            // Setter hele nabomatrisen, unntatt diagonalen, til false
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nabo[i][j] = (i == j) ? true : false;
                }
            }
            // Oppretter arrayen med data (string) for hver node
            data = new String[n];
            // For hver node: Les data og alle naboene noden har
            for (int i = 0; i < n; i++) {
                int nodeNr = in.nextInt();
                data[nodeNr] = in.next();
                int antNaboer = in.nextInt();
                for (int j = 0; j < antNaboer; j++) {
                    int naboNr = in.nextInt();
                    nabo[nodeNr][naboNr] = true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file " + filNavn);
            System.exit(1);
        }
    }

    // findAndPrint(): Finner og skriver ut en topologisk sortering
    public void findAndPrint() {
        // Steg 1: Beregn inngraden til alle noder
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nabo[i][j] && i != j) { // Ikke tell selv-løkker
                    inDegree[j]++;
                }
            }
        }

        // Steg 2: Legg alle noder med inngrad 0 i en kø
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Steg 3: Utfør topologisk sortering
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Ta ut en node fra køen
            result.add(data[current]); // Legg nodens data til resultatet

            // Reduser inngraden til alle naboene
            for (int i = 0; i < n; i++) {
                if (nabo[current][i] && current != i) { // Ikke reduser for selv-løkker
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i); // Legg til i køen hvis inngraden blir 0
                    }
                }
            }
        }

        // Sjekk om det finnes en syklus
        if (result.size() < n) {
            System.out.println("Error: Grafen inneholder en syklus og kan ikke sorteres topologisk.");
        } else {
            // Skriv ut resultatet
            System.out.println(String.join(" ", result));
        }
    }

    // main(); Testprogram
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in, "UTF-8");
        System.out.print("File? ");
        String filNavn = scan.next();

        new TopSort(filNavn).findAndPrint();
    }
}