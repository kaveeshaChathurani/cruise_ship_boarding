package TaskThree;
//https://www.programiz.com/dsa/circular-queue
//https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
//https://www.javainuse.com/java/circular_java
public class CQueue {
    int SIZE = 3; // Size of Circular Queue
    int front, rear;
    Passenger items[] = new Passenger[SIZE];

    CQueue() {
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    boolean isFull1() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Adding an element
    void enQueue(Passenger element) {
        if (isFull1()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Inserted " + element.getFirstName());
        }
    }

    // Removing an element
    Passenger deQueue() {
        Passenger Pa=new Passenger(null,null,0);
        Passenger element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Pa;
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

    void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {

            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print(items[i].getFirstName() + " ");
            System.out.println(items[i].getFirstName());

        }
    }
}
