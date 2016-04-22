package pl.mwas.files

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UniprotIdReader implements ProteanaFileReader {

    private ArrayList<String> lines
    private static final Logger log = LoggerFactory.getLogger(UniprotIdReader)

    UniprotIdReader() { lines = [] }

    @Override
    public ArrayList<String> readFileFromPath(String path) {
        log.debug("Reading files form file: " + path)
        lines = new File(path).readLines()

        log.debug("Lines read: " + lines.size())
        //uniprot ids have to match [OPQ][0-9][A-Z0-9]{3}[0-9]|[A-NR-Z][0-9]([A-Z][A-Z0-9]{2}[0-9]){1,2}
        //according to: http://www.uniprot.org/help/accession_numbers
        log.debug("Line useful: " + lines.parallelStream()
                .filter({ it.matches("[OPQ][0-9][A-Z0-9]{3}[0-9]|[A-NR-Z][0-9]([A-Z][A-Z0-9]{2}[0-9]){1,2}") }).count())
        log.debug(lines.toString())
        return lines.parallelStream()
                .filter({
            it.matches("[OPQ][0-9][A-Z0-9]{3}[0-9]|[A-NR-Z][0-9]([A-Z][A-Z0-9]{2}[0-9]){1,2}")
        }).collect()
    }
}
