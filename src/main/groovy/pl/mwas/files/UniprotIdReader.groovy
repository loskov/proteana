package pl.mwas.files

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UniprotIdReader {
    /**
     ** matches   [OPQ][0-9][A-Z0-9]{3}[0-9]|[A-NR-Z][0-9]([A-Z][A-Z0-9]{2}[0-9]){1,2}
     ** http://www.uniprot.org/help/accession_numbers
     **/

    private ArrayList<String> lines
    private static final Logger log = LoggerFactory.getLogger(UniprotIdReader.class)

    UniprotIdReader() { lines = [] }

    public ArrayList<String> readFileFromPath(String path) {
        log.debug("Reading files form file: " + path)
        lines = new File(path).readLines()
        log.info("just for test")
        return lines.parallelStream()
                .filter({it.matches("[OPQ][0-9][A-Z0-9]{3}[0-9]|[A-NR-Z][0-9]([A-Z][A-Z0-9]{2}[0-9]){1,2}")})
                .collect()
    }
}
