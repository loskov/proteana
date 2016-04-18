package pl.mwas.files

import spock.lang.Specification


class AnnotationReaderTest extends Specification {
    def "test AnnotationReader"() {
        given:
            String sampleFile = 'build/resources/test/fileSamples/annotationSample'
            AnnotationReader reader = new AnnotationReader()
            def expectedSample = ["UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t",
                                  "UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005507\tGO_REF:0000002\tIEA\tInterPro:IPR001695|InterPro:IPR019828\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t",
                                  "UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0006898\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tP\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160410\tGOC\t\t",
                                  "UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0016020\tGO_REF:0000002\tIEA\tInterPro:IPR001190|InterPro:IPR017448\tC\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t",
                                  "UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0016641\tGO_REF:0000002\tIEA\tInterPro:IPR001695|InterPro:IPR019828\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t"]
        when:
            def result = reader.readFileFromPath(sampleFile)
        then:
            assert result.size() == 5
            assert result == expectedSample
    }
}
