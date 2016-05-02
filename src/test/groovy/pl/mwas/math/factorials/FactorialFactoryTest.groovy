package pl.mwas.math.factorials

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import pl.mwas.ProteanaApp
import spock.lang.Specification

@ContextConfiguration(classes = ProteanaApp)
class FactorialFactoryTest extends Specification {

    @Autowired
    FactorialRepository cache

    def "Get basic factorial"() {
        when:
            def factorial = FactorialFactory.instance.getFactorial(10)
        then:
            factorial.result == BigDecimal.valueOf(3628800)
            println cache.findAll()
    }
}
