package com.bmcl.numbers;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyListTest {

    @Test
    public void testEmptyList() {
        ListFilterer filterer = new ListFilterer(new PositiveFilter());
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, filterer.filter(input));
    }
}
