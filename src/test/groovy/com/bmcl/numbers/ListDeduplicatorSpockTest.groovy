package com.bmcl.numbers

import spock.lang.Specification

class ListDeduplicatorSpockTest extends Specification {
    List<Integer> list
    List<Integer> expected
    GenericListSorter sorter
    ListDeduplicator deduplicator

    def setup() {
        list = [1, 2, 4, 2, 5]
        expected = [1, 2, 4, 5]
        sorter = Mock(GenericListSorter)
        deduplicator = new ListDeduplicator(sorter)
    }

    def "deduplicate"() {
        given:
        sorter.sort(_) >> [1, 2, 2, 4, 5]

        when:
        def distinct = deduplicator.deduplicate(list)

        then:
        distinct == expected
    }

    def "bug deduplicate 8726"() {
        given:
        list = [1, 2, 4, 2]
        expected = [1, 2, 4]
        sorter.sort(_) >> [1, 2, 2, 4]

        when:
        def distinct = deduplicator.deduplicate(list)

        then:
        distinct == expected
    }
}
