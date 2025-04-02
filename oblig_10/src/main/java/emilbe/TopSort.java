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
        /*** Skal programmeres i oblig. 10 ***/
    }

    // main(); Testprogram
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in, "UTF-8");
        System.out.print("File? ");
        String filNavn = scan.next();

        new TopSort(filNavn).findAndPrint();
    }
}