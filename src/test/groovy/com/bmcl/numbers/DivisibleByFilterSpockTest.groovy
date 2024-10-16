package com.bmcl.numbers

import spock.lang.Specification

class DivisibleByFilterSpockTest extends Specification {

    def setup() {
    }

    def "acceptDivideBy2"() {
        given:
        def filter = new DivisibleByFilter(2)
        def divisible = [0, 2, 4, 8, 240, 1000, 10000]
        def notDivisible = [1, 3, 5, 15, 351, 10001]

        expect:
        divisible.each { n ->
            assert filter.accept(n)
        }
        notDivisible.each { n ->
            assert !filter.accept(n)
        }
    }

    def "acceptDivideBy3"() {
        given:
        def filter = new DivisibleByFilter(3)
        def divisible = [0, 3, 6, 9, 33, 333, 666]
        def notDivisible = [1, 2, 4, 5, 100, 1000, 10000]

        expect:
        divisible.each { n ->
            assert filter.accept(n)
        }
        notDivisible.each { n ->
            assert !filter.accept(n)
        }
    }
}
