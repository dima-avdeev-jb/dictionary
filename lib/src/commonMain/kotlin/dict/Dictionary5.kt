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
            word("жду с нетерпением", "looking forward to")
            word("(вредоносное ПО)", "mallware (mallicious sofrware)")
            word("мелкая копия", "shallow copy")
            word("@ Собака", "[æt] или [et]")
            word("дыхание", "breath")
            word("ширина", "width, breadth")
            word("толщина", "thickness")
            word("явный", "explicit")
            word("не явный", "implicit")
            word("устранять неоднозначность", "disambiguate")
            word("двусмысленно, неоднозначно", "ambiguous")
            word("копить, заначка", "stash")
            word("предложить", "propose")
            word("усиление", "enhancement")

        }
    )
