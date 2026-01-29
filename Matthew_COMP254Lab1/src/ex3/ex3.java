import linkedlists.CircularlyLinkedList;
// Matthew Elliott - 30142415
// January 29th, 2026
// Lab 1 - Exercise 3

// I wasn't certain if we were meant to make the new method here or in the
// CircularlyLinkedList file. I made it there and called it here, so
// I apologize if that wasn't what I was meant to do
// I'll also post what I added there here as a comment:


// Based on the method in SinglyLinkedList.java but edited to support
// circularly linked lists
// NOTE: Currently does not function as intended. I'll also make a mention of this
// In the submission box. I don't get an error due to the script being wrong,
// I'm getting an OutOfMemory exception
/*
// Based on the method in SinglyLinkedList.java but edited to support
    // circularly linked lists
  @SuppressWarnings({"unchecked"})
  public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
      CircularlyLinkedList<E> cloned = (CircularlyLinkedList<E>) super.clone();
      if (size > 0) {
          cloned.tail = new Node<>(tail.getElement(), null);
          Node<E> walk = tail.getNext(); // Going through the list
          Node<E> newTail = cloned.tail; // Getting the newest node
          while (walk != null) {
              for (int i = 0; i < size; i++) { // stop looping once full list is cloned
                  Node<E> newest = new Node<>(walk.getElement(), null);
                  newTail.setNext(newest);
                  newTail = newest;
                  walk = walk.getNext();
              }
          }
      }
      return cloned;
  }
 */


public void main(String[] args) throws CloneNotSupportedException {
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
    CircularlyLinkedList<String> clonedList = originalList.clone();
    System.out.println(clonedList);
    System.out.println("test");

}