package edu.drexel.se320;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.lessThan;

// Core JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class OpenBoxTests extends BinarySearchBase {
    @Test
    public void nullArrayThrowsIllegalArgument() {
        Integer[] a = null;
        assertThrows(IllegalArgumentException.class, () -> find(a, 1));
    }

    @Test
    public void emptyArrayThrowsIllegalArgument() {
        Integer[] a = new Integer[0];
        assertThrows(IllegalArgumentException.class, () -> find(a, 1));
    }

    @Test
    public void nullElementThrowsIllegalArgument() {
        Integer[] a = new Integer[] {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> find(a, null));
    }

    @Test
    public void returnsMiddleIndexWhenTargetIsAtMid() {
        Integer[] a = new Integer[] {1, 3, 5}; 
        int index = find(a, 3);
        assertEquals(1, index);
        assertEquals(3, a[index]);
    }

    @Test
    public void firstStepGoesRightThenFindsTarget() {
        Integer[] a = new Integer[] {1, 3, 5, 7, 9}; 
        int index = find(a, 7);
        assertEquals(3, index);
        assertEquals(7, a[index]);
    }

    @Test
    public void firstStepGoesLeftThenFindsTarget() {
        Integer[] a = new Integer[] {1, 3, 5, 7, 9};
        int index = find(a, 3);
        assertEquals(1, index);
        assertEquals(3, a[index]);
    }

    @Test
    public void exitsLoopAndThrowsIfElemNotFound() {
        Integer[] a = new Integer[] {1, 3, 5, 7, 9};
        assertThrows(NoSuchElementException.class, () -> find(a, 6));
    }
}

