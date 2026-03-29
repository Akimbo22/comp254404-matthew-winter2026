// Matthew Elliott - 301424215
// March 27th, 2026
// Lab 5 - Exercise 2

import Trees.LinkedBinaryTree;
import Trees.Position;
import Trees.AbstractTree;

// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

public static <E> void postorderAndHeight(AbstractTree<E> T)
{
    // Running a loop through the tree, using postorder
    for(Position<E> p : T.postorder())
    {
        // For every element, it prints the element itself and the height
        System.out.println(p.getElement() + " At height: " + T.height(p));
    }
}

public static void main(String[] args) {
    // Creating the tree and filling it
    LinkedBinaryTree postOrderTree = new LinkedBinaryTree();
    Position<String> root = postOrderTree.addRoot("College Education");

    Position<String> gamePos = postOrderTree.addLeft(root, "Game Programming");
    Position<String> bakePos = postOrderTree.addRight(root, "Baking Skills");

    // Adding to the game programming branch
    Position<String> codingPos = postOrderTree.addLeft(gamePos, "Coding Courses");
    Position<String> gameEngPos = postOrderTree.addRight(gamePos, "Game Engine Courses");

    Position<String> javaPos = postOrderTree.addLeft(codingPos, "Java Programming");
    Position<String> unityPos = postOrderTree.addLeft(gameEngPos, "Unity Engine");
    Position<String> unrealPos = postOrderTree.addRight(gameEngPos, "Unreal Engine");

    // Adding to the baking skills branch
    Position<String> bakingPos = postOrderTree.addLeft(bakePos, "Baking Courses");
    Position<String> businessPos = postOrderTree.addRight(bakePos, "Business Courses");

    Position<String> bakeskillsPos = postOrderTree.addLeft(bakingPos, "Baking Skills II");
    Position<String> baketheoryPos = postOrderTree.addRight(bakingPos, "Baking Theory");

    // Getting the runtime, just for comparison purposes with ex1 & ex2 (since I used preorder for the other)
    long startTime = System.nanoTime();
    // Sending the tree through postorderAndHeight()
    postorderAndHeight(postOrderTree);
    long endTime = System.nanoTime();
    long finalTime = endTime - startTime;
    System.out.println("Final runtime is: " + finalTime + " nanoseconds");
}