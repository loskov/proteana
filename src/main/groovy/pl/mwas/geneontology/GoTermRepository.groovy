package pl.mwas.geneontology

import org.springframework.data.repository.CrudRepository

interface GoTermRepository extends CrudRepository<GoTerm, String> {

    List<GoTerm> findGoTermById(String id)
}
