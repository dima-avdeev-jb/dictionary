import mvi.Intent
import mvi.store
import kotlinx.browser.document

fun main() {
    renderComposable(rootElementId = "root") {
        SetupComposable()
    }
}
