package ex3;
// Matthew Elliott - 301424215
// March 28th, 2026
// Lab 5 - Exercise 3

import heapsAndPriorityQueues.Entry;
import heapsAndPriorityQueues.HeapPriorityQueue;
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

public class ex3<K,V> extends HeapPriorityQueue<K,V> {
    // Declaring the altered recursion upheap algorithm
    @Override
    protected int upheap(int j) {
        if(j <= 0)
        {
            return 0; // Recursively upheaps until j is 0 or less
        }
        int p = parent(j);
        swap(j, p);
        j = p;
        return upheap(j); // Calling the method recursively
    }

    // Declaring an override of the insert method too. Nothing is changed, I just want to ensure that it calls my overridden upheap
    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);      // auxiliary key-checking method (could throw exception)
        Entry<K,V> newest = new PQEntry<>(key, value);
        heap.add(newest);                      // add to the end of the list
        upheap(heap.size() - 1);               // upheap newly added entry
        return newest;
    }

    public static void main(String[] args) {
        HeapPriorityQueue<String, String> recursionHeap = new HeapPriorityQueue<String, String>();

        // Filling the heap with unsorted values
        recursionHeap.insert("5", "World");
        recursionHeap.insert("3", "Hello");
        recursionHeap.insert("9", "I hope my key doesn't get swapped");
        recursionHeap.insert("1", "Goodbye!");
        recursionHeap.insert("10", "I want to be first");

        // After
        for (int i=0;i < recursionHeap.size();i++)
            System.out.println("(" +recursionHeap.heap.get(i).getKey() +
                    ", " + recursionHeap.heap.get(i).getValue() + ")" );
    }
}