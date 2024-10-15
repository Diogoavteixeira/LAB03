package com.bmcl.numbers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import spock.lang.Specification

class DivisibleByFilterSpockTest extends Specification{

    @Test
    void acceptDivideBy2() {
        def filter = new DivisibleByFilter(2)
        def divisible = [0, 2, 4, 8, 240, 1000, 10000]
        def notDivisible = [1, 3, 5, 15, 351, 10001]
        divisible.each { n ->
            Assertions.assertTrue(filter.accept(n))
        }
        notDivisible.each { n ->
            Assertions.assertFalse(filter.accept(n))
        }
    }

    @Test
    void acceptDivideBy3() {
        def filter = new DivisibleByFilter(3)
        def divisible = [0, 3, 6, 9, 33, 333, 666]
        def notDivisible = [1, 2, 4, 5, 100, 1000, 10000]
        divisible.each { n ->
            Assertions.assertTrue(filter.accept(n))
        }
        notDivisible.each { n ->
            Assertions.assertFalse(filter.accept(n))
        }
    }
}
