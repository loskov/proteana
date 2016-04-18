package pl.mwas.annotations

import groovy.transform.ToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
@ToString(includePackage = false)
class GoAnnotation {

    private static final Logger log = LoggerFactory.getLogger(GoAnnotation)
    
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

    GoAnnotation(String line) {
        if (line != null) {
            String[] fields = line.split('\t', -1)
            this.db = fields[0]
            this.dbId = fields[1]
            this.dbSymbol = fields[2]
            this.qualifiers = parseComplexString(fields[3])
            this.goId = fields[4]
            this.dbReference = parseComplexString(fields[5])
            this.evidenceCode = fields[6]
            this.withOrFrom = parseComplexString(fields[7])
            this.aspect = fields[8]
            this.dbName = fields[9]
            this.dbSynonym = parseComplexString(fields[10])
            this.dbType = fields[11]
            this.taxon = parseComplexString(fields[12])
            this.date = fields[13]
            this.assignedBy = fields[14]
            this.annotationExtension = parseComplexString(fields[15])
            this.geneProduct = fields[16]
        } else {
            log.error("GoAnnotation received an empty line")
            throw new IllegalArgumentException("GoAnnotation received an empty line")
        }
        log.debug(this.toString())
    }

    private final static ArrayList<String> parseComplexString(String complex) {
        if (!complex.equals("")) {
            String[] propertyList = complex.split("\\|", -1)
            if (propertyList.length != 0) {
                return Arrays.asList(propertyList)
            }
        }
        return [];
    }
}
