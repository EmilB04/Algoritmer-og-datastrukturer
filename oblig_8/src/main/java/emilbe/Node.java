package emilbe;

class Node {
    int verdi;    // Heltallsverdi
    Node venstre; // Venstre barn
    Node høyre;   // Høyre barn

    // Konstruktør
    public Node(int data, Node v, Node h) {
        verdi = data;
        venstre = v;
        høyre = h;
    }
}
