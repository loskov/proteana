package pl.mwas.math.factorials

import javax.persistence.Entity

@Entity
class BasicFactorial extends Factorial {

    protected BasicFactorial() {}

    BasicFactorial(BigDecimal base) {
        super(base)
    }

    @Override
    BigDecimal computeFactorial(BigDecimal base) {
        List<BigDecimal> range = 1..BigDecimal.valueOf(base)
        def op = { BigDecimal result, BigDecimal next -> result * next }
        return range.inject(op)
    }
}
