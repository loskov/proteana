package pl.mwas.geneontology

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GoTermRepository extends CrudRepository<GoTerm, String> {

    List<GoTerm> findGoTermById(String id)
}
