// Matthew Elliott - 30142415
// March 18th, 2026
// Lab 4 - Exercise 3
import lists.LinkedQueue;
// IMPORTANT NOTE:
// As the instructions stated, I edited the SinglyLinkedList class. This is why it is now
// called LinkedQueue and has Queue-related methods

public LinkedQueue<String> concatenate(LinkedQueue<String> Q2)
{
    // Creating the Q1 queue to be filled with Q2's elements
    LinkedQueue<String> Q1 = new LinkedQueue<>();
    // Adding some initial elements to Q1:
    Q1.enqueue("Q1 is so cool.");
    Q1.enqueue("Imagine if 3 more strings conveniently filled this queue");
    // Showing initial size of Q1
    System.out.println("Q1 size before emptying Q2: " + Q1.size());

    try{
        int q2Counter = Q2.size();
        for(int i=0;i<q2Counter;i++)
        {
            // Adding each Q2 element to Q1 by using dequeue. Which removes the element from Q2
            Q1.enqueue(Q2.dequeue());
        }
        // Showing the new size of Q1:
        System.out.println("Q1 size after emptying Q2: " + Q1.size());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    return Q2;
}

void main() {
    // Creating the initial Q2 queue, which will be emptied to fill Q1
    LinkedQueue<String> Q2 = new LinkedQueue<>();
    Q2.enqueue("Hello!");
    Q2.enqueue("My Name is Matthew!");
    Q2.enqueue("Sometimes I... dream about cheese.");

    // isEmpty() check before method
    System.out.println("Before running concatenate: Q2.isEmpty(): " + Q2.isEmpty());

    Q2 = concatenate(Q2);
    // isEmpty() check AFTER method
    System.out.println("After running concatenate: Q2.isEmpty(): " + Q2.isEmpty());
}