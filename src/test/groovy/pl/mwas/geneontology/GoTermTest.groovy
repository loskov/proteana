package pl.mwas.geneontology

import spock.lang.Specification


class GoTermTest extends Specification {
    def 'create new GoTerm'() {
        given:
            GoTerm goTerm = new GoTerm()
        when:
            goTerm.id('GO:09812312').name('a GoTerm')
        then:
            assert goTerm.id == 'GO:09812312'
            assert goTerm.name == 'a GoTerm'
    }
}
