// Matthew Elliott - 30142415
// February 10th, 2026
// Lab 2 - Exercise 2

// Crediting the authors from the example code, since I'll be doing the experimental
// analysis on their algorithms:
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

/** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    for (int j=0; j < n; j++) {
        double total = 0;            // begin computing x[0] + ... + x[j]
        for (int i=0; i <= j; i++)
            total += x[i];
        a[j] = total / (j+1);        // record the average
    }
    return a;
}

/** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
    for (int j=0; j < n; j++) {
        total += x[j];               // update prefix sum to include x[j]
        a[j] = total / (j+1);        // compute average based on current sum
    }
    return a;
}

public void main(String[] args){
    double[] average = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40,
    42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80}; // Initializing the array

    // Testing prefixAverage1 first
    System.out.println("Running prefixAverage1:");
    long startTime1 = System.nanoTime(); // Timing the runtime of the method
    double[] results1 = prefixAverage1(average); // Running the method with the created array
    long endTime1 = System.nanoTime();
    long finalTime1 = endTime1 - startTime1; // Getting the final results of the time taken to run
    System.out.println(Arrays.toString(results1));
    System.out.println(String.format("prefixAverage1 took %d NANOSECONDS to finish running", finalTime1));
    // 0 miliseconds. Holy moly...
    // Switched to nanoseconds to see if there's a difference
    // Okay that worked. Now I can see the difference between the two

    // Next, testing prefixAverage2
    System.out.println("Running prefixAverage2:");
    long startTime2 = System.nanoTime(); // Timing the runtime of the method
    double[] results2 = prefixAverage2(average); // Running the method with the created array
    long endTime2 = System.nanoTime();
    long finalTime2 = endTime2 - startTime2; // Getting the final results of the time taken to run
    System.out.println(Arrays.toString(results2));
    System.out.println(String.format("prefixAverage2 took %d NANOSECONDS to finish running", finalTime2));

    // After testing a few times and increasing the number of elements in the array,
    // prefixAverage2, on average, runs faster than prefixAverage1
}