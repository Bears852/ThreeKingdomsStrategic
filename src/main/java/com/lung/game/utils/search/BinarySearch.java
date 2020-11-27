package com.lung.game.utils.search;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/19 - 16:50
 * @implSpec 二分查找法
 */
public class BinarySearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        return search(array, key, 0, array.length);
    }

    /**
     * search target
     *
     * @param array sorted array
     * @param key key
     * @param left left index
     * @param right right index
     * @param <T> generic type
     * @return result
     */
    private <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
        if (right < left) return -1; // this means that the key not found

        // find median
        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);

        if (comp == 0) {
            return median;
        } else if (comp < 0) {
            return search(array, key, left, median - 1);
        } else {
            return search(array, key, median + 1, right);
        }
    }


    // Diver program
    public static void main(String[] args) {
        // Just generate data
        Random random = ThreadLocalRandom.current();

        int size = 100;
        int maxElement = 10000;

        Integer[] integers = IntStream.generate(() -> random.nextInt(maxElement))
                .limit(size)
                .sorted()
                .boxed()
                .toArray(Integer[]::new);

        // The element that should be found
        int shouldBeFound = integers[random.nextInt(size - 1)];

        BinarySearch search = new BinarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(
                format(
                        "Should be found: %d. Found %d at index %d. An array length %d",
                        shouldBeFound, integers[atIndex], atIndex, size));

        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(
                format(
                        "Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }
}
