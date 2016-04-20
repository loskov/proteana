package pl.mwas.parsers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.mwas.annotations.GoAnnotation
import pl.mwas.files.AnnotationReader


class AnnotationParser implements ProteanaParser {

    private static final Logger log = LoggerFactory.getLogger(AnnotationParser)

    @Override
    List<GoAnnotation> parse(List<String> inputLines) {
        log.debug("Parsing ${inputLines.size()} annotations...")
        return inputLines.collect{new GoAnnotation(it)}
    }

    @Override
    List<GoAnnotation> parseFromFile(String path) {
        log.debug("Parsing GoAnnotations form file: " + path)
        AnnotationReader reader = new AnnotationReader()
        def annots = reader.readFileFromPath(path)
        return parse(annots)
    }
}
