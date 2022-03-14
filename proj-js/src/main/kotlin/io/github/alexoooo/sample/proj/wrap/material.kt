@file:JsModule("@material-ui/core")
package io.github.alexoooo.sample.proj.wrap

import org.w3c.dom.HTMLButtonElement
import react.Component
import react.ReactElement
import react.State
import kotlin.js.Json


@JsName("IconButton")
external class MaterialIconButton: Component<MaterialIconButtonProps, State> {
    override fun render(): ReactElement<MaterialIconButtonProps>?
}

external interface MaterialIconButtonProps: react.Props {
    //    var id: String
//    var variant: String
    var title: String

    var disabled: Boolean

    var size: String
    var color: String
    var style: Json

    var onClick: () -> Unit
    var onMouseOver: () -> Unit
    var onMouseOut: () -> Unit

    var buttonRef: (e: HTMLButtonElement?) -> Unit
}