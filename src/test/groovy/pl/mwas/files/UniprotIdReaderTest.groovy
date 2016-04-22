package pl.mwas.files

import spock.lang.Specification


class UniprotIdReaderTest extends Specification {
    def 'reading uniprot ids form file'() {
        given:
            UniprotIdReader er = new UniprotIdReader()
            String path = "build/resources/test/fileSamples/uniprotSamples"
        when:
            def result = er.readFileFromPath(path)
        then:
            assert result.size() == 2
            assert result.containsAll(["P1AAA0", "A0AZZ0B001"])
    }
}
