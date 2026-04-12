package ex1;
// Matthew Elliott - 301424215
// April 12th, 2026
// Lab 7 - Exercise 1

// Citation:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
import resources.TreeMap;
import resources.AbstractMap;
import resources.Entry;
import resources.Position;

public class ex1<K,V> extends TreeMap<K,V> {

    // I've updated the treeSearch method to loop rather than use recursion.
    // However, I seem to have encountered an issue while doing so, as it doesn't quite read through the
    // Tree correctly. If I can fix it, this comment will be removed

    // Here is the edited method:
//    private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key, TreeMap<K,V> map) {
//
//        // Loops through the key set of the map to find the key
//        for(K keys : map.keySet())
//        {
//            if(key==keys) // If the searched key is equal to one of the keys, the key was found
//            {
//                System.out.println("Key found!");
//                return p;
//            }
//        }
//        // Should the loop finish looping without finding the key, it was not found
//        System.out.println("Key not found");
//        return p;
//    }


    public static void main(String[] args) {
        // Creating the initial tree to be loop searched:
        TreeMap<Integer, String> loopMap = new TreeMap<>();
        // Filling the Tree Map:
        loopMap.put(8, "A", loopMap);
        loopMap.put(21, "B", loopMap);
        loopMap.put(15, "C", loopMap);
        loopMap.put(4, "D", loopMap);
        loopMap.put(92, "E", loopMap);
        for(int keys : loopMap.keySet())
        {
            System.out.println(keys); // Testing keySet() as I can't seem to get the keys to be read for some reason
        }
        for(String value : loopMap.values())
        {
            System.out.println(value); // Also testing a loop for the values
        }
        System.out.println();
        System.out.println("Searching for Key 8: " + loopMap.get(8, loopMap)); // First trying a key we know is in the tree
        System.out.println("Searching for Key 17: " + loopMap.get(17, loopMap)); // Then, searching for a key we know is not in the tree
    }
}
