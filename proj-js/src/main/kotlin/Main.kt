import io.github.alexoooo.sample.lib.ModuleRegistry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import react.buildElement
import react.dom.render
import view.ApplicationComponent
import kotlin.browser.document
import kotlin.coroutines.CoroutineContext


private class Application : CoroutineScope {
    override val coroutineContext: CoroutineContext = Job()

    fun start() {
        document.getElementById("react-app")?.let {
            render(buildElement {
                child(ApplicationComponent::class) {
                    attrs.coroutineScope = this@Application
                }
            }, it)
        }
    }
}


fun main() {
    ModuleRegistry.add(js("require('lib-lib-common')"))

    GlobalStyles.inject()

    Application().start()
}