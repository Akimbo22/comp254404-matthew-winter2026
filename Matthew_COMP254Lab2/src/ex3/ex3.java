import ex3.Resources.createArray;

// Matthew Elliott - 30142415
// February 11th, 2026
// Lab 2 - Exercise 3

// Credit to the authors of the unique algorithms:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

/** Returns true if there are no duplicate elements in the array. */
public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
        for (int k=j+1; k < n; k++)
            if (data[j] == data[k])
                return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
}

/** Returns true if there are no duplicate elements in the array. */
public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
        if (temp[j] == temp[j+1])            // check neighboring entries
            return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
}


public void main(String[] args){
    // I'm just a little worried about this, since my computer somehow runs
    // these methods very fast, so I don't know if it'll reach even close to a second, let alone a minute

    int[] checkUnique = new int[8000];
    try{
        checkUnique = createArray.CreateArray(checkUnique);
    } catch (RuntimeException e) {
        throw new RuntimeException(e);
    }
    // (I originally had a huge wall of rambling here as I struggled to set up the array)
    // I had planned to set up a JSON with a list of 8000 int values, however, I struggled
    // to set it up properly. Instead, I've created an interface to create the values for the
    // array.

    // Testing unique1 first
    System.out.println("Checking for completely unique values with unique1: ");
    long startTime1 = System.currentTimeMillis(); // Same process as exercise 2. Getting the start time to test how long the algorithm takes
    long nanoStart1 = System.nanoTime();
    boolean allUnique1 = unique1(checkUnique); // Running unique1 with the checkUnique array
    long endTime1 = System.currentTimeMillis();
    long nanoEnd1 = System.nanoTime();
    long finalTime1 = endTime1 - startTime1; // Getting the milliseconds until I reach a point where the processing time (maybe) takes seconds to complete
    long nanoFinal1 = nanoEnd1 - nanoStart1; // Calculating the nanoseconds for testing purposes
    System.out.println(String.format("All Unique Values? - %b", allUnique1));
    System.out.println(String.format("Time taken to search: %d milliseconds", finalTime1));
    System.out.println(String.format("Nanoseconds (for testing): %d", nanoFinal1));

    // Testing unique2 next, process is same as above
    System.out.println("Checking for completely unique values with unique2: ");
    long startTime2 = System.currentTimeMillis();
    long nanoStart2 = System.nanoTime();
    boolean allUnique2 = unique2(checkUnique);
    long endTime2 = System.currentTimeMillis();
    long nanoEnd2 = System.nanoTime();
    long finalTime2 = endTime2 - startTime2;
    long nanoFinal2 = nanoEnd2 - nanoStart2;
    System.out.println(String.format("All Unique Values? - %b", allUnique2));
    System.out.println(String.format("Time taken to search: %d milliseconds", finalTime2));
    System.out.println(String.format("Nanoseconds (for testing): %d", nanoFinal2));

    // Declaring the time it took to complete the longer processes
    int arraySize = checkUnique.length; // Getting the length to include in the conclusion statement
    if(finalTime1 > finalTime2) // Runs if unique1 took longer than unique2
    {
        System.out.println(String.format("Therefore, with %d elements in the array, it took unique1 longer to complete, at %d milliseconds!", arraySize, finalTime1));
    }
    else if(finalTime2 > finalTime1) // Runs if unique2 took longer than unique1
    {
        System.out.println(String.format("Therefore, with %d elements in the array, it took unique2 longer to complete, at %d milliseconds!", arraySize, finalTime2));
    }
    else if(finalTime1 == finalTime2) // Unlikely, but checks if both unique1 and unique2 took the same amount of time
    {
        System.out.println(String.format("Therefore, with %d elements in the array, it took unique1 and unique2 an equal amount of time at %d milliseconds!", arraySize, finalTime1));
    }
    else // Finally, throws an exception if none of the top three checks apply
    {
        throw new RuntimeException();
    }

    // In conclusion, I believe unique1 is quadratic, due to its nested loops to go through the array. Meanwhile, unique2 creates a copy to then compares the values of each element
    // Admittedly, I'm still trying to fully understand it (I sometimes have trouble fully understanding code that I didn't write myself), but based on what I understand from class,
    // I believe this is the case.
    // Similarly, I believe prefixAverage1 from exercise 2 is quadratic as well, and it ran slower than prefixAverage2, on average. So I believe this is a similar situation

}