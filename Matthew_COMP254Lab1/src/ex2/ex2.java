import linkedlists.SinglyLinkedList;

// Matthew Elliott - 30142415
// January 27th, 2026
// Lab 1 - Exercise 2

// Creating the method to flip nodes
public void swapNodes(SinglyLinkedList flip) {
    // Checks if strings are the same or if the list is empty
    if((flip.first() == flip.last()) || (flip.isEmpty())){
        throw new RuntimeException("Both nodes are the same, or you have an empty list!");
    }
    else{
        flip.addLast(flip.first());
        flip.removeFirst();
        System.out.println(flip);
    }
}

public void main(String[] args) {
    // Creates a singly linked list and creates elements for node 1 and 2
    SinglyLinkedList<String> flipList = new SinglyLinkedList<>();
    flipList.addFirst("I'm First?");
    flipList.addLast("I'm Second?");
    System.out.println(flipList);

    // Calls the swapNodes method
    swapNodes(flipList);
}