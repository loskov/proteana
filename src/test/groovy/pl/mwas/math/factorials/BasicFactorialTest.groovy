package pl.mwas.math.factorials

import spock.lang.Specification

class BasicFactorialTest extends Specification {
    def "get basic factorial(10)"() {
        when:
            BasicFactorial fact = new BasicFactorial(10)
        then:
            fact.base == BigDecimal.valueOf(10)
            fact.result == BigDecimal.valueOf(3628800)
    }

    def "test factorial comparing"() {
        when:
            BasicFactorial f1 = new BasicFactorial(10)
            BasicFactorial f2 = new BasicFactorial(3)
        then:
            assert f1 > f2
            assert f2 < f1
            assert f1 == f1
    }
}
