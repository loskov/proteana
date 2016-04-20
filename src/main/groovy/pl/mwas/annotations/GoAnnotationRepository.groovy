package pl.mwas.annotations

import org.springframework.data.repository.CrudRepository


interface GoAnnotationRepository extends CrudRepository<GoAnnotation, Long> {
    List<GoAnnotation> findByDbId(String dbId)
    List<GoAnnotation> findByGoId(String goId)
}
