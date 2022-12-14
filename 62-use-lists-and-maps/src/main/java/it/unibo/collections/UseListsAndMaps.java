package it.unibo.collections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 100_000;
    private static final int ELEMS2 = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        final int RANGE_MIN = 1000;
        final int RANGE_MAX = 2000;
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> list = new ArrayList<Integer>();
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> list2 = new LinkedList<Integer>(list);
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

         // swap first and last element
        final int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int i : list) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            list.add(0, i);
        }
        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("ArrayList: " + time + "ns (" + millis + "ms)");
        
        time = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            list2.add(0, i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("LinkedList: " + time + "ns (" + millis + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < ELEMS2; i++) {
            list.get(list.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("ArrayList: " + time + "ns (" + millis + "ms)");

        time = System.nanoTime();
        for (int i = 0; i < ELEMS2; i++) {
            list2.get(list2.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("LinkedList: " + time + "ns (" + millis + "ms)");



        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        
        final Map<String, Long> map = new HashMap<String, Long>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);


        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0L;
        for (final var i : map.values()) {
            worldPopulation += (long) i;
        }
        System.out.println("World population: " + worldPopulation);
    }
}