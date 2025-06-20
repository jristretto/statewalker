package io.github.jristretto.statewalker;

/**
 * Stack definition made package private.
 *
 * This artefact of a hierarchy is left in because of the tests that come with
 * it, to make complete test code coverage less work.
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 * @param <E> element type
 */
interface Stack<E> {

    boolean isEmpty();

    /**
     * Get the top element.
     *
     * @return the top element
     * @throws ArrayIndexOutOfBoundsException on empty stack.
     */
    E peek();

    /**
     * Get and remove element.
     *
     * @return the top element
     * @throws RuntimeException if peek in the same state of this stack.
     * @see #peek()
     */
    E pop();

    void push( E e );

}
