package emilbe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// WordHash: HashMap for lagring av ord og ordfrekvenser
public class WordHash {
    private HashMap<String, Integer> wordMap;

    // WordHash(): Konstruktør som lager en tom hashtabell
    public WordHash() {
        wordMap = new HashMap<>();
    }

    // size(): Antall ord som er lagret i hashtabellen
    public int size() {
        return wordMap.size();
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord) {
        wordMap.put(ord, wordMap.getOrDefault(ord, 0) + 1);
    }

    // search(): Søk etter et ord. Skriv ut ordet og ordfrekvensen hvis det finnes i hashtabellen.
    public void search(String ord) {
        if (wordMap.containsKey(ord)) {
            System.out.println(ord + ": " + wordMap.get(ord));
        } else {
            System.out.println("Word not found");
        }
    }

    // print(): Skriv ut alle ord og ordfrekvenser i hashtabellen i alfabetisk sortert rekkefølge
    public void print() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(wordMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // main(): Testprogram
    public static void main(String[] args) {
        // Leser filnavn fra bruker
        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String fileName = scan.next();

        // Oppretter ordleser og tom hashtabell
        WordReader wR = new WordReader(fileName);
        WordHash wHash = new WordHash();

        // Leser alle ordene på filen og legger inn i hashtabellen
        String ord = wR.nextWord();
        while (ord != null) {
            wHash.insert(ord);
            ord = wR.nextWord();
        }
        // Skriver ut antall ulike ord som fantes i filen
        System.out.println(wHash.size() + " unique words " +
                "read from file " + fileName);

        // Menyvalg for å teste programmet
        int valg = 0;
        while (valg != 3) {
            System.out.print("\n1:Search, 2:Print, 3:Quit ? ");
            valg = scan.nextInt();
            if (valg == 1) {
                System.out.print("Search for? ");
                ord = scan.next();
                wHash.search(ord.toLowerCase());
            } else if (valg == 2) {
                wHash.print();
            }
        }
        scan.close();
    }
}