package emilbe;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Emil Berglund
 */
public class WordHash {

    public static void main(String[] args) {
        // Oppretter en tom hashtabell H med String som key og Integer
        // som dataverdier. Tabellen får default lengde og
        // default maks. lastfaktor.
        HashMap<String, Integer> H = new HashMap<String, Integer>();

        // Legger inn syv ord med tilhørende tallverdier
        H.put("pear", 4);
        H.put("banana", 9);
        H.put("apple", 8);
        H.put("coconut", 2);
        H.put("mango", 10);
        H.put("peach", 5);
        H.put("papaya", 5);

        // Les et ord fra bruker
        Scanner scan = new Scanner(System.in);
        System.out.print("? ");
        String ord = scan.next();
        scan.close();

        // Skriv ut ordet hvis det finnes i hashtabellen
        if (H.containsKey(ord)) {
            System.out.println(ord + ": " + H.get(ord));
        }

        // Oppdaterer en verdi i tabellen
        H.replace("coconut", 3);

        // Fjerner en verdi fra tabellen
        H.remove("mango");

        // Skriver ut antall data, og alle verdiene i
        // tabellen ved å iterere over nøkkelverdiene
        System.out.println("\nAll " + H.size()
                + " elements in hash table:\n");
        for (String key : H.keySet()) {
            System.out.println(key + ": " + H.get(key));
        }
    }

}
