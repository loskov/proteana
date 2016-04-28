package pl.mwas.geneontology

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OntologyReader {

    @Autowired
    GoTermRepository ontology

    private GoTerm currGoTerm
    private boolean newTermStarted

    def readOntologyFrom(String path) {
        File aFile = new File(path)

        aFile.eachLine {
            parse(it)
        }
    }

    def private parse(String line) {
        String prefix = grepPrefix(line)
        String body = grepBody(line)
        grepComment(line)

        parseTerms(prefix, body)
    }

    def private parseTerms(String prefix, String body) {
        switch (prefix) {
            case "[Term]":
                newTermStarted = true
                currGoTerm = new GoTerm(); break
            case "":
                if (newTermStarted) ontology.save(currGoTerm)
                newTermStarted = false; break
            case "id":
                currGoTerm.id = body; break
            case "name":
                currGoTerm.name = body; break
            case "namespace":
                currGoTerm.namespace = body; break
            case "is_anonymous":
                currGoTerm.anonymous = body; break
            case "alt_id":
                currGoTerm.altId.add(body); break
            case "def":
                currGoTerm.definition = body; break
            case "comment":
                currGoTerm.comment = body; break
            case "subset":
                currGoTerm.subsets.add(body); break
            case "synonym":
                currGoTerm.synonym.add(body); break
            case "xref":
                currGoTerm.xRef.add(body); break
            case "is_a":
                currGoTerm.isA.add(body); break
            case "intersection_of":
                currGoTerm.intersectionOf.add(body); break
            case "union_of":
                currGoTerm.unionOf.add(body); break
            case "disjoint_from":
                currGoTerm.disjointFrom.add(body); break
            case "relationship":
                def relationship = body.split(" ")
                currGoTerm.relationship.put(relationship[0], relationship[1]); break
            case "is_obsolete":
                currGoTerm.obsolete = body; break
            case "replaced_by":
                currGoTerm.replacedBy.add(body); break
            case "consider":
                currGoTerm.consider.add(body); break
            case "created_by":
                currGoTerm.createdBy = body; break
            case "creation_date":
                currGoTerm.creationDate = body; break
            default:
                break
        }
    }

    private static String grepPrefix(String line) {
        if (!line.contains(":")) return line
        return line.substring(0, line.indexOf(":")).trim()
    }

    private static String grepBody(String line) {
        if (line.contains("\"")) {
            return line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\"")).trim()
        } else if (line.contains("!")) {
            return line.substring(line.indexOf(":") + 1, line.lastIndexOf("!")).trim()
        } else {
            return line.substring(line.indexOf(":") + 1).trim()
        }
    }

    private static String grepComment(String line) {
        if (line.contains("!")) {
            return line.substring(line.lastIndexOf("!") + 1).trim()
        } else if (line.contains("\"")) {
            return line.substring(line.lastIndexOf("\""))
        } else {
            return ""
        }
    }
}

