@OptIn(ExperimentalStdlibApi::class)
val dictionary3
    get() = Dictionary(
        name = "Song en-ru",
        useByDefault = false,
        words = buildList {
            word("The innocent can never last","Невинность не может длиться вечно")
            word("come to pass","сбыться")
            word("pass","проходят")
            word("drenched","залит, пропитан")
            word("rest","отдых")
        }
    )
