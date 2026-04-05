//NOTE:
// This is my original (and broken) attempt at ex1. I am only keeping it in here
// So that I can keep in mind what I messed up and where for future reference


//package ex1;
//// Matthew Elliott - 301424215
//// April 4th, 2026
//// Lab 6 - Exercise 1
//
//// Citation:
//// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
//
//import maps.AbstractHashMap;
//import maps.ChainHashMap;
//import maps.Entry;
//import maps.UnsortedTableMap;
//
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//public class ex1Backup<K,V> extends AbstractHashMap<K,V> {
//    private UnsortedTableMap<K,V>[] table;
//
//    void main() {
//        // Essentially, to my understanding, we want to give the user complete control.
//        // Here, I will let the user decide the capacity, prime factor, and a custom load factor
//        // Then, the user will enter a key and a value for each entry
//        // Finally, each entry will be printed
//        long startTime = System.currentTimeMillis();
//        Random random = new Random();
//        Scanner scanner = new Scanner(System.in);
//        // First, we get the custom values:
//        System.out.println("Please enter the map capacity: ");
//        int custCap = scanner.nextInt();
//        int custPrime;
//        do {
//            System.out.println("\nNow, please enter the prime factor: ");
//            custPrime = scanner.nextInt();
//        }while(custPrime<=0 && (custPrime%2 == 0)); // Ensures that it is actually a prime number
//
//        System.out.println("\nFinally, enter a custom load factor: ");
//        int customLoad = scanner.nextInt();
//        // Now we create the map with the user entered capacity and prime factor
//        AbstractHashMap<Integer, String> customMap = new ChainHashMap<Integer, String>(custCap, custPrime);
//        for (int count = 1; count <= custCap; count++) { // We use a loop to fill the map
//            System.out.println("For entry: " + count);
//            // Getting the user key and values
//            System.out.println("\nEnter the key: ");
//            int key;
////            do{
////                key = scanner.nextInt();
////            }while(key<=0 && key>custCap);
//            key = random.nextInt(1,custCap); // Using a random number range to experiment on ChainHashMap
//
//            System.out.println("\nNow, enter the value: ");
//            String word = scanner.next();
//            // We add the key, value(word) to the map, using the custom load factor
//            customMap.put(key, word, customLoad);
//            System.out.println(customMap);
//        }
//        // Finally, we print the value
//        for (int keyCount = 1;keyCount<=custCap;keyCount++) {
//            String entryWord = customMap.get(keyCount);
//            System.out.println("\nFor Key: " + keyCount + "\nValue: " + entryWord);
//        }
//        for(String words : customMap.values()){
//            System.out.println(words);
//        }
//        // Two loops to test. I can only get a return of null, but for the life of me,
//        // I can't figure out why
//
//        long endTime = System.currentTimeMillis();
//        long finalTime = endTime-startTime; // For testing purposes, I'm tracking the time
//        System.out.println("\n\nFinal time in milliseconds: " + finalTime);
//        // On average, it takes around 10000 milliseconds.
//        // Although, given the time it takes for me to enter the other values, it may be closer to 7000-9000
//    }
//
//    @Override
//    public V put(K key, V value, int customLoad) {
//        V answer = bucketPut(hashValue(key), key, value);
//        if (n > customLoad / 2)              // Altered method to check the custom load factor
//            resize(2 * customLoad - 1);
//        return answer;
//    }
//
//    @Override
//    protected void createTable() {
//        table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
//    }
//
//    @Override
//    protected V bucketGet(int h, K k) {
//        UnsortedTableMap<K,V> bucket = table[h];
//        if (bucket == null) return null;
//        return bucket.get(k);
//    }
//
//    @Override
//    protected V bucketPut(int h, K k, V v) {
//        UnsortedTableMap<K,V> bucket = table[h];
//        if (bucket == null)
//            bucket = table[h] = new UnsortedTableMap<>();
//        int oldSize = bucket.size();
//        V answer = bucket.put(k,v);
//        n += (bucket.size() - oldSize);
//        return answer;
//    }
//
//    @Override
//    protected V bucketRemove(int h, K k) {
//        return null;
//    }
//
//    @Override
//    public Iterable<Entry<K, V>> entrySet() {
//        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
//        for (int h=0; h < capacity; h++)
//            if (table[h] != null)
//                for (Entry<K,V> entry : table[h].entrySet())
//                    buffer.add(entry);
//        return buffer;
//    }
//}