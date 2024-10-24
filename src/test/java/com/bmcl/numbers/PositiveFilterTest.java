package com.bmcl.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveFilterTest {

    @Test
    public void testPositiveFilter() {
        ListFilterer filterer = new ListFilterer(new PositiveFilter());
        List<Integer> input = Arrays.asList(-1, 0, 1, 2, -2);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, filterer.filter(input));
    }
}
