// Matthew Elliott - 30142415
// February 10th, 2026
// Lab 2 - Exercise 1

// Since I need to give a big-Oh characterization of the running time for each
// Exercise{} method from the example code, I felt it'd be important to
// include the author copyright from the example code here as well:

// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

public void main(String[] args){
    class Exercises {
        // a)
        /** Returns the sum of the integers in given array. */
        public static int example1(int[] arr) {
            int n = arr.length, total = 0; // +3 operations
            for (int j=0; j < n; j++) // loop from 0 to n-1 // +2 n operations
                total += arr[j]; // +2 n operations
            return total; // +1 operations
        }
        // The results of the above method:
        // 4n + 4 is O(n)

        // There's no if checks in the loops to increase the worst-case n operations
        // in this case. The n operations come from the for loop checks and adding
        // the specified value from the array to the total.
        // Meanwhile, the constant operations are the initial declaration of n and total,
        // along with the .length operation to the get the value for the length of the array


        // b)
        /** Returns the sum of the integers with even index in given array. */
        public static int example2(int[] arr) {
            int n = arr.length, total = 0; // +3 operations
            for (int j=0; j < n; j += 2) // note the increment of 2 // +2 n operations
                total += arr[j]; // +2 n operations
            return total; // +1 operations
        }
        // Results:
        // n^2 + 3n + 4 is O(n^2)

        // The only difference in this method is that j increments by 2 instead of 1,
        // So each iteration increases twice as much, compared to a)


        // c)
        /** Returns the sum of the prefix sums of given array. */
        public static int example3(int[] arr) {
            int n = arr.length, total = 0; // +3 const ops
            for (int j=0; j < n; j++) // loop from 0 to n-1 // +2 n ops
                for (int k=0; k <= j; k++) // loop from 0 to j // +2 n ops
                    total += arr[j]; // +2 n ops
            return total; // + 1 const op
        }
        // Results:
        // n^2 + 5n + 4 is O(n^2)

        // In this scenario, there's an additional 2 n operations to be accounted for,
        // these come from the secondary loop, which can only run depending on the value
        // of n, as the check relies on j being less than n, which then checks
        // that the new check k is less than or equal to j. Within that second
        // loop is where the prefix is updated with the value of arr[j]


        // d)
        /** Returns the sum of the prefix sums of given array. */
        public static int example4(int[] arr) {
            int n = arr.length, prefix = 0, total = 0; // +4 const ops
            for (int j=0; j < n; j++) {// loop from 0 to n-1 // +2 n ops
                prefix += arr[j]; // +2 n ops
                total += prefix; // +1 n ops
            }
            return total; // +1 const ops
        }
        // Results:
        // 5n + 5 is O(n)

        // We get an additional constant operation from the initialization of int prefix.
        // Additionally, total += prefix is only one n operation because it's simply
        // adding prefix to total, where prefix += arr[j] also has to get the value of
        // j before adding it to prefix. In this method, it doesn't need another looping
        // check before updating the prefix. That prefix is then added to the total.


        // e)
        /** Returns the number of times second array stores sum of prefix sums from first. */
        public static int example5(int[] first, int[] second) { // assume equal-length arrays
            int n = first.length, count = 0; // +3 const ops
            for (int i=0; i < n; i++) {// loop from 0 to n-1 // +2 n ops
                int total = 0; // +1 n op
                for (int j=0; j < n; j++)// loop from 0 to n-1 // +2 n ops
                    for (int k=0; k <= j; k++)// loop from 0 to j // +2 n ops
                        total += first[k]; // +2 n ops
                if (second[i] == total) count++; // +2 n ops for the if check, + 1 n op for operation in the if block
            }
            return count; // + 1 const op
        }
        // Results:
        // n^3 + 8n + 4 is O(n^3)

        // In this case, the worst-case of 8n is entirely dependent on the if conditions.
        // count++ only runs if second[i] is equal to total. Therefore, best case (not the big-Oh)
        // is n^3 + 7n + 4, in comparison. Additionaly, there's two nested loops within the
        // main one, both dependent on the n value for their values (j is less than n,
        // k is less than or equal to j, but for it to run the previous loop has to pass
        // verification). This is where the n^3 comes from
    }
}