@OptIn(ExperimentalStdlibApi::class)
val dictionary2
    get() = Dictionary(
        name = "Англо-русский 2",
        useByDefault = false,
        words = buildList {
            word("facets","грани")
            word("cadence","каденция")
            word("insight","в поле зрения")
            word("facilitate","облегчить")
        }
    )

