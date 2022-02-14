package dict

@OptIn(ExperimentalStdlibApi::class)
val dictionaryGrammar
    get() = Dictionary(
        name = "Grammar",
        useByDefault = true,
        words = buildList {
            word("формы be", "as/is/are, was/where")
            word("формы have", "have/has, had")
            word("вспомогательные глаголы", "be, have, do")
            word("", "")
        }
    )
