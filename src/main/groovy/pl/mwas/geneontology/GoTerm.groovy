package pl.mwas.geneontology

import com.google.common.collect.HashMultimap
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

import javax.persistence.Entity
import javax.persistence.Id

@Builder(builderStrategy = SimpleStrategy, prefix = '')
@ToString(includePackage = false, includeNames = true)
@EqualsAndHashCode(includes = 'id,name,namespace,creationDate')
@Entity
class GoTerm {

//    private static final Logger log = LoggerFactory.getLogger(GoTerm)

    @Id
    String id
    String name
    String namespace

    boolean anonymous
    HashSet<String> altId
    String definition
    String comment
    HashSet<String> subsets
    HashSet<String> synonym
    HashSet<String> xRef
    HashSet<String> isA
    HashSet<String> intersectionOf
    HashSet<String> unionOf
    HashSet<String> disjointFrom
    HashMultimap<String, String> relationship
    boolean obsolete
    HashSet<String> replacedBy
    HashSet<String> consider
    String createdBy
    String creationDate

    protected GoTerm() {
        altId = new HashSet<>()
        subsets = new HashSet<>()
        synonym = new HashSet<>()
        xRef = new HashSet<>()
        isA = new HashSet<>()
        intersectionOf = new HashSet<>()
        unionOf = new HashSet<>()
        disjointFrom = new HashSet<>()
        relationship = HashMultimap.create()
        replacedBy = new HashSet<>()
        consider = new HashSet<>()
    }
}