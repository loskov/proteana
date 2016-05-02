package pl.mwas.math.factorials

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Inheritance

@Entity
@Inheritance
abstract class Factorial implements Comparable<Factorial> {
    @Id
    BigDecimal base
    BigDecimal result

    protected Factorial() {}

    protected Factorial(BigDecimal base) {
        this.base = base
        this.result = computeFactorial(base)
    }

    @Override
    int compareTo(Factorial o) {
        final int BEFORE = -1
        final int EQUAL = 0
        final int AFTER = 1

        if (this.is(o)) return EQUAL
        if (this.base == o.base) return EQUAL
        this.base > o.base ? AFTER : BEFORE
    }

    protected abstract BigDecimal computeFactorial(BigDecimal base)
}
