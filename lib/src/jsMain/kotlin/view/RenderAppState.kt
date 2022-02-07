package view

import androidx.compose.runtime.Composable
import dict.*
import lib.*
import mvi.Intent
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
            Div {
//                css {
//                fontSize = 24.pt
//                }
                Text("Обновление словарей: " + state.deployTime)
            }

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
                    Div {
                        Text("Знаешь слово ?")
                        Br { }
                        Br { }
                        TxtButton("Показать перевод") {
                            sendIntent(Intent.OpenWord)
                        }
                        Br { }
                        Br { }
                        Div {
//                            css {
//                                fontWeight = FontWeight.bold
//                                fontSize = WORD_PT
//                            }
                            Text(state.screen.word.hint)
                        }
                        Br {}
                        TxtButton("Да", YES_NO_PT) {
                            //todo green
                            sendIntent(Intent.MarkWord(true))
                        }
                        Text("...")
                        TxtButton("Нет", YES_NO_PT) {
                            //todo dark red
                            sendIntent(Intent.MarkWord(false))
                        }
                    }
                }
                is WordState.Open -> {
                    Div {
                        Text("Знаешь слово ?")
                        Br {}
                        Br {}
                        Div {
//                            fontSize = WORD_PT
                            Text(state.screen.word.hint)
                        }
                        Br {}
                        Br {}
                        Div {
//                            css {
//                                fontWeight = FontWeight.bold
//                                fontSize = WORD_PT
//                            }
                            Text(state.screen.word.secret)
                        }
                        Br {}
                        TxtButton("Да", YES_NO_PT) {
                            //todo darkGreen
                            sendIntent(Intent.MarkWord(true))
                        }
                        Text("...")
                        TxtButton("Нет", YES_NO_PT) {
                            //todo dark red
                            sendIntent(Intent.MarkWord(false))
                        }
                    }
                }
                is WordState.Fail -> {
                    Div {
                        Text("Вот как правильно:")
                        Br {}
                        Br {}
                        Div {
//                            css {
//                                fontSize = WORD_PT
//                            }
                            Text(state.screen.word.hint)
                        }
                        Br {}
                        Br {}
                        Div {
//                            css {
//                                fontWeight = FontWeight.bold
//                                fontSize = WORD_PT
//                            }
                            Text(state.screen.word.secret)
                        }
                        Br {}
                        TxtButton("Дальше", YES_NO_PT) {
                            sendIntent(Intent.NextWord)
                        }
                    }
                }
            }
            Br {}
            Br {}
            Div {
//                css {
//                    fontSize = 20.pt
//                    color = Color.gray
//                }
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
fun TxtButton(label: String, size: Int = 30, action: () -> Unit) {
    Button(
        attrs = {
            this.onClick {
                action()
            }
        }
    ) {
        Text(label)
    }
}
