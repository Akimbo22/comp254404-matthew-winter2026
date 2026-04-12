// Matthew Elliott - 301424215
// April 12th, 2026
// Lab 7 - Exercise 2

// Citation:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
import ex2Resources.LinkedQueue;

// First method is an edit of the merge method from the MergeSort class. It now uses a queue rather than
// an array

public static LinkedQueue<Integer> merge(LinkedQueue<Integer> queue1, LinkedQueue<Integer> queue2)
{
    LinkedQueue<Integer> mergedQueue = new LinkedQueue<>();
    if(!queue1.isEmpty() && !queue2.isEmpty()) {
        if(queue1.first() > queue2.first()) // Checks the values of the queues' first value
        {
            for(int i=0;i<queue2.size();i++)
            {
                // My logic is that you would check first to see which queue has a larger
                // value, then add the smaller value to the larger one, as you would want
                // the smaller value at the bottom so it would be printed bottom-up
                queue1.enqueue(queue2.dequeue());
                System.out.println(queue1.first());
            }
        }
        else if(queue2.first() > queue1.first())
        {
            for(int i=0;i<queue1.size();i++)
            {
                queue2.enqueue(queue1.dequeue());
                System.out.println(queue2.first());
            }
        }

    }
    return mergedQueue;
}

// Next, is my method, which will actually do the bottom-up merge sort
public static LinkedQueue<Integer> bottomUpMergeSort(LinkedQueue<Integer> queue)
{
    LinkedQueue<Integer> finalQueue = new LinkedQueue<>();
    LinkedQueue<LinkedQueue<Integer>> masterQueue = new LinkedQueue<>();
    for(int i=0;i< queue.size();)
    {
        LinkedQueue<Integer> subQueue = new LinkedQueue<>();
        subQueue.enqueue(queue.dequeue()); // The value from the initial queue is added to the sub-queue
        masterQueue.enqueue(subQueue); // The sub-queue is then added to the master queue
    }

    for(int i=1;i< masterQueue.size();) // Ensures the master queue has 2 queues to merge
    {
        System.out.println("Test");
        LinkedQueue<Integer> mergedQueue = new LinkedQueue<>();
        LinkedQueue<Integer> queue1 = masterQueue.dequeue();
        LinkedQueue<Integer> queue2 = masterQueue.dequeue(); // The queues are dequeued from the master queue
        mergedQueue = merge(queue1, queue2);
        masterQueue.enqueue(mergedQueue); // Adds the merged queue to the master queue to be merged again
        finalQueue = masterQueue.first(); // Sends the merged elements to the finalQueue
    }
    return finalQueue;
}

void main() {
    // Creating and filling a new queue
    LinkedQueue<Integer> queue = new LinkedQueue<>();
    queue.enqueue(1);
    queue.enqueue(10);
    queue.enqueue(3);
    queue.enqueue(9);
    queue.enqueue(7);
    queue = bottomUpMergeSort(queue);
    for(int i=0;i<queue.size();i++)
    {
        System.out.println("TEst");
        System.out.println(queue.dequeue());
    }
}