package emilbe;

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
        if (rot == null)
            return;
        rot.sum = rot.verdi + (rot.venstre != null ? rot.venstre.sum : 0) + (rot.hoyre != null ? rot.hoyre.sum : 0);
        settSum(rot.venstre);
        settSum(rot.hoyre);
    }

    // Oppgave 2
    static void settForelder(Trenode rot) {
        if (rot == null)
            return;
        if (rot.venstre != null)
            rot.venstre.forelder = rot;
        if (rot.hoyre != null)
            rot.hoyre.forelder = rot;
        settForelder(rot.venstre);
        settForelder(rot.hoyre);
    }

    // Oppgave 3
    static void skrivUt(Trenode rot) {
        if (rot == null)
            return;
        skrivUt(rot.venstre);
        System.out.println("Verdi: " + rot.verdi + ", Sum: " + rot.sum + ", Forelder: "
                + (rot.forelder != null ? rot.forelder.verdi : "null"));
        skrivUt(rot.hoyre);
    }

    // Testprogram
    public static void main(String args[]) {
        Trenode rot = new Trenode(8,
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