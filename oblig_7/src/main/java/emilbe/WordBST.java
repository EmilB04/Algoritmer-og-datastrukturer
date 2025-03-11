package emilbe;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// WordBST: Binært søketre for lagring av ord og ordfrekvenser
public class WordBST {
    // WordNode: Indre klasse for en node i søketreet
    /*
     * Pekere/referanser til noder lenger ned i søketreet.
     * En konstruktør som skal brukes første gang et nytt ord er lest.
     * En metode print() som skriver ut en linje med dataene for et ord.
     */
    class WordNode {
        String nodeOrd; // Ordet som lagres i noden
        int antall; // Antall forekomster av ordet

        WordNode venstre, hoyre; // Pekere til venstre og høyre barn

        // Konstruktør
        public WordNode(String ord) {
            nodeOrd = ord;
            antall = 1;
            venstre = null;
            hoyre = null;
        }

        // print(): Skriver ut dataene for en node
        public void print() {
            System.out.println(nodeOrd + ": " + antall);
        }
    }

    private WordNode rot; // Roten i hele søketreet
    private int n; // Antall noder i hele treet

    // WordBST(): Konstruktør som lager et tomt søketre
    public void WordBST() {
        rot = null;
        n = 0;
    }

    // size(): Antall ord som er lagret i treet
    public int size() {
        return n;
    }

    // insert(): Setter inn ny forekomst av et ord
    /*
     * i klassen WordBST. Metoden skal registrere en ny forekomst av et ord i
     * teksten. Hvis ordet ikke er lest tidligere, skal det settes inn som en ny
     * bladnode med den vanlige algoritmen for innsetting i søketre. Hvis ordet
     * finnes fra før, skal bare antall forekomster av ordet økes med én. Du kan
     * selv velge om metoden skal være rekursiv eller iterativ.
     */
    public void insert(String ord) {
        if (rot == null) {
            rot = new WordNode(ord);
            n++;
        } else {
            WordNode node = rot;
            while (true) {
                if (ord.compareTo(node.nodeOrd) < 0) {
                    if (node.venstre == null) {
                        node.venstre = new WordNode(ord);
                        n++;
                        return;
                    }
                    node = node.venstre;
                } 
                else if (ord.compareTo(node.nodeOrd) > 0) {
                    if (node.hoyre == null) {
                        node.hoyre = new WordNode(ord);
                        n++;
                        return;
                    }
                    node = node.hoyre;
                } 
                else {
                    node.antall++;
                    return;
                }
            }
        }
    }

    // search(): Søk etter et ord. Skriv ut ordet og ordfrekvensen
    // hvis det finnes i søketreet.
    /*
     * i klassen WordBST. Metoden skal lete etter ordet/strengen ord i søketreet.
     * Hvis ordet finnes i treet skal metoden skrive det ut sammen med antall
     * forekomster av ordet. Hvis ordet ikke finnes, skal det ikke gjøres noen
     * utskrift. Metoden search() skal ikke være rekursiv, og den skal være så
     * effektiv som mulig.
     */

    public void search(String ord) {
        WordNode node = rot;
        while (node != null) {
            if (ord.compareTo(node.nodeOrd) < 0) {
                node = node.venstre;
            } 
            else if (ord.compareTo(node.nodeOrd) > 0) {
                node = node.hoyre;
            } 
            else {
                node.print();
                return;
            }
        }
        System.out.println("Word not found");
    }

    // print(): Alfabetisk utskrift av hele søketreet. Kaller en
    // rekursiv metode som gjør selve utskriften.
    public void print() {
        print(rot);
    }

    // print(): Rekursiv utskrift av hele søketreet med rot i "rot"
    /*
     * Metoden skal skrive ut alle ordene i søketreet med rot i noden rot, i alfabetisk rekkefølge.
     */
    private void print(WordNode rot) {
        if (rot != null) {
            print(rot.venstre);
            rot.print();
            print(rot.hoyre);
        }
    }

    // main(): Testprogram
    public static void main(String argv[]) {
        // Leser filnavn fra bruker
        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String fileName = scan.next();

        // Oppretter ordleser og tomt søketre
        WordReader wR = new WordReader(fileName);
        WordBST wBST = new WordBST();

        // Leser alle ordene på filen og legger inn i treet
        String ord = wR.nextWord();
        while (ord != null) {
            wBST.insert(ord);
            ord = wR.nextWord();
        }
        // Skriver ut antall ulike ord som fantes i filen
        System.out.println(wBST.size() + " unique words " +
                "read from file " + fileName);

        // Menyvalg for å teste programmet
        int valg = 0;
        while (valg != 3) {
            System.out.print("\n1:Search, 2:Print, 3:Quit ? ");
            valg = scan.nextInt();
            if (valg == 1) {
                System.out.print("Search for? ");
                ord = scan.next();
                wBST.search(ord.toLowerCase());
            } else if (valg == 2)
                wBST.print();
        }
    }
}