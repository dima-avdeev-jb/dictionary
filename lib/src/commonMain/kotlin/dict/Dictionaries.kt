package dict

fun MutableList<Word>.word(hint: String, secret: String) {
    add(Word(hint, secret))
}

val allDictionaries: List<Dictionary> = listOf(
    dictionary1,
    dictionary2,
    dictionary4,
    dictionary5,
    dictionary6,
    dictionaryGrammar,
)
