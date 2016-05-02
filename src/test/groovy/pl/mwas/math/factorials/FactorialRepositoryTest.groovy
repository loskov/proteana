package pl.mwas.math.factorials

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import pl.mwas.ProteanaApp
import spock.lang.Specification

@ContextConfiguration(classes = ProteanaApp)
class FactorialRepositoryTest extends Specification {
    @Autowired
    FactorialRepository repository

    def setup() {
        def factCache = [new BasicFactorial(1), new BasicFactorial(2), new BasicFactorial(3)]
        repository.save(factCache)
    }

    def "test getMaxResultLowerThanBase"() {
        when:
            def max = repository.findByBaseLessThan(BigDecimal.valueOf(5)).max()
        then:
            assert max == new BasicFactorial(3)
    }
}