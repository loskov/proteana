package pl.mwas.math.factorials


class BasicFactorial implements Factorial {

    @Override
    BigDecimal computeFactorial(BigDecimal base) {
        List<BigDecimal> range = 1..BigDecimal.valueOf(base)
        def op = {BigDecimal result, BigDecimal next -> result * next}
        return range.inject(op)
    }
}
