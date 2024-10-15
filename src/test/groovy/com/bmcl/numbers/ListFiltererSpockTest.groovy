package com.bmcl.numbers

import spock.lang.Specification

class ListFiltererSpockTest extends Specification {

    def "filter"() {
        given:
        def filter = Stub(GenericListFilter) {
            accept(1) >> true
            accept(2) >> false
            accept(3) >> true
            accept(4) >> false
            accept(5) >> true
        }
        def filterer = new ListFilterer(filter)

        expect:
        filterer.filter([1, 2, 3, 4, 5]) == [1, 3, 5]
    }
}
