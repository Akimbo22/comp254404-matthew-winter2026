package ex1;// Matthew Elliott - 301424215
// March 27th, 2026
// Lab 5 - Exercise 1

import Trees.LinkedBinaryTree;
import Trees.Position;
import Trees.AbstractTree;

public class ex1<E> extends LinkedBinaryTree<E> {
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser



// I will be doing the preorderNext(p) algorithm for exercise 1
public static <E> int preorderNext(AbstractTree<E> T, Position<String> trackedPos)
{
    int posCounter = 0;
    for (Position<E> p : T.preorder()){
        posCounter++;
        // Checks if position matches the one we're tracking
        if(p.getElement() == trackedPos.getElement())
        {
            if(T.numChildren(p) == 0 && T.parent(p) == null)
            {
                // Returns 0, to indicate that it was not in the tree
                posCounter = 0;
                return posCounter;
            }
            else
            {
                // Iterates again, since we want the NEXT position
                posCounter++;
                return posCounter;
            }
        }
    }
    return posCounter;
}

    public static void main(String[] args) {
        // Creating the tree and filling it
        LinkedBinaryTree preOrderTree = new LinkedBinaryTree();
        Position<String> root = preOrderTree.addRoot("Game Genres I Like");

        Position<String> rpgPos = preOrderTree.addLeft(root, "RPGs");
        Position<String> fightingPos = preOrderTree.addRight(root, "Fighting Games");

        // Adding to the rpg branch
        Position<String> srpgPos = preOrderTree.addLeft(rpgPos, "Strategy RPGs");
        Position<String> tbrpgPos = preOrderTree.addRight(rpgPos, "Turn-Based RPGs");

        // Adding to the fighting game branch
        Position<String> platformPos = preOrderTree.addLeft(fightingPos, "Platform Fighter");
        Position<String> arenaPos = preOrderTree.addRight(fightingPos, "Arena Fighter");

        // Printing the tree before running the preorderNext algorithm
        parenthesize(preOrderTree, root);

        // Getting the runtime, so I can test different starting positions:
        long startTime = System.nanoTime();
        // Sending the tree, and the position we want to track
        int foundPos = preorderNext(preOrderTree, fightingPos);
        long endTime = System.nanoTime();
        long finalTime = endTime - startTime;

        System.out.println("\nNext element position is: " + foundPos + "\nFinal runtime to finish preorderNext(): " + finalTime + " nanoseconds");
        // I believe the worst-case running time would be if it had to iterate through
        // the entire tree. Regardless, it's hard to demonstrate for me due to the running time being
        // so short for my exercises.
    }
}