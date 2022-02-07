package view

import androidx.compose.runtime.Composable
import dict.*
import lib.*
import mvi.Intent
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date

val YES_NO_PT = 90
val WORD_PT = 44

@Composable
fun RenderAppState(state: State, sendIntent: (Intent) -> Unit) {
    when (state.screen) {
        is Screen.Dictionaries -> {
            TxtButton("Очистить статистику") {
                BrowserStorage.clear()
            }
            Txt("Обновление словарей: " + state.deployTime, 24)
            allDictionaries.forEach { dictionary: Dictionary ->
                Div {
                    val selected = state.screen.selected.contains(dictionary)
                    CheckBox(
                        "Словарь ${dictionary.name} (${dictionary.words.size} слов)",
                        selected
                    ) {
                        sendIntent(Intent.ChooseDictionary(dictionary))
                    }
                }
            }
            TxtButton("Начать", YES_NO_PT) {
                sendIntent(Intent.StartWordScreen)
            }
        }
        is Screen.Words -> {
            when (state.screen.wordState) {
                is WordState.Hidden -> {
                    Text("Знаешь слово ?")
                    Br { }
                    Br { }
                    TxtButton("Показать перевод") {
                        sendIntent(Intent.OpenWord)
                    }
                    Br { }
                    Br { }
                    Txt(state.screen.word.hint, WORD_PT, "bold")
                    Br {}
                    GreenBtn("Да") {
                        sendIntent(Intent.MarkWord(true))
                    }
                    Text("...")
                    RedBtn("Нет") {
                        sendIntent(Intent.MarkWord(false))
                    }
                }
                is WordState.Open -> {
                    Text("Знаешь слово ?")
                    Br {}
                    Br {}
                    Txt(state.screen.word.hint, WORD_PT)
                    Br {}
                    Br {}
                    Div({
                        style {
                            fontWeight("bold")
                            fontSize(WORD_PT.pt)
                        }
                    }) {
                        Text(state.screen.word.secret)
                    }
                    Br {}
                    GreenBtn("Да") {
                        sendIntent(Intent.MarkWord(true))
                    }
                    Text("...")
                    RedBtn("Нет") {
                        sendIntent(Intent.MarkWord(false))
                    }
                }
                is WordState.Fail -> {
                    Text("Вот как правильно:")
                    Br {}
                    Br {}
                    Txt(state.screen.word.hint, WORD_PT)
                    Br {}
                    Br {}
                    Txt(state.screen.word.secret, WORD_PT, "bold")
                    Br {}
                    TxtButton("Дальше", YES_NO_PT) {
                        sendIntent(Intent.NextWord)
                    }
                }
            }
            Br {}
            Br {}
            Div({
                style {
                    fontSize(20.pt)
                    color(Color("gray"))
                }
            }) {
                val stat = BrowserStorage.getItem(state.screen.word.hint) ?: StoreItem()
                Text("Статистика по этоу слову:")
                Br {}
                Br {}
                Text("успех: ${stat.successCount}, ошибка: ${stat.failCount},")
                Br {}
                Br {}
                Text(
                    "изменение: " + if (stat.changedUnixTime == 0) "новое слово" else Date(stat.changedUnixTime * 1000L).toLocaleString()
                )
            }
        }
    }

}

@Composable
fun TxtButton(label: String, size: Int = 30, styleBuilder: StyleBuilder.() -> Unit = {}, action: () -> Unit) {
    Button(
        attrs = {
            this.onClick {
                action()
            }
        }
    ) {
        Div({
            style {
                fontSize(size.pt)
                styleBuilder()
            }
        }) {
            Text(label)
        }
    }
}

@Composable
fun GreenBtn(label: String, action: () -> Unit) {
    TxtButton(label, size = YES_NO_PT, {
        color(Color("#006400"))
    }, action)
}

@Composable
fun RedBtn(label: String, action: () -> Unit) {
    TxtButton(label, size = YES_NO_PT, {
        color(Color("#8B0000"))
    }, action)
}

@Composable
fun Txt(label: String, size: Int, weight:String = "normal") {
    Div({
        style {
            fontSize(size.pt)
            fontWeight(weight)
        }
    }) {
        Text(label)
    }
}
