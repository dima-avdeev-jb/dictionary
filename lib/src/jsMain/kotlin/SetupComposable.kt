import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.job
import mvi.*
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.Div
import view.RenderAppState

@Composable
fun SetupComposable() {
    val viewScope = rememberCoroutineScope()
    val ioScope = remember { CoroutineScope(SupervisorJob(viewScope.coroutineContext.job) + Dispatchers.Default) }

    val store = remember { viewScope.createStore() }
    val state by store.stateFlow.collectAsState()
    Div({
        style {
            textAlign("center")
        }
    }) {
        RenderAppState(state) {
            store.send(it)
        }
    }
}

