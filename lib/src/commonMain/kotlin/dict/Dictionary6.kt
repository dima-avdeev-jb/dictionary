package dict

@OptIn(ExperimentalStdlibApi::class)
val dictionary6
    get() = Dictionary(
        name = "Англо - русский",
        useByDefault = true,
        words = buildList {
            word("opinion, opinionated", "мнение, самоуверенный упрямый")
            word("suddenly", "случайно")
            word("dock, docking", "причал стыковка")
            word("Yours sincerely", "искренне Ваш")
            word("crucial", "решающий ключевой")
            word("curious", "любопытный интересно")
            word("float", "плавать")
            word("comprehensive", "всесторонний, всеобъемлющий")
            word("bound, boundary", "связанный, граница")
            word("streamline", "упорядочить, рационализировать")
            word("", "")
            word("", "")
            word("", "")
            word("", "")
        }
    )
