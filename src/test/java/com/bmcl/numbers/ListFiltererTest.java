package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListFiltererTest {

    @Test
    public void testPositiveFilter() {
        ListFilterer filterer = new ListFilterer(new PositiveFilter());
        List<Integer> input = Arrays.asList(-1, 0, 1, 2, -2);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, filterer.filter(input));
    }

    @Test
    void acceptDivideBy2() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        List<Integer> divisible = Arrays.asList(0, 2, 4, 8, 240, 1000, 10000);
        List<Integer> notDivisible = Arrays.asList(1, 3, 5, 15, 351, 10001);
        for (int n : divisible)
            Assertions.assertTrue(filter.accept(n));
        for (int n : notDivisible)
            Assertions.assertFalse(filter.accept(n));
    }
    @Test
    void acceptDivideBy3() {
        DivisibleByFilter filter = new DivisibleByFilter(3);
        List<Integer> divisible = Arrays.asList(0, 3, 6, 9, 33, 333, 666);
        List<Integer> notDivisible = Arrays.asList(1, 2, 4, 5, 100, 1000, 10000);
        for (int n : divisible)
            Assertions.assertTrue(filter.accept(n));
        for (int n : notDivisible)
            Assertions.assertFalse(filter.accept(n));
    }

    @Test
    public void testEmptyList() {
        ListFilterer filterer = new ListFilterer(new PositiveFilter());
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, filterer.filter(input));
    }
    @Test
    /**
     * Só queremos verificar que os valores retornado como false pelos filtros
     * são efetivamente eliminados da lista. Como este teste depende dos filtros
     * criamos stubs para eliminar essa dependência
     */
    public void filter() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(false);
        Mockito.when(filter.accept(3)).thenReturn(true);
        Mockito.when(filter.accept(4)).thenReturn(false);
        Mockito.when(filter.accept(5)).thenReturn(true);
        ListFilterer filterer = new ListFilterer(filter);
        Assertions.assertEquals(Arrays.asList(1, 3, 5), filterer.filter(Arrays.asList(1, 2, 3, 4, 5)));
    }

}
