package com.bmcl.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter implements GenericListSorter {
    @Override
    public List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }
}
