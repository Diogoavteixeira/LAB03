package com.aor.numbers;
import com.bmcl.numbers.GenericListDeduplicator;
import com.bmcl.numbers.ListAggregator;
import com.bmcl.numbers.ListDeduplicator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


public class ListAggregatorTest {

    private List<Integer> list;
    private List<Integer> list7263;
    private List<Integer> list8726;

    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1, 2, 4, 2, 5);
        list7263 = Arrays.asList(-1, -4, -5);
        list8726 = Arrays.asList(1, 2, 4,2);

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
        class StubListDeduplicator implements GenericListDeduplicator {
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return  Arrays.asList(1, 2, 4, 5);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list8726, deduplicator);
        Assertions.assertEquals(4, distinct);
    }
    @Test
    public void bug8726() {
        List<Integer> list= Arrays.asList(1,2,4,2);
        class StubListDeduplicator implements GenericListDeduplicator {
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return  Arrays.asList(1, 2, 4);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list8726, deduplicator);
        Assertions.assertEquals(3, distinct);
    }

}


