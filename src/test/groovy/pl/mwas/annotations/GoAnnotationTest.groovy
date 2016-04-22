package pl.mwas.annotations

import spock.lang.Specification

class GoAnnotationTest extends Specification {

    def 'test proper GoAnnotation()'() {
        given:
            String testLine = 'UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t'
        when:
            GoAnnotation annotation = new GoAnnotation(testLine)
        then:
            assert annotation.db == 'UniProtKB'
            assert annotation.dbId == 'A0A0A0MQ32'
            assert annotation.dbSymbol == 'LOXL2'
            assert annotation.qualifiers == []
            assert annotation.goId == 'GO:0005044'
            assert annotation.dbReference == ['GO_REF:0000002']
            assert annotation.evidenceCode == 'IEA'
            assert annotation.withOrFrom == ['InterPro:IPR001190']
            assert annotation.aspect == 'F'
            assert annotation.dbName == 'Lysyl oxidase homolog 2'
            assert annotation.dbSynonym == ['A0A0A0MQ32_CHICK','LOXL2']
            assert annotation.dbType == 'protein'
            assert annotation.taxon == ['taxon:9031']
            assert annotation.date == '20160409'
            assert annotation.assignedBy == 'InterPro'
            assert annotation.annotationExtension == []
            assert annotation.geneProduct == ''
    }

    def 'create GoAnnotation from null'() {
        given:
            String testLine = null
        when:
            new GoAnnotation(testLine)
        then:
            thrown(IllegalArgumentException)
    }
    
    def 'create GoAnnotation from malformed'() {
        given:
            String testLine = 'UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002'
        when:
            new GoAnnotation(testLine)
        then:
            thrown(IllegalArgumentException)
    }
    
    def 'test equality and hashcode'() {
        when:
            GoAnnotation goThis = new GoAnnotation('UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t')
            GoAnnotation goAnother = new GoAnnotation('UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t')
        then:
            assert goThis == goAnother
            assert goThis.hashCode() == goAnother.hashCode()
    }
}
