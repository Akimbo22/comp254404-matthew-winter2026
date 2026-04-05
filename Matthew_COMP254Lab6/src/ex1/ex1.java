// Matthew Elliott - 301424215
// April 4th, 2026
// Lab 6 - Exercise 1

// Citation:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
import maps.ChainHashMap;
import java.util.Random;
import java.util.Scanner;

// We're attempting to bypass the check for n > capacity / 2 by manually changing the size
public ChainHashMap<Integer, String> updateTable(int newCap, int p, ChainHashMap<Integer, String> oldMap){
    // We make a new map and give it the new cap
    ChainHashMap<Integer, String> newMap = new ChainHashMap<>(newCap, p);
    // We loop through the old map to add the same values to the new one
    for(int i=0;i<= oldMap.size();i++)
    {
        // Only add values that aren't null
        if(oldMap.get(i) != null)
        {
            newMap.put(i, oldMap.get(i));
        }
    }
    return newMap;
}

void main() {
    long startTime = System.currentTimeMillis(); // Getting the runtime for testing
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    // We first get the custom map capacity
    System.out.println("Please enter the map capacity: ");
    int custCap = scanner.nextInt();
    // Next, we want the custom prime factor
    int custPrime;
    do {
        System.out.println("\nNow, please enter the prime factor: ");
        custPrime = scanner.nextInt();
    }while(custPrime<=1 && (custPrime%2 == 0)); // Ensures that it is actually a prime number
    ChainHashMap<Integer, String> customMap = new ChainHashMap<>(custCap, custPrime);

    for (int count = 1; count <= custCap; count++) { // We use a loop to fill the map
        System.out.println("For entry: " + count);
        // Getting the user key and values
        //System.out.println("\nEnter the key: "); // Commented out since it is randomized
        int key;
//            do{
//                key = scanner.nextInt();
//            }while(key<=0 && key>custCap);
        key = random.nextInt(0,custCap); // Using a random number range to experiment on ChainHashMap runtime

        System.out.println("\nNow, enter the value for key " + key + ": ");
        String word = scanner.next();
        // We add the key, value(word) to the map
        customMap.put(key, word);
        // Instead of letting put() keep the load factor, we let the user decide if they would like to update the cap
        System.out.println("Update the capacity? (if lower than or equal to existing, this will not be changed): ");
        int newCap = scanner.nextInt();
        if(newCap > custCap) // We only update it if the capacity is larger than the
            // original, otherwise we will get errors
        {
            customMap = updateTable(newCap, custPrime, customMap);
            custCap = newCap; // Updates the custCap variable so the loop continues to function correctly
        }
        System.out.println(customMap.entrySet());
    }
    long endTime = System.currentTimeMillis();
    long finalTime = endTime-startTime;
    System.out.println("For testing purposes, the final time was: " + finalTime + " milliseconds");
    // On average, it took about 35000 milliseconds, but that's very dependent on certain factors
    // It would take more/less time depending on the cap/if I change the cap
    // You also have to take into account the time spent typing the value.

    // Completely automating it could help, although the instructions specify just randomizing the key

}