package pl.mwas.math.factorials

import org.springframework.beans.factory.annotation.Autowired

@Singleton
class FactorialFactory {

    @Autowired
    FactorialRepository cache

    public Factorial getFactorial(BigDecimal base) {
        def result
        switch (base){
            case {it < 1}:
                throw new IllegalArgumentException("Factorial base cannot be less than 1")
            case {it <= 100}:
                result = new BasicFactorial(base)
                cache.save(result)
                return result
            case {it > 100}:
                result = new CachedFactorial(base)
                cache.save(result)
                return result
        }
    }
}
