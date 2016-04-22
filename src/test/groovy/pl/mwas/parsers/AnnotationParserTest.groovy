package pl.mwas.parsers

import pl.mwas.files.AnnotationReader
import spock.lang.Specification


class AnnotationParserTest extends Specification {
    def "test parse"() {
        given:
            String testFile = 'build/resources/test/fileSamples/annotationSample'
            AnnotationReader reader = new AnnotationReader()
            AnnotationParser parser = new AnnotationParser()
            List<String> annotations = reader.readFileFromPath(testFile)
        when:
            def actual = parser.parse(annotations)
        then:
            testSampleData(actual)
    }

    def "test parse from file"() {
        given:
            String testFile = 'build/resources/test/fileSamples/annotationSample'
            AnnotationParser parser = new AnnotationParser()
        when:
            def actual = parser.parseFromFile(testFile)
        then:
            testSampleData(actual)
    }

    void testSampleData(actual) {
        assert actual.size() == 5
        assert actual.every { it.dbId == 'A0A0A0MQ32' }
        assert actual.collect {
            it.goId
        }.containsAll(['GO:0005044', 'GO:0005507', 'GO:0006898', 'GO:0016020', 'GO:0016641'])
    }
}
