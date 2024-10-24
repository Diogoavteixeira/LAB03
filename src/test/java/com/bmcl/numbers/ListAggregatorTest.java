package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import org.mockito.Mockito;


public class ListAggregatorTest {

    private List<Integer> list;
    private List<Integer> list7263;


    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1, 2, 4, 2, 5);
        list7263 = Arrays.asList(-1, -4, -5);


    }

    @Test
    public void bug7263() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list7263);
        Assertions.assertEquals(-1, max);

    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);
        Assertions.assertEquals(14, sum);

    }
    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);
        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(4, distinct);

    }
    @Test
    public void max_bug_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(3, distinct);
    }

}


