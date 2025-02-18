package emilbe;

import java.util.LinkedList;
import java.util.Queue;

class Trenode {
    int verdi;
    Trenode venstre, hoyre;
    int sum;
    Trenode forelder;

    public Trenode(int verdi, Trenode venstre, Trenode hoyre) {
        this.verdi = verdi;
        this.venstre = venstre;
        this.hoyre = hoyre;
        sum = 0;
        forelder = null;
    }
}

public class Oblig_05 {
    // Oppgave 1
    static void settSum(Trenode rot) {
        if (rot == null) {
            return;
        }
        settSum(rot.venstre);
        settSum(rot.hoyre);
        int venstreSum = (rot.venstre != null) ? rot.venstre.sum : 0;
        int hoyreSum = (rot.hoyre != null) ? rot.hoyre.sum : 0;
        rot.sum = rot.verdi + venstreSum + hoyreSum;
    }

    // Oppgave 2
    static void settForelder(Trenode rot) {
        if (rot == null) {
            return;
        }
        if (rot.venstre != null) {
            rot.venstre.forelder = rot;
            settForelder(rot.venstre);
        }
        if (rot.hoyre != null) {
            rot.hoyre.forelder = rot;
            settForelder(rot.hoyre);
        }
    }

    // Oppgave 3
    static void skrivUt(Trenode rot) {
        if (rot == null) {
            return;
        }
        Queue<Trenode> queue = new LinkedList<>();
        queue.add(rot);
        while (!queue.isEmpty()) {
            Trenode current = queue.poll();
            System.out.printf("%-6d %-6d %-6s%n", current.verdi, current.sum, (current.forelder != null ? current.forelder.verdi : "*"));
            if (current.venstre != null) {
                queue.add(current.venstre);
            }
            if (current.hoyre != null) {
                queue.add(current.hoyre);
            }
        }
    }

    // Testprogram
    public static void main(String args[]) {
        System.out.printf("%-6s %-6s %-6s%n", "Verdi", "Sum", "Forelder");
        Trenode rot = 
            new Trenode(8,
                new Trenode(4,
                        new Trenode(2, null, null),
                        new Trenode(6, null, null)),
                new Trenode(16,
                        new Trenode(14,
                                new Trenode(12, null, null),
                                new Trenode(15, null, null)),
                        new Trenode(18, null,
                                new Trenode(20, null, null))));

        settSum(rot);
        settForelder(rot);
        skrivUt(rot);
    }
}