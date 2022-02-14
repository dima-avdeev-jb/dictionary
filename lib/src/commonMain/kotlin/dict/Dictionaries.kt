package dict

fun MutableList<Word>.word(hint: String, secret: String) {
    add(Word(hint, secret))
}

val allDictionaries: Iterable<Dictionary> by lazy {
    buildList {
        add(dictionary1)
        add(dictionary2)
        add(dictionary3)
        add(dictionary4)
        add(dictionary5)
        add(dictionaryGrammar)
    }
}
