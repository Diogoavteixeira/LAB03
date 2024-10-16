package com.bmcl.numbers

import spock.lang.Specification

class PositiveFilterSpockTest extends Specification {

    def "testPositiveFilter"() {
        given:
        def filterer = new ListFilterer(new PositiveFilter())
        def input = [-1, 0, 1, 2, -2]
        def expected = [1, 2]

        expect:
        filterer.filter(input) == expected
    }
}
