package com.aor.numbers;
import com.bmcl.numbers.GenericListSorter;
import com.bmcl.numbers.ListDeduplicator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;


    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {
        class StubListSorter implements GenericListSorter {
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 4, 5);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void bug_deduplicate_8726() {
        List<Integer> list2 = Arrays.asList(1,2,4,2);
        List<Integer> expected2 = Arrays.asList(1,2,4);
        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 2, 4);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list2);
        Assertions.assertEquals(expected2, distinct);
    }
}
