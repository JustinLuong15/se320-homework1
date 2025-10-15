package edu.drexel.se320;

import java.util.NoSuchElementException;

public class BinarySearch {

    // DO NOT MODIFY THIS SIGNATURE
    // This includes the protected modifier; the autograder currently relies
    // on a combination of overloading and visibility hacks to swap out your
    // code at runtime to test your test suite.
    protected static <T extends Comparable<T>> int binarySearchImplementation(T[] array, T elem) {
	// TODO: Implement binary search here. The signature above sets you up to ensure the array elements have a compareTo method
        if (array == null)
            throw new IllegalArgumentException("The array can't be null.");
        if (array.length == 0)
            throw new IllegalArgumentException("The array can't be empty.");
        if (elem == null)
            throw new IllegalArgumentException("elem can't be null.");

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            T midVal = array[mid];
            int compareResult = midVal.compareTo(elem);

            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        throw new NoSuchElementException("elem not found in the provided array.");
    }
}