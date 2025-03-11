package emilbe;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// WordBST: Binært søketre for lagring av ord og ordfrekvenser
public class WordBST {
    private TreeMap<String, Integer> wordMap = new TreeMap<>();

    public WordBST() {
        wordMap = new TreeMap<>();
    }

    // size(): Antall ord som er lagret i treet
    public int size() {
        return wordMap.size();
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord) {
        if (wordMap.containsKey(ord)) {
            wordMap.put(ord, wordMap.get(ord) + 1);
        } 
        else {
            wordMap.put(ord, 1);
        }
    }

    // search(): Søk etter et ord. Skriv ut ordet og ordfrekvensen hvis det finnes i søketreet.
    public void search(String ord) {
        if (wordMap.containsKey(ord)) {
            System.out.println(ord + ": " + wordMap.get(ord));
        } 
        else {
            System.out.println("Word not found");
        }
    }

    // print(): Alfabetisk utskrift av hele søketreet
    public void print() {
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }




    // main(): Testprogram
    public static void main(String[] args) {
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
            } else if (valg == 2) {
                wBST.print();
            }
        }
    }
}