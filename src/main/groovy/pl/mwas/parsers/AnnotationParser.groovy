package pl.mwas.parsers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.mwas.annotations.GoAnnotation


class AnnotationParser implements ProteanaParser {

    private static final Logger log = LoggerFactory.getLogger(AnnotationParser)

    @Override
    List<GoAnnotation> parse(List<String> inputLines) {
        log.debug("Parsing ${inputLines.size()} annotations...")
        return inputLines.collect{new GoAnnotation(it)}
    }
}
