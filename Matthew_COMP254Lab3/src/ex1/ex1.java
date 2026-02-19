// Matthew Elliott - 30142415
// February 17th, 2026
// Lab 3 - Exercise 1

import java.util.Scanner;

public static int multiplyNums(int m, int n) // Sending m and n
{
    if (n == 0)
    {
        return 0; // Once 0 is returned, we go back up through the iterations
    }
    else
    {
        return multiplyNums(m, n-1) + m; // Recursively adding m to itself n number of times
    }
}

void main() {
    int userNum;
    int multiplyBy;
    System.out.println("Please enter your first number");
    String userInput1 = new Scanner(System.in).next();
    System.out.println("Next, enter the number of times you want to multiply it");
    String userInput2 = new Scanner(System.in).next();
    try {
        userNum = Integer.parseInt(userInput1); // Gets the user's number
        multiplyBy = Integer.parseInt(userInput2); // Gets the number to multiply m by
    } catch (NumberFormatException e) {
        throw new RuntimeException(e);
    }
    if (userNum > 0 && multiplyBy > 0) {
        int sum = multiplyNums(userNum, multiplyBy);
        System.out.println(userNum + " * " + multiplyBy + " = " + sum);
    }
    else {
        throw new RuntimeException("Number must be larger than 0!");
    }
    
}