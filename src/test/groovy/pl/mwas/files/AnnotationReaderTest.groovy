package pl.mwas.files

import spock.lang.Specification


class AnnotationReaderTest extends Specification {
    def "test AnnotationReader"() {
        given:
            String sampleFile = 'build/resources/test/fileSamples/annotationSample'
            AnnotationReader reader = new AnnotationReader()
            def expectedSample = ["UniProtKB	A0A0A0MQ32	LOXL2		GO:0005044	GO_REF:0000002	IEA	InterPro:IPR001190	F	Lysyl oxidase homolog 2	A0A0A0MQ32_CHICK|LOXL2	protein	taxon:9031	20160409	InterPro",
                                  "UniProtKB	A0A0A0MQ32	LOXL2		GO:0005507	GO_REF:0000002	IEA	InterPro:IPR001695|InterPro:IPR019828	F	Lysyl oxidase homolog 2	A0A0A0MQ32_CHICK|LOXL2	protein	taxon:9031	20160409	InterPro",
                                  "UniProtKB	A0A0A0MQ32	LOXL2		GO:0006898	GO_REF:0000002	IEA	InterPro:IPR001190	P	Lysyl oxidase homolog 2	A0A0A0MQ32_CHICK|LOXL2	protein	taxon:9031	20160410	GOC",
                                  "UniProtKB	A0A0A0MQ32	LOXL2		GO:0016020	GO_REF:0000002	IEA	InterPro:IPR001190|InterPro:IPR017448	C	Lysyl oxidase homolog 2	A0A0A0MQ32_CHICK|LOXL2	protein	taxon:9031	20160409	InterPro",
                                  "UniProtKB	A0A0A0MQ32	LOXL2		GO:0016641	GO_REF:0000002	IEA	InterPro:IPR001695|InterPro:IPR019828	F	Lysyl oxidase homolog 2	A0A0A0MQ32_CHICK|LOXL2	protein	taxon:9031	20160409	InterPro"]
        when:
            def result = reader.readFileFromPath(sampleFile)
        then:
            assert result.size() == 5
            assert result == expectedSample
    }
}
