package edu.drexel.se320;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;

// Core JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

public class ClosedBoxTests extends BinarySearchBase {

    @Test
    public void returnsCorrectIndexWhenElemIsFirst() {
        Integer[] arr = {1, 3, 5, 7};
        int index = find(arr, 1);
        assertEquals(0, index);
        assertEquals(1, arr[index]);
    }

    @Test
    public void returnsCorrectIndexWhenElemIsMiddle() {
        Integer[] arr = {1, 3, 5, 7, 9};
        int index = find(arr, 5);
        assertEquals(2, index);
        assertEquals(5, arr[index]);
    }

    @Test
    public void returnsCorrectIndexWhenElemIsLast() {
        Integer[] arr = {2, 4, 6, 8};
        int index = find(arr, 8);
        assertEquals(3, index);
        assertEquals(8, arr[index]);
    }

    @Test
    public void returnsAnyDuplicateIndexWhenDuplicatesExist() {
        Integer[] arr = {1, 2, 2, 2, 3};
        int index = find(arr, 2);
        assertThat(index, anyOf(is(1), is(2), is(3)));
        assertEquals(2, arr[index]);
    }

    @Test
    public void worksForStrings() {
        String[] arr = {"are","chicken", "nuggets","yummy"};
        int index = find(arr, "nuggets");
        assertEquals(2, index);
        assertEquals("nuggets", arr[index]);
    }

    @Test
    public void throwsNoSuchElementWhenNotFound() {
        Integer[] arr = {1, 3, 5, 7, 9};
        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> find(arr, 6));
        assertEquals("elem not found in the provided array.", ex.getMessage());
    }

    @Test
    public void nullArrayThrowsIllegalArgument() {
        Integer[] arr = null;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> find(arr, 1));
        assertTrue(ex.getMessage() != null && !ex.getMessage().isBlank());
        assertEquals("The array can't be null.", ex.getMessage());
    }

    @Test
    public void emptyArrayThrowsIllegalArgument() {
        Integer[] arr = new Integer[0];
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> find(arr, 42));
        assertEquals("The array can't be empty.", ex.getMessage());
    }

    @Test
    public void nullElementThrowsIllegalArgument() {
        Integer[] arr = {1, 2, 3};
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> find(arr, null));
        assertEquals("elem can't be null.", ex.getMessage());
    }

    @Test
    public void searchDoesNotModifyArrayContents() {
        Integer[] arr = {1, 3, 5, 7, 9};
        Integer[] arrClone = arr.clone();
        int index = find(arr, 7);
        assertEquals(7, arr[index]);
        assertArrayEquals(arrClone, arr, "Array must not be modified by search");
    }

    @Test
    public void singleElementArrayFound() {
        Integer[] arr = {42};
        int index = find(arr, 42);
        assertEquals(0, index);
        assertEquals(42, arr[index]);
    }

    @Test
    public void singleElementArrayNotFound() {
        Integer[] arr = {42};
        assertThrows(NoSuchElementException.class, () -> find(arr, 7));
    }
}
