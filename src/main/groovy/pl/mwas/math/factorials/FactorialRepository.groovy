package pl.mwas.math.factorials

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FactorialRepository extends CrudRepository<Factorial, BigDecimal> {
    List<Factorial> findByBaseLessThan(BigDecimal base)
}
