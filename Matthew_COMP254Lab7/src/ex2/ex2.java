// Matthew Elliott - 301424215
// April 12th, 2026
// Lab 7 - Exercise 2

// Citation:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
import ex2Resources.LinkedQueue;

// First method is an edit of the merge method from the MergeSort class. I've pretty much changed it
// Completely now. It takes two queues, checks the size of each queue's first value, then to get a bottom-up sort,
// The queue with the smaller value is added onto the queue with the larger first value. It's not a perfect set-up,
// But it should work

// Based on the queue I made in main(), this should have to run 4 times
public static LinkedQueue<Integer> merge(LinkedQueue<Integer> queue1, LinkedQueue<Integer> queue2)
{
    LinkedQueue<Integer> mergedQueue = new LinkedQueue<>();
    if(!queue1.isEmpty() && !queue2.isEmpty()) {
        if(queue1.first() > queue2.first()) // Checks the values of the queues' first value
        {
            for(int i=0;i<queue2.size();)
            {
                // My logic is that you would check first to see which queue has a larger
                // value, then add the smaller value to the larger one, as you would want
                // the smaller value at the bottom so it would be printed bottom-up
                queue1.enqueue(queue2.dequeue());
                System.out.println(queue1.first() + " Queue 1 Test");
            }
        }
        else if(queue2.first() > queue1.first())
        {
            for(int i=0;i<queue1.size();)
            {
                queue2.enqueue(queue1.dequeue());
                System.out.println(queue2.first() + " Queue 2 Test");
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
    for(int i=0;i< queue.size();) // Based on the main(), this should run 5 times
    {
        System.out.println("Sub Queue Merge Test");
        LinkedQueue<Integer> subQueue = new LinkedQueue<>();
        subQueue.enqueue(queue.dequeue()); // The value from the initial queue is added to the sub-queue
        masterQueue.enqueue(subQueue); // The sub-queue is then added to the master queue
    }

    for(int i=1;i< masterQueue.size();) // Ensures the master queue has 2 queues to merge
    {
        System.out.println("Merge Queues Test");
        LinkedQueue<Integer> mergedQueue = new LinkedQueue<>();
        LinkedQueue<Integer> queue1 = masterQueue.dequeue();
        LinkedQueue<Integer> queue2 = masterQueue.dequeue(); // The queues are dequeued from the master queue
        mergedQueue = merge(queue1, queue2);
        masterQueue.enqueue(mergedQueue); // Adds the merged queue to the master queue to be merged again
//        finalQueue = masterQueue.dequeue(); // Sends the merged elements to the finalQueue
//        System.out.println("Merged Size: " + finalQueue.size()); // Testing purposes, I am printing the final size
    }
    finalQueue = masterQueue.dequeue(); // Sends the merged elements to the finalQueue
    System.out.println("Merged Size: " + finalQueue.size()); // Testing purposes, I am printing the final size

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
    System.out.println("Size: " + queue.size()); // For testing purposes, I'm printing the size
    queue = bottomUpMergeSort(queue);
    for(int i=0;i<queue.size();)
    {
        System.out.println("Main Loop Test");
        System.out.println(queue.dequeue());
    }
}