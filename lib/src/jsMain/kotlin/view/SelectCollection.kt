package view

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun SelectCollection(
    selectionTitle: String,
    currentValue: String?,
    values: List<String>,
    onSelected: (String) -> Unit
) {
    fun onSelect2(str: String) {
        println("onSelect2($str")
        onSelected(str)
    }
    Text("$selectionTitle: ")
    val NOT_SELECTED = "choose..."
    val current = currentValue ?: NOT_SELECTED
    Select(attrs = {
        onChange {
            val result = it.value
            if (result != null) {
                onSelect2(result)
            }
        }
    }) {
        Option(current, attrs = {
            //disabled()
        }) {
            Text(current)
        }
        values.forEach {
            Option(it) {
                Text(it)
            }
        }
    }
}
