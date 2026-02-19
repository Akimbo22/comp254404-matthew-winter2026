// Matthew Elliott - 30142415
// February 18th, 2026
// Lab 3 - Exercise 3

import java.util.Scanner;
import java.io.File;

public static long find(File path, String name)
{
    long numFiles = 0; // Initializes counter to keep track of the number of files
    String isFound = null; // Creates null string, which is filled if file is found
    if (path.isDirectory()) // Verifies if path is valid
    {
        File filename = new File(path, name); // With path verified, filename is logged to be searched
        for (String childFile : path.list()) // Creating a new file to be logged for every file in the directory
        {
            File child = new File(path, childFile);
            if (child.equals(filename))
            {
                isFound = name + " Was found in the path!"; // Adds verification message to null string
            }
            System.out.println(child); // Prints out the files as it goes
            numFiles++; // Number of files increases
        }
        if(isFound == null)
        {
            System.out.println(String.format("Total files is %d. File - %s - was not found", numFiles, name));
        }
        else {
            System.out.println(String.format("Total files is %d. File - %s - was found!", numFiles, name));
        }
    }
    else {
        throw new RuntimeException("Enter a valid path!");
    }
    return numFiles;
}

void main() {
    String path;
    String filename;

    System.out.println("Please enter a filename (e.g. Minecraft.exe): ");
    filename = new Scanner(System.in).next();
    System.out.println("Next, please enter the path to that file: ");
    path = new Scanner(System.in).nextLine();

    // Sends the file path and name to be searched
    find(new File(path), filename); // filename is sent as string so path can first be verified
}