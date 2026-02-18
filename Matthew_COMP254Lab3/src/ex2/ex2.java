// Matthew Elliott - 30142415
// February 17th, 2026
// Lab 3 - Exercise 2

import java.util.Scanner;

public int checkPalindrome(char[] c, int n, int counter)
{
    if (n == 0)
    {
        return 0;
    }
    else
    {
        int matches = 0; // Counts the number of matches
        if (c[counter] == c[n-1]) // Checks if the char at the start matches the char at the end
        {
            System.out.println(c[counter]); // prints the matching letter
            matches = 1;
        }
        return checkPalindrome(c, n-1, counter+1) + matches; // Incrementing matches by 1 for each matching char.
        // Additionally, to read both forward and backwards through the array, I have n decrement and counter increment
    }
}

void main() {
    System.out.println("Please enter a palindrome, or I guess don't if you're just testing the program:");
    String s = new Scanner(System.in).next(); // Gets the initial string
    char[] stringInChars = s.toCharArray(); // Puts the string into a char array, to get the length
    int numChars = stringInChars.length; // Finally, gets the length, to be sent to the algorithm
    int counter = 0;
    int checkMatches = checkPalindrome(stringInChars, numChars, counter);
    if (checkMatches == numChars) // Verifies if the number of matches is equal to the length of the string
    {
        System.out.println("Yes! Your string is a palindrome!");
    }
    else
    {
        System.out.println("No, I don't believe that's a palindrome...");
    }
}