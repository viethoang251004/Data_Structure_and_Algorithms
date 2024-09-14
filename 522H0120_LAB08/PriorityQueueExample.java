import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>();

        // Enqueue
        priorityQueue.offer(new Person("Alex", 3));
        priorityQueue.offer(new Person("Bob", 2));
        priorityQueue.offer(new Person("David", 6));
        priorityQueue.offer(new Person("Susan", 1));

        // Dequeue
        Person dequeuedPerson1 = priorityQueue.poll();
        Person dequeuedPerson2 = priorityQueue.poll();

        // Enqueue
        priorityQueue.offer(new Person("Mike", 5));
        priorityQueue.offer(new Person("Kevin", 4));

        // Dequeue
        Person dequeuedPerson3 = priorityQueue.poll();

        // Enqueue
        priorityQueue.offer(new Person("Helen", 0));
        priorityQueue.offer(new Person("Paul", 8));
        priorityQueue.offer(new Person("Iris", 7));

        // Dequeue
        Person dequeuedPerson4 = priorityQueue.poll();

        // Show the result of dequeuing four persons
        System.out.println("Dequeued Person 1: " + dequeuedPerson1.getName());
        System.out.println("Dequeued Person 2: " + dequeuedPerson2.getName());
        System.out.println("Dequeued Person 3: " + dequeuedPerson3.getName());
        System.out.println("Dequeued Person 4: " + dequeuedPerson4.getName());
    }
}