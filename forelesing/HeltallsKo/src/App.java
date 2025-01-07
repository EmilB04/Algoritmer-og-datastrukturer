public class App {
    public static void main(String[] args) throws Exception {
        IntQueue queue = new IntQueue(4);
        queue.enqueue(1);
        queue.printQueue();
        queue.enqueue(2);
        queue.printQueue();
        queue.enqueue(3);
        queue.printQueue();
        queue.enqueue(4);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.printQueue();
    }

    public static class IntQueue {
        private int front, rear, count;
        public int queue[];
    
        public IntQueue(int length) {
            front = rear = count = 0;
            queue = new int[length];
        }
    
        public IntQueue(){
            front = rear = count = 0;
            queue = new int[100];
        }
    
        public void enqueue(int value) {
            queue[rear] = value;
            rear = (rear + 1) % queue.length;
            count++;
        }
    
        public int dequeue() {
            int result = queue[front];
            front = (front + 1) % queue.length;
            count--;
            return result;
        }
    
        public int first() {
            return (queue[front]);
        }
    
        public boolean isEmpty() {
            return (count == 0);
        }
    
        public int size() {
            return count;
        }
        public void printQueue(){
            for (int i = 0; i < queue.length; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

// Enkel implementasjon av kø¸ med sirkulærr heltallsarray, uten
// feilsjekking...