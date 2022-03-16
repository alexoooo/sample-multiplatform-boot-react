@file:JsModule("@mui/icons-material")
package io.github.alexoooo.sample.proj.wrap

import react.Component
import react.ReactElement
import react.State
import kotlin.js.Json


external interface IconProps: react.Props {
    var title: String
    var style: Json
    var onClick: () -> Unit
}


@JsName("PanoramaFishEye")
external class PanoramaFishEyeIcon: Component<IconProps, State> {
    override fun render(): ReactElement<IconProps>?
}

@JsName("Close")
external class CloseIcon: Component<IconProps, State> {
    override fun render(): ReactElement<IconProps>?
}

@JsName("SelectAll")
external class SelectAllIcon: Component<IconProps, State> {
    override fun render(): ReactElement<IconProps>?
}