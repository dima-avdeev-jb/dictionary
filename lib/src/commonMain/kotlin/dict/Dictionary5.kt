package dict

@OptIn(ExperimentalStdlibApi::class)
val dictionary5
    get() = Dictionary(
        name = "Русско-английский ",
        useByDefault = true,
        words = buildList {
            word("захватывающий", "breathtaking")
            word("научная фантастика", "science fiction (Sci-fi)")
            word("оценить", "estimate")
        }
    )
