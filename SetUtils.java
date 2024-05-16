package edu.phystech.hw3;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SetUtils {

    public static <T> Set<T> union(Set<T> firstSet, Set<T> secondSet) {
        Set<T> unionSet = new HashSet<>(firstSet);
        unionSet.addAll(secondSet);
        return unionSet;
    }

    public static <T> Set<T> intersection(Set<T> firstSet, Set<T> secondSet) {
        Set<T> intersectionSet = new HashSet<>(firstSet);
        intersectionSet.retainAll(secondSet);
        return intersectionSet;
    }

    public static <T> Set<T> difference(Set<T> firstSet, Set<T> secondSet) {
        Set<T> differenceSet = new HashSet<>(firstSet);
        differenceSet.removeAll(secondSet);
        return differenceSet;
    }

    public static <T> Set<T> symmetricDifference(Set<T> firstSet, Set<T> secondSet) {
        Set<T> union = union(firstSet, secondSet);
        Set<T> intersection = intersection(firstSet, secondSet);
        return difference(union, intersection);
    }
}

class SetUtilsTest {

    @Test
    void unionTest() {
        var firstSet = Set.of(1, 2, 3);
        var secondSet = Set.of(4, 5);

        Assertions.assertEquals(Set.of(1, 2, 3, 4, 5), SetUtils.union(firstSet, secondSet));

        firstSet = Set.of(1, 2);
        secondSet = Set.of(2, 1);

        Assertions.assertEquals(firstSet, SetUtils.union(firstSet, secondSet));

    }

    @Test
    void intersectionTest() {
        var firstSet = Set.of(1, 2, 3);
        var secondSet = Set.of(4, 5);

        Assertions.assertEquals(Collections.emptySet(), SetUtils.intersection(firstSet, secondSet));

        firstSet = Set.of(1, 2);
        secondSet = Set.of(2, 1);

        Assertions.assertEquals(firstSet, SetUtils.intersection(firstSet, secondSet));

        firstSet = Set.of(1);
        secondSet = Set.of(1, 2, 3);

        Assertions.assertEquals(firstSet, SetUtils.intersection(firstSet, secondSet));

    }

    @Test
    void differenceTest() {
        var firstSet = Set.of(1, 2, 3);
        var secondSet = Set.of(4, 5);

        Assertions.assertEquals(firstSet, SetUtils.difference(firstSet, secondSet));

        firstSet = Set.of(1, 2);
        secondSet = Set.of(2, 1);

        Assertions.assertEquals(Collections.emptySet(), SetUtils.difference(firstSet, secondSet));

        firstSet = Set.of(1);
        secondSet = Set.of(1, 2, 3);

        Assertions.assertEquals(Collections.emptySet(), SetUtils.difference(firstSet, secondSet));

        firstSet = Set.of(1, 2);
        secondSet = Set.of(2, 3);

        Assertions.assertEquals(Set.of(1), SetUtils.difference(firstSet, secondSet));
    }

    @Test
    void symmetricDifferenceTest() {
        var firstSet = Set.of(1, 2, 3);
        var secondSet = Set.of(4, 5);

        Assertions.assertEquals(Set.of(1, 2, 3, 4, 5), SetUtils.symmetricDifference(firstSet, secondSet));

        firstSet = Set.of(1, 2);
        secondSet = Set.of(2, 1);

        Assertions.assertEquals(Collections.emptySet(), SetUtils.symmetricDifference(firstSet, secondSet));

        firstSet = Set.of(1);
        secondSet = Set.of(1, 2, 3);

        Assertions.assertEquals(Set.of(2, 3), SetUtils.symmetricDifference(firstSet, secondSet));

        firstSet = Set.of(1, 2);
        secondSet = Set.of(2, 3);

        Assertions.assertEquals(Set.of(1, 3), SetUtils.symmetricDifference(firstSet, secondSet));

    }
}