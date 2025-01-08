public class IntList {
	// Klassen inneholder fÃ¸lgende public-metoder:
	//
	// IntList - KonstruktÃ¸r
	// isEmpty - Sjekk om listen er tom
	// size - Antall elementer
	// addFirst - Sett inn fÃ¸rst
	// addLast - Sett inn sist
	// addAfter - Sett inn etter et element med en gitt verdi
	// getFirst - Returner fÃ¸rste verdi
	// getLast - Returner siste verdi
	// contains - SÃ¸k etter en bestemt verdi
	// removeFirst - Fjern fÃ¸rste element
	// removeLast - Fjern siste element
	// remove - Fjern et element med en gitt verdi
	// print - Skriv ut hele listen

	// Indre klasse for listenoder med heltallsdata
	private class ListNode {
		int data; // Verdien som er lagret i noden
		ListNode next; // Peker til neste element i listen

		// KonstruktÃ¸r for listenode
		public ListNode(int data) {
			this.data = data;
			next = null;
		}
	}

	private ListNode head; // Peker til fÃ¸rste element i listen
	private int size; // Antall elementer i listen

	// KonstruktÃ¸r for listen, lager en tom liste
	public IntList() {
		head = null;
		size = 0;
	}

	// Tom liste?
	public boolean isEmpty() {
		return (size == 0);
	}

	// Returnerer antall elementer i listen
	public int size() {
		return size;
	}

	// Innsetting av ny verdi fÃ¸rst i listen
	public void addFirst(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
		size++;
	}

	// Innsetting av ny verdi sist i listen
	public void addLast(int data) {
		ListNode newNode = new ListNode(data);
		if (isEmpty())
			head = newNode;
		else {
			ListNode current = head;
			while (current.next != null)
				current = current.next;
			current.next = newNode;
		}
		size++;
	}

	// Innsetting etter en bestemt verdi i listen
	// Returnerer false hvis verdien ikke finnes, true ellers
	public boolean addAfter(int target, int data) {
		ListNode current = head;
		while (current != null) {
			if (current.data == target) {
				ListNode newNode = new ListNode(data);
				newNode.next = current.next;
				current.next = newNode;
				size++;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returnerer fÃ¸rste verdi i listen
	// Terminerer med feilmelding hvis listen er tom
	public int getFirst() {
		if (isEmpty()) {
			System.out.println("Feil: Listen er tom");
			System.exit(1);
		}
		return head.data;
	}

	// Returnerer siste verdi i listen
	// Terminerer med feilmelding hvis listen er tom
	public int getLast() {
		if (isEmpty()) {
			System.out.println("Feil: Listen er tom");
			System.exit(1);
		}
		ListNode current = head;
		while (current.next != null)
			current = current.next;
		return current.data;
	}

	// SÃ¸k etter en verdi i listen
	// Returnerer true hvis funnet, false ellers
	public boolean contains(int data) {
		ListNode current = head;
		while (current != null) {
			if (current.data == data)
				return true;
			current = current.next;
		}
		return false;
	}

	// Fjerning av fÃ¸rste element i listen
	// Terminerer med feilmelding hvis listen er tom
	public int removeFirst() {
		if (isEmpty()) {
			System.out.println("Feil: Listen er tom");
			System.exit(1);
		}
		int data = head.data;
		head = head.next;
		size--;
		return data;
	}

	// Fjerning av siste element i listen
	// Terminerer med feilmelding hvis listen er tom
	public int removeLast() {
		if (isEmpty()) {
			System.out.println("Feil: Listen er tom");
			System.exit(1);
		}
		if (head.next == null) {
			int data = head.data;
			head = null;
			size--;
			return data;
		}
		ListNode previous = head, current = head.next;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		int data = current.data;
		previous.next = null;
		size--;
		return data;
	}

	// Fjerning av en bestemt verdi fra listen
	// Returnerer false hvis verdien ikke finnes i listen, true ellers
	public boolean remove(int data) {
		if (isEmpty())
			return false;
		if (head.data == data) {
			head = head.next;
			size--;
			return true;
		}
		ListNode previous = head, current = head.next;
		while (current != null) {
			if (current.data == data) {
				previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	// Skriver ut listen
	public void print() {
		ListNode current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}