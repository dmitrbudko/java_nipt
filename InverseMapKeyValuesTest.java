package edu.phystech.hw3;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InverseMapKeyValuesTest {

    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map) {
        Map<V, Collection<K>> invertedMap = new HashMap<>();

        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }


    @Test
    void noDuplicateValuesTest() {
        Map<Integer, String> originalMap = Map.of(1, "one", 2, "two");
        Map<String, Collection<Integer>> expectedMap = Map.of("one", List.of(1), "two", List.of(2));

        Map<String, Collection<Integer>> actualMap = inverse(originalMap);

        Assertions.assertEquals(expectedMap.size(), actualMap.size());

        expectedMap.forEach((key, value) -> {
            var entry = actualMap.get(key);
            Assertions.assertNotNull(entry);
            Assertions.assertEquals(new HashSet<>(value), new HashSet<>(entry));
        });

    }

    @Test
    void duplicateValuesTest() {
        Map<Integer, String> originalMap = Map.of(1, "one", 2, "two", 3, "two");
        Map<String, Collection<Integer>> expectedMap = Map.of("one", List.of(1), "two", List.of(2, 3));

        Map<String, Collection<Integer>> actualMap = inverse(originalMap);

        Assertions.assertEquals(expectedMap.size(), actualMap.size());

        expectedMap.forEach((key, value) -> {
            var entry = actualMap.get(key);
            Assertions.assertNotNull(entry);
            Assertions.assertEquals(new HashSet<>(value), new HashSet<>(entry));
        });

    }
}
