import java.io.*;
import java.util.*;

/* Tidssdrevet simulering av aktiviteten pÃ¥ et postkontor:
 *
 * - Alle kundene som ankommer stiller seg i en og samme kundekÃ¸
 * - Det kommer maksimalt Ã©n ny kunde per tidsenhet, sannsynligheten
 *   for kundeankomst er den samme i alle tidsteg
 * - Det er et fast antall kasser/betjeningsluker
 * - Det er en Ã¸vre grense for betjeningstiden for en kunde
 * - Brukes Javas egen innebygde kÃ¸ 
 */

public class Postkontor {
    int antKasser; // Antall åpne kasser/betjeningsluker
    int maksBetTid; // Maksimal betjeningstid for en kunde
    int maksTid; // Antall tidssteg som simuleringen skal gå
    float P_kunde; // Sannsynligheten for kundeankomst i hvert tidssteg

    // KonstruktÃ¸r som leser data/parametre for simuleringen
    public Postkontor(String navn) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velkommen til " + navn + " postkontor");
        System.out.print("Antall tidsteg?: ");
        maksTid = scanner.nextInt();
        System.out.print("Antall kasser?: ");
        antKasser = scanner.nextInt();
        System.out.print("Lengste betjeningstid?: ");
        maksBetTid = scanner.nextInt();
        System.out.print("Gj.snittlig antall kundeankomster per tidsenhet? (< 1.0): ");
        P_kunde = scanner.nextFloat();
        scanner.close();
    }

    // Indre klasse som lagrer ankomsttiden for en kunde
    private class kunde {
        private int ankomst;

        public kunde(int ankomst) {
            this.ankomst = ankomst;
        }

        public int venteTid(int tid) {
            return tid - ankomst;
        }
    }

    // Indre klasse som lagrer tidspunktet nÃ¥r en kasse blir ledig
    private class kasse {
        private int tidFerdigKunde;

        public kasse() {
            tidFerdigKunde = 0;
        }

        public void settTidFerdigKunde(int tid) {
            tidFerdigKunde = tid;
        }

        public boolean erLedig(int tid) {
            return tid >= tidFerdigKunde;
        }
    }

    // Metode som gjÃ¸r selve kÃ¸simuleringen
    public void simuler() {
        // Variable for Ã¥ samle opp data underveis i simuleringen
        //
        int totalBetTid = 0; // Sum betjeningstid for alle betjente kunder
        int totalVenteTid = 0; // Sum ventetid for alle betjente kunder
        int totAntKunder = 0; // Totalt antall kunder betjent
        int totAntledig = 0; // Totalt antall ganger en kasse var ledig

        // Lager en ny, tom KundeKÃ¸
        Queue<kunde> KundeKø = new LinkedList<kunde>();

        // Oppretter en array som lagrer alle Ã¥pne kasser
        kasse[] kasser = new kasse[antKasser];

        // Setter alle kassene til Ã¥ vÃ¦re ledige
        for (int i = 0; i < antKasser; i++)
            kasser[i] = new kasse();

        // Initierer trekkingen av tilfeldige tall
        Random R = new Random();

        // Simulerer et og et tidssteg
        for (int tid = 0; tid < maksTid; tid++) {
            // Trekker nytt tilfeldig tall. Hvis tallet som trekkes er
            // mindre enn sannsynligheten for ny kunde (P_kunde),
            // settes en ny kunde inn i kÃ¸en
            if (R.nextDouble() < P_kunde)
                KundeKø.add(new kunde(tid));

            // Tar ut Ã©n kunde fra kÃ¸en for hver ledige kasse
            for (int i = 0; i < antKasser; i++)
                if (kasser[i].erLedig(tid)) {
                    if (!KundeKø.isEmpty()) {
                        // Trekk en tilfelding betjeningstid
                        int betTid = R.nextInt(maksBetTid) + 1;

                        // Tar ut kunde fra kÃ¸
                        kunde k = KundeKø.remove();

                        // Markerer at kassen er opptatt
                        kasser[i].settTidFerdigKunde(tid + betTid);

                        // Samler opp data fra dette tidssteget
                        totalBetTid += betTid;
                        totalVenteTid += k.venteTid(tid);
                        totAntKunder++;
                    } else
                        // KÃ¸en er tom og vi har en ledig kasse
                        totAntledig++;
                }
        }

        // Simulering ferdig, skriv ut litt statistikk

        System.out.println("\nPostkontoret er nÃ¥ stengt");
        System.out.println("Antall kunder behandlet: " + totAntKunder);
        System.out.println("Antall kunder i kø: " + KundeKø.size());
        if (totAntKunder > 0) {
            System.out.println("Gjennomsnittlig betjeningstid: " +
                    (float) totalBetTid / (float) totAntKunder);
            System.out.println("Gjennomsnittlig ventetid: " +
                    (float) totalVenteTid / (float) totAntKunder);

        }
        System.out.println("Gjennomsnittlig antall ledige kasser: " +
                (float) totAntledig / (float) maksTid);
    }

    // Testprogram
    public static void main(String[] args) {
        Postkontor pk = new Postkontor("Remmen");
        pk.simuler();
    }

}