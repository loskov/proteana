package pl.mwas.annotations

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@EqualsAndHashCode(includes = 'db,dbId,goId,dbName')
@ToString(includePackage = false, excludes = "id")
class GoAnnotation {

    private static final Logger log = LoggerFactory.getLogger(GoAnnotation)

    @Id
    @GeneratedValue
    Long id

    String db
    String dbId
    String dbSymbol
    ArrayList<String> qualifiers
    String goId
    ArrayList<String> dbReference
    String evidenceCode
    ArrayList<String> withOrFrom
    String aspect
    String dbName
    ArrayList<String> dbSynonym
    String dbType
    ArrayList<String> taxon
    String date
    String assignedBy
    ArrayList<String> annotationExtension
    String geneProduct

    protected GoAnnotation() {}

    GoAnnotation(String line) {
        String[] fields = line?.split('\t', -1)
        if (fields?.size() != 17) {
            log.error("GoAnnotation received an malformed line")
            throw new IllegalArgumentException("GoAnnotation received an malformed line")
        } else {
            db = fields[0]
            dbId = fields[1]
            dbSymbol = fields[2]
            qualifiers = parseComplexString(fields[3])
            goId = fields[4]
            dbReference = parseComplexString(fields[5])
            evidenceCode = fields[6]
            withOrFrom = parseComplexString(fields[7])
            aspect = fields[8]
            dbName = fields[9]
            dbSynonym = parseComplexString(fields[10])
            dbType = fields[11]
            taxon = parseComplexString(fields[12])
            date = fields[13]
            assignedBy = fields[14]
            annotationExtension = parseComplexString(fields[15])
            geneProduct = fields[16]

            log.debug(this.toString())
        }
        
    }

    private final static ArrayList<String> parseComplexString(String complex) {
        String[] propertyList = complex.empty ? [] : complex?.split("\\|", -1)
        return Arrays.asList(propertyList)
    }
}
