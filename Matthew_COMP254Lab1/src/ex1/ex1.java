import linkedlists.DoublyLinkedList;

// Matthew Elliott - 30142415
// January 27th, 2026
// Lab 1 - Exercise 1

public void concatLists(DoublyLinkedList l, DoublyLinkedList m) {
    // Creates a new list to populate
    DoublyLinkedList<String> concatList = new DoublyLinkedList<>();

    // Loops through the elements of the other two lists
    int i;
    for(i=0; i < m.size();)
    {
        String mString = m.first().toString();
        String lString = l.first().toString();
        concatList.addLast(lString);
        concatList.addLast(mString);
        m.removeFirst();
        l.removeFirst();
    }
    // Finally, prints the new list
    System.out.println(concatList);
}

public void main(String[] args) {
    // Creating the two lists and adding some elements
    DoublyLinkedList<String> l = new DoublyLinkedList<>();
    l.addFirst("Hello");
    l.addLast("My");
    l.addLast("is");
    System.out.println(l);

    DoublyLinkedList<String> m = new DoublyLinkedList<>();
    m.addFirst("professor!");
    m.addLast("name");
    m.addLast("Matthew!");
    System.out.println(m);

    // Calls the new concatenation method
    concatLists(l, m);
}