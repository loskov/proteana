package pl.mwas.annotations

import pl.mwas.files.AnnotationReader
import spock.lang.Specification


class GoAnnotationTest extends Specification {
    def "test GoAnnotation construction"() {
        given:
            String testFile = 'build/resources/test/fileSamples/annotationSample'
            AnnotationReader reader = new AnnotationReader()
            List<String> annotations = reader.readFileFromPath(testFile)
        when:
            List<GoAnnotation> actual = annotations.collect { new GoAnnotation(it) }
        then:
            assert actual.size() == 5
            assert actual.every { it.dbId == 'A0A0A0MQ32' }
            assert actual.collect { it.goId }.containsAll(['GO:0005044', 'GO:0005507', 'GO:0006898', 'GO:0016020', 'GO:0016641'])
    }
}
