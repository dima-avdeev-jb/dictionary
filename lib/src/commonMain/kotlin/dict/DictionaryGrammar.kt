package dict

@OptIn(ExperimentalStdlibApi::class)
val dictionaryGrammar
    get() = Dictionary(
        name = "Grammar",
        useByDefault = true,
        words = buildList {
            word("формы be", "am/is/are, прошедшее was/were")
            word("формы have", "have/has, had")
            word("вспомогательные глаголы", "be, have, do")
            word("просить", "ask for")
            word("ждать", "wait for")
            word("искать", "look for, lookup, seek")
            word("слушать", "listen to")
            word("принадлежит ему", "belong to him")
            word("объясни ей", "explain to her")
            word("выпуститься из", "graduated from")
            word("Я сомневаюсь", "I doubt")
            word("", "")
        }
    )
