package emilbe;

import java.io.*;
import java.util.*;

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
            // Setter hele nabomatrisen, untatt diagonalen, til false
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    nabo[i][j] = (i == j) ? true : false;
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
        int[] inngrad = new int[n];
        List<Integer> sortert = new ArrayList<>();
        Queue<Integer> ko = new LinkedList<>();
        
        // Beregn inngraden til alle noder
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nabo[j][i]) {
                    inngrad[i]++;
                }
            }
        }
        
        // Legg til alle noder med inngrad 0 i køen
        for (int i = 0; i < n; i++) {
            if (inngrad[i] == 0) {
                ko.add(i);
            }
        }
        
        // Kjør algoritmen
        while (!ko.isEmpty()) {
            int node = ko.poll();
            sortert.add(node);
            
            for (int i = 0; i < n; i++) {
                if (nabo[node][i]) {
                    inngrad[i]--;
                    if (inngrad[i] == 0) {
                        ko.add(i);
                    }
                }
            }
        }
        
        // Sjekk om vi har en syklisk graf (som ikke kan sorteres topologisk)
        if (sortert.size() != n) {
            System.out.println("Grafen inneholder en syklus og kan ikke sorteres topologisk.");
            return;
        }
        
        // Skriv ut topologisk sortering
        for (int i = 0; i < sortert.size(); i++) {
            System.out.print(data[sortert.get(i)] + " ");
        }
        System.out.println();
    }

    // main(); Testprogram
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in, "UTF-8");
        System.out.print("File? ");
        String filNavn = scan.next();

        new TopSort(filNavn).findAndPrint();
    }
}