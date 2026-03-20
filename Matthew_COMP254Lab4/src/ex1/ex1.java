import lists.PositionalList;
import lists.DoublyLinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// Matthew Elliott - 301424215
// March 17th, 2026
// Lab 4 - Exercise 1

// Citing authors of PositionalList interface/DoublyLinkedList class
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser



    public int indexOf(DoublyLinkedList<String> cheeses, String cheese) {
        try {
            // Counter increases as we go through the loop
            int p = 0;
            int numCheese = cheeses.size();
            int i = 0;
            while (i < numCheese) {
                i++;
                if (!cheeses.first().toString().equals(cheese)) {
                    p++;
                    cheeses.removeFirst();
                }
            }

            return p;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

void main() {
        // I'll search for a type of cheese
        DoublyLinkedList<String> cheeses = new DoublyLinkedList<>();
        cheeses.addFirst("Cheddar");
        cheeses.addLast("Mozzarella");
        cheeses.addLast("Feta");
        cheeses.addLast("Cottage");
        cheeses.addLast("Blue");
        cheeses.addLast("Gouda");
        cheeses.addLast("Parmesan");

        // The cheese that we will search for is Blue Cheese
        String cheese = "Blue";

        if(!cheeses.isEmpty()) {
            int cheesePos = indexOf(cheeses, cheese); // We know Blue cheese is at position 4

            System.out.println(cheese + " Cheese found at position " + cheesePos + "!");
        }
}