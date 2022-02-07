import mvi.Intent
import kotlinx.browser.document
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        SetupComposable()
    }
}
