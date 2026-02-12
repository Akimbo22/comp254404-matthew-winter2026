import linkedlists.CircularlyLinkedList;
// Matthew Elliott - 30142415
// January 29th, 2026
// Lab 1 - Exercise 3

// Here, I'm trying to fix the issues I had with Exercise 3.
// Since it's past the due date, this is just for my own practice.

public void cloneList(CircularlyLinkedList original)
{
    // Creating the new list:
    CircularlyLinkedList<String> newList = new CircularlyLinkedList<>();

    // Filling the contents of the "cloned" list
    int size = original.size();
    newList.addFirst(original.first().toString());
    for(int i = 1; i < size; i++) {
        original.rotate();
        newList.addLast(original.first().toString());
    }
    System.out.println(newList);
}

public void main(String[] args) {
    // Creating a Circularly Linked List
    CircularlyLinkedList<String> originalList = new CircularlyLinkedList<>();
    originalList.addFirst("My");
    originalList.addLast("List");
    originalList.addLast("Will");
    originalList.addLast("NEVER");
    originalList.addLast("Be");
    originalList.addLast("Cloned!!!");
    System.out.println(originalList);

    // Cloning the linked list
    cloneList(originalList);

}