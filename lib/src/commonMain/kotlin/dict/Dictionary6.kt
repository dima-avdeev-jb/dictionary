package dict

@OptIn(ExperimentalStdlibApi::class)
val dictionary6
    get() = Dictionary(
        name = "Англо - русский",
        useByDefault = true,
        words = buildList {
            word("opinion, opinionated", "мнение, самоуверенный упрямый")
            word("suddenly", "случайно")
            word("", "")
        }
    )
