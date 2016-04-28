package pl.mwas.math.factorials


class CachedFactorial implements Factorial{
    
    Map<BigDecimal, BigDecimal> resultCache
    
    CachedFactorial() {
        resultCache = new HashMap<BigDecimal, BigDecimal>()
    }
    
    @Override
    BigDecimal computeFactorial(BigDecimal base) {
        BigDecimal maxCached = resultCache.keySet().max() ?: 1
        base = base > maxCached ? base : maxCached
        List<BigDecimal> range = maxCached..BigDecimal.valueOf(base)
        BigDecimal initVal = resultCache.get(maxCached) ?: 1
        def op = {BigDecimal result, BigDecimal next -> result * next}
        return range.inject(initVal, op)
    }
}
