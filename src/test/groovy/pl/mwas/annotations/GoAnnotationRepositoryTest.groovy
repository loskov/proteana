package pl.mwas.annotations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import pl.mwas.ProteanaApp
import spock.lang.Specification

@ContextConfiguration(classes = ProteanaApp)
class GoAnnotationRepositoryTest extends Specification {


    @Autowired
    GoAnnotationRepository repository

    def setup() {
        repository.save(new GoAnnotation("UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t"))
        repository.save(new GoAnnotation("UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005507\tGO_REF:0000002\tIEA\tInterPro:IPR001695|InterPro:IPR019828\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t"))
        repository.save(new GoAnnotation("UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0006898\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tP\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160410\tGOC\t\t"))
        repository.save(new GoAnnotation("UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0016020\tGO_REF:0000002\tIEA\tInterPro:IPR001190|InterPro:IPR017448\tC\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t"))
        repository.save(new GoAnnotation("UniProtKB\tA0A0A0MQ33\tTMEM173\t\tGO:0002218\tGO_REF:0000002\tIEA\tInterPro:IPR029158\tP\tStimulator of interferon genes protein\tA0A0A0MQ33_CHICK|TMEM173\tprotein\ttaxon:9031\t20160409\tInterPro\t\t"))
    }

    def cleanup() {
        repository.deleteAll()
    }

    def "test findAll"() {
        when:
            def all = repository.findAll()
        then:
            assert all.size() == 5
    }

    def "test findByGoId"() {
        given:
            def expected = new GoAnnotation("UniProtKB\tA0A0A0MQ32\tLOXL2\t\tGO:0005044\tGO_REF:0000002\tIEA\tInterPro:IPR001190\tF\tLysyl oxidase homolog 2\tA0A0A0MQ32_CHICK|LOXL2\tprotein\ttaxon:9031\t20160409\tInterPro\t\t")
        when:
            def actual = repository.findByGoId('GO:0005044')
        then:
            assert actual.size() == 1
            assert actual.contains(expected)
    }

    def "test findByDbId"() {
        when:
            def actual = repository.findByDbId('A0A0A0MQ32')
        then:
            assert actual.size() == 4
    }
}
