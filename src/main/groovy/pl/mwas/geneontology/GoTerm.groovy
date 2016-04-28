package pl.mwas.geneontology

import com.google.common.collect.HashMultimap
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import org.hibernate.type.TextType

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob

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

    @ElementCollection
    Set<String> altId

    @Lob
    String definition
    @Lob
    String comment

    @ElementCollection
    Set<String> subsets
    @ElementCollection
    Set<String> synonym
    @ElementCollection
    Set<String> xRef
    @ElementCollection
    Set<String> isA
    @ElementCollection
    Set<String> intersectionOf
    @ElementCollection
    Set<String> unionOf
    @ElementCollection
    Set<String> disjointFrom

    @Lob
    HashMultimap<String, String> relationship

    boolean obsolete
    @ElementCollection
    Set<String> replacedBy
    @ElementCollection
    Set<String> consider

    String createdBy
    String creationDate

    protected GoTerm() {
        id = ''
        name = ''
        namespace = ''
        anonymous = false
        definition = ''
        comment = ''
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
        obsolete = false
        createdBy = ''
        creationDate = ''
    }
}