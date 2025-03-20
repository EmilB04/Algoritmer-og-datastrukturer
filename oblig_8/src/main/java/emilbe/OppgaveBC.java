package emilbe;

import java.util.Queue;
import java.util.LinkedList;

public class OppgaveBC {
    // Oppgave B
    public static void reparer(Node rot) {
        if (rot == null) {
            return;
        }
        
        Node current = rot;

        while (current != null) {
            Node smallest = current;

            if (current.venstre != null && current.venstre.verdi < smallest.verdi) {
                smallest = current.venstre;
            }

            if (current.høyre != null && current.høyre.verdi < smallest.verdi) {
                smallest = current.høyre;
            }

            if (smallest != current) {
                int temp = current.verdi;
                current.verdi = smallest.verdi;
                smallest.verdi = temp;
                current = smallest;
            } else {
                break;
            }
        }
    }

    // Oppgave C
    public static void lagHeapOrdning(Node rot) {
        if (rot == null) {
            return;
        }
        // Rekursivt reparer venstre og høyre subtre
        lagHeapOrdning(rot.venstre);
        lagHeapOrdning(rot.høyre);
        // Reparer den nåværende noden
        reparer(rot);
    }

    // Nivå for nivå utskrift, for testing
    public static void print(Node rot)
    {
        if (rot == null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        int n_nivå = 1, n_print = 0, n_neste = 0;
        q.add(rot);
        while (!q.isEmpty())
        {
            Node denne = q.remove();
            if (denne.venstre != null) {
                q.add(denne.venstre);
                n_neste++;
            }

            if (denne.høyre != null){
                q.add(denne.høyre);
                n_neste++;
            }
            System.out.print(denne.verdi + " ");
            // Triks for å skrive ut hvert nivå på en egen linje
            if (++n_print == n_nivå)
            {
                System.out.println();
                n_print = 0;
                n_nivå = n_neste;
                n_neste = 0;
            }
        }
        if (n_print != 0)
            System.out.println();
        System.out.println();
    }

    // Testprogram
    public static void main(String argv[]) {
        // Lager og og skriver ut treet i figur 3 i oppgaveteksten:
        Node rot = new Node(36,
                new Node(19,
                        new Node(17,
                                new Node(25, null, null),
                                new Node(2, null, null)),
                        new Node(7, null, null)),
                new Node(25,
                        new Node(1, null, null),
                        new Node(3, null, null)));
        print(rot);
        // Gjør om treet til et heap-ordnet tre og skriver ut
        lagHeapOrdning(rot);
        print(rot);
    }
}