package pl.mwas.annotations

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GoAnnotationRepository extends CrudRepository<GoAnnotation, Long> {

    List<GoAnnotation> findByDbId(String dbId)

    List<GoAnnotation> findByGoId(String goId)
}
