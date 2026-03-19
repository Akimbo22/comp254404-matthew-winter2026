package ex2;
// Matthew Elliott - 30142415
// March 17th, 2026
// Lab 4 - Exercise 2
import stacks.Stack;

// Citing authors of Stack interface and ArrayStack, which was used for the override methods
// Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser

public class ex2<E> implements Stack<E> {

    public Stack<Integer> transfer(Stack<Integer> S, Stack<Integer> T)
    {
        try {
            int sCounter = S.size();
            // pushing the elements from S onto T
            for (int i = 0; i < sCounter; i++) {
                T.push(S.pop());
            }
            return T;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void main() {
        // Creating and filling the initial stacks
        Stack<Integer> S = new ex2<Integer>();
        Stack<Integer> T = new ex2<Integer>();
        S.push(1);
        S.push(2);
        S.push(3); // Stack is currently: (1, 2, 3)
        T.push(6);
        T.push(5);
        T.push(4); // Stack is currently: (6, 5, 4)

        // Adding the contents of S onto T:
        T = transfer(S, T);
        int tCounter = T.size();
        // Using a second loop to print the elements of Stack T
        for(int i = 0;i<tCounter;i++) {
            System.out.println(T.pop());
        }
    }

    public static final int CAPACITY=50;
    private E[] data;
    private int t = -1;
    public ex2() { this(CAPACITY); }
    @SuppressWarnings({"unchecked"})
    public ex2(int capacity){data = (E[]) new Object[capacity];}

    // Creating the override methods using the Stack interface
    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
}