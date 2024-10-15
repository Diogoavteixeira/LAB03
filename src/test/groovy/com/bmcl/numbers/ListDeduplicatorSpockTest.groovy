package com.bmcl.numbers


import spock.lang.Specification


class ListDeduplicatorSpockTest extends Specification {
    private List<Integer> list
    private List<Integer> expected

    @org.junit.Before
    void setUp() {
        list = [1, 2, 4, 2, 5]
        expected = [1, 2, 4, 5]
    }

    def "deduplicate"() {
        given:
        def sorter = Stub(GenericListSorter) {
            sort(_) >> [1, 2, 2, 4, 5]
        }
        def deduplicator = new ListDeduplicator(sorter)

        when:
        def distinct = deduplicator.deduplicate(list)

        then:
        distinct == expected
    }

    def "bug_deduplicate_8726"() {
        given:
        def list = [1, 2, 4, 2]
        expected = [1, 2, 4]
        def sorter = Stub(GenericListSorter) {
            sort(_) >> [1, 2, 2, 4]
        }
        def deduplicator = new ListDeduplicator(sorter)

        when:
        def distinct = deduplicator.deduplicate(list)

        then:
        distinct == expected
    }
}
