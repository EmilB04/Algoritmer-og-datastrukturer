package emilbe;

public class OppgaveA {
    // tell(): Returnerer antall forekomster av "verdi" i det
    // heap-ordnede treet med rot i "rot".
    public static int tell(Node rot, int verdi) {
        // Hvis roten er null, returner 0
        if (rot == null) {
            return 0;
        }

        // Hvis roten er lik "verdi", returner 1 + tell() for venstre og høyre barn
        if (rot.verdi == verdi) {
            return 1 + tell(rot.venstre, verdi) + tell(rot.høyre, verdi);
        }

        // Hvis roten ikke er lik "verdi", returner tell() for venstre og høyre barn
        return tell(rot.venstre, verdi) + tell(rot.høyre, verdi);
    }




    // main(): Testprogram
    public static void main(String argv[]) {
        // Lager treet som er gitt i figur 1 i oppgaveteksten
        Node rot = new Node(1,
                new Node(2,
                        new Node(17,
                                new Node(25, null, null),
                                new Node(19, null, null)),
                        null),
                new Node(17, null,
                        new Node(36, null, null)));

        // Tester metoden tell() for noen verdier
        System.out.println("tell(2)  = " + tell(rot, 2));
        System.out.println("tell(17) = " + tell(rot, 17));
        System.out.println("tell(25) = " + tell(rot, 25));
        System.out.println("tell(50) = " + tell(rot, 50));
    }
}
