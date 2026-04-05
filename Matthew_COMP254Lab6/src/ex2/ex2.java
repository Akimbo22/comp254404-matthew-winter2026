// Matthew Elliott - 301424215
// April 4th, 2026
// Lab 6 - Exercise 2

// Citation:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

import maps.SortedTableMap;
import java.util.Map;
import java.util.Random;

void main() {
    Random random = new Random();

    SortedTableMap<Integer, Integer> sortedMap = new SortedTableMap<>();
    // A first loop fills the map
    for(int i=0;i<10;i++)
    {
        int value = random.nextInt(1,25);
        sortedMap.put(i,value); // Filling entries 0-9 with random values between 1-25
    }
    System.out.println(sortedMap.entrySet()); // Showing filled entry set

    // The second loop checks if each entry is valid. This includes a final entry, which should return false
    for(int i=0;i<=10;i++)
    {
        // The containKey() method has been edited in SortedTabelMap.java
        // It now uses findIndex() and returns true/false depending on if the key
        // is valid
        if(sortedMap.containKey(i))
        {
            // if the key is valid, prints true and the value
            System.out.println("Contains key " + i + ": " + sortedMap.containKey(i));
            System.out.println("\nValue of key: " + sortedMap.get(i) + "\n");
        }
        else
        {
            // if the key is invalid, prints false
            System.out.println("Contains key " + i + ": " + sortedMap.containKey(i));
        }
    }

    //Final check deletes a key, then checks for it to ensure that it is false
    sortedMap.remove(9);
    System.out.println("Key 9 has been removed and should return false now: " + sortedMap.containKey(9));

}

// New containKey() syntax, for review:
//public boolean containKey(K key)
//{
//    int keyCheck = findIndex(key);
//    if(keyCheck == (table.size())) {
//        return false;
//    }
//    else {
//        return true;
//    }
//}