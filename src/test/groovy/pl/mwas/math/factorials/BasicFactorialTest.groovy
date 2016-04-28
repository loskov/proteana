package pl.mwas.math.factorials

import spock.lang.Specification


class BasicFactorialTest extends Specification {
    def "test computeFactorial"() {
        given:
            BasicFactorial fact = new BasicFactorial()
        when:
            def result = fact.computeFactorial(10)
        then:
            result == BigDecimal.valueOf(3628800)
    }
}
