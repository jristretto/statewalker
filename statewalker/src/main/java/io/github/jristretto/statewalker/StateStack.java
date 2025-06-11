package io.github.jristretto.statewalker;

import java.util.Arrays;
import java.util.List;

/**
 * Simple array base stack with extra methods for state walker.
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 * @param <E> element type
 */
class StateStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 4;
    private int top = -1;
    private E[] storage;

    /**
     * Create a stack with given initial capacity.
     *
     * @param cap the initial capacity.
     */
    @SuppressWarnings("unchecked")
    StateStack(int cap) {
        this.storage = (E[]) new Object[cap];
    }

    /**
     * Default constructor producing stack of default capacity.
     */
    StateStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return 0 > top;
    }

    @Override
    public void push(E e) {
        ensureCapacity();
        storage[++top] = e;
    }

    /**
     * Get and remove element.
     *
     * @return the top element
     * @throws RuntimeException if peek in the same state of this stack.
     * @see #peek()
     */
    @Override
    public E pop() {
        E result = peek();
        storage[top--] = null;
        return result;

    }

    /**
     * Get the top element.
     *
     * @return the top element
     * @throws ArrayIndexOutOfBoundsException on empty stack.
     */
    @Override
    public E peek() {
        return storage[top];
    }

    /**
     * Peek below top, and return state, if any.
     *
     * @param levelsDown to peek below top.
     */
    public E peekDownFrom(E reference, int levelsDown) {
        int t = top;
        // find reference state.
        while (!storage[t].equals(reference) && 0 < t) {
            t--;
        }
        if (t < levelsDown) {
            return null;
        }
        // t <= top, k >=0
        int k = t - levelsDown;
        if (k < 0 || k >= storage.length) {
            return null;
        } else {
            return storage[k];
        }
    }

    /** empty stack. */
    @SuppressWarnings("unchecked")
    static final Object[] EMPTY = new Object[0];

    /**
     * Get the states that are on this stack above the reference.
     *
     * @param reference
     * @param found list to accept the found 'above' states.
     * @return the found list
     */
    @SuppressWarnings("unchecked")
    public List<E> above(E reference, List<E> found) {
        int t = top;
        found.clear();
        while (t >= 0 && storage[t] != reference) {
            t--;
        }
        if (t < 0) {
            return found;
        }
        t++;
        for (; t <= top; t++) {
            found.add(storage[t]);
        }
        return found;
    }

    /**
     * Check if element is on stack.
     *
     * @param e to search.
     * @return true if contained.
     */
    public boolean has(E e) {
        for (int i = top; i >= 0; i--) {
            if (e.equals(storage[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Make sure the stack has sufficient capacity to take the next push.
     */
    private void ensureCapacity() {
        if (top + 1 < storage.length) {
            return;
        }
        storage = Arrays.copyOf(storage, storage.length * 2);
    }

    /**
     * Get current size.
     *
     * @return size
     */
    int size() {
        return top + 1;
    }

    /**
     * Get the capacity.
     *
     * @return capacity
     */
    int capacity() {
        return storage.length;
    }

    /**
     * Does this stack contain e?
     *
     * @param e to test
     * @return result of test.
     */
    public boolean contains(Object e) {
        for (Object o : storage) {
            if (e == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the logical state as a string.
     *
     * @return the state hierarchy as a string
     */
    String logicalState() {
        String glue = "";
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= top; i++) {
            result.append(glue).append(storage[i]);
            glue = ".";
        }
        return result.toString();
    }

}
