package pl.mwas.geneontology

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import pl.mwas.ProteanaApp
import spock.lang.Specification

@ContextConfiguration(classes = ProteanaApp)
class OntologyReaderTest extends Specification {
    
    @Autowired
    OntologyReader reader
    
    def "test readOntologyFrom"() {
        given:
            String testFile = 'build/resources/test/fileSamples/go-sample.obo'
        when:
            reader.readOntologyFrom(testFile)
        then:
            assert reader.getOntology().count() == 9
    }
}
