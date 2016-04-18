package pl.mwas.files

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AnnotationReader implements ProteanaFileReader {

    private ArrayList<String> lines
    private static final Logger log = LoggerFactory.getLogger(AnnotationReader.class)

    AnnotationReader() { lines = [] }

    @Override
    ArrayList<String> readFileFromPath(String path) {
        log.debug("Reading files form file: " + path)
        lines = new File(path).readLines()

        log.debug("Lines read: " + lines.size())
        log.debug("Line useful: " + lines.parallelStream().filter({ !it.startsWith("!") }).count())
        return lines.parallelStream().filter({ !it.startsWith("!") }).collect()
    }
}
