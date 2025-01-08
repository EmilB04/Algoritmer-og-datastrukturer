package emilbe;

import java.util.*;

public class Oblig_01 {
    public static String ROT13(String S) {
        char[] C = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            char c = C[i];
            if (c >= 'a' && c <= 'm')
                c += 13;
            else if (c >= 'A' && c <= 'M')
                c += 13;
            else if (c >= 'n' && c <= 'z')
                c -= 13;
            else if (c >= 'N' && c <= 'Z')
                c -= 13;
            C[i] = c;
        }
        return String.valueOf(C);
    }

    public static String krypter(String S) {    
        // Variabel for å lagre resultatet av ROT13 på 
        String S1 = ROT13(S);

        // Opprett en kø og en stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enque de n/2 første tegnene i S1
        int middle = S1.length() / 2;
        for (int i = 0; i < middle; i++) {
            queue.add(S1.charAt(i));
        }
        // Legg resterende av tegnene i S1 på stacken
        for (int i = middle; i < S1.length(); i++) {
            stack.push(S1.charAt(i));
        }
        // Bygg den krypterte strengen T
        StringBuilder T = new StringBuilder();
        while (!stack.isEmpty() || !queue.isEmpty()) {
            if (!stack.isEmpty()) {
                T.append(stack.pop());
            }
            if (!queue.isEmpty()) {
                T.append(queue.remove());
            }
        }
        return T.toString(); 
    }
    public static String dekrypter(String S) {
        // Opprett en kø og en stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

    
        return S;
        // return ROT13(T.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Write some text you want to encrypt: ");
        String text = in.nextLine();
        in.close();

        // Encrypt the text
        System.out.println(krypter(text));

        // Decrypt the text
    }
}