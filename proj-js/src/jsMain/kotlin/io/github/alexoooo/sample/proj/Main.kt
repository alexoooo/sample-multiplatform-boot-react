package io.github.alexoooo.sample.proj

import kotlinx.browser.window
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import web.html.HTMLElement


fun main() {
    val rootHtmlElementId = "react-app"

    fun emptyRootElement(): HTMLElement {
        val rootElement = web.dom.document.getElementById(rootHtmlElementId)
            ?: throw IllegalStateException("'$rootHtmlElementId' element not found")

        while (rootElement.hasChildNodes()) {
            rootElement.removeChild(rootElement.firstChild!!)
        }
        return rootElement
    }

    window.onload = {
        val rootElement = emptyRootElement()

        createRoot(rootElement).render(App.create())
    }
}


private val App = FC<Props> {
    +"Hello, world!"
}