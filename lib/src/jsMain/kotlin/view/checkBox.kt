package view

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.CheckboxInput
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun CheckBox(
    label: String,
    value: Boolean,
    onClick: () -> Unit
) {
    Div() {
        CheckboxInput(checked = value, attrs = {
            this.onChange {
                onClick()
            }
        })
        Span(attrs = {
            this.onClick {
                onClick()
            }
        }) {
            Text(label)
        }
    }
}
