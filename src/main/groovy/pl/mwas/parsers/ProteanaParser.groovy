package pl.mwas.parsers


interface ProteanaParser {
    List parse(List<String> inputLines)
    List parseFromFile(String path)
}