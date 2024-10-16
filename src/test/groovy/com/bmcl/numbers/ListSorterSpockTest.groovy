package com.bmcl.numbers

import spock.lang.Specification

class ListSorterSpockTest extends Specification {

    private List<Integer> list
    private List<Integer> expected

    def setup() {
        list = [3, 2, 6, 1, 4, 5, 7]
        expected = [1, 2, 3, 4, 5, 6, 7]
    }

    def "sort"() {
        given:
        def sorter = new ListSorter()

        when:
        def sorted = sorter.sort(list)

        then:
        sorted == expected
    }

    def "bug sort 8276"() {
        given:
        def sorter = new ListSorter()

        when:
        def sorted = sorter.sort([1, 2, 4, 2])

        then:
        sorted == [1, 2, 2, 4]
    }
}