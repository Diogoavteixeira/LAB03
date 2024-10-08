package com.aor.numbers;
import com.bmcl.numbers.ListAggregator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
public class ListAggregatorTest {

    private List<Integer> list;
    @BeforeEach
    public void setUp() {
        //list = Arrays.asList(1,2,4,2,5);
        list = Arrays.asList(-1,-4,-5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);
        Assertions.assertEquals(14, sum);
    }
    @Test
    public void max() {
        List<Integer> list = Arrays.asList(-1, -4, -5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        Assertions.assertEquals(-1, max);
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
        int distinct = aggregator.distinct(list);
        Assertions.assertEquals(4, distinct);
    }
}

