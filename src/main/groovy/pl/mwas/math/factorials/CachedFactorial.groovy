package pl.mwas.math.factorials

import org.springframework.beans.factory.annotation.Autowired

import javax.persistence.Entity
import javax.persistence.Transient

@Entity
class CachedFactorial extends Factorial {

    @Autowired
    @Transient
    FactorialRepository cache

    protected CachedFactorial() {}

    CachedFactorial(BigDecimal base) {
        super(base)
    }
    
    @Override
    BigDecimal computeFactorial(BigDecimal base) {
        BigDecimal maxCached = getMaxCachedBaseLowerThan(base)
        def initVal = cache.findOne(maxCached)
        def op = { BigDecimal result, BigDecimal next -> result * next }
        def range = maxCached+1..base
        return range.inject(initVal, op)
    }

    private BigDecimal getMaxCachedBaseLowerThan(BigDecimal base) {
        def result = cache.findByBaseLessThan(base).max()
        return result.base
    }
}
