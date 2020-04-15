package io.github.alexoooo.sample.proj.view

import io.github.alexoooo.sample.lib.ClassName
import io.github.alexoooo.sample.lib.Mirror
import kotlinx.coroutines.CoroutineScope
import kotlinx.css.*
import react.*
import react.dom.div
import styled.StyleSheet
import styled.css
import styled.styledA
import styled.styledDiv


private object ApplicationStyles : StyleSheet("ApplicationStyles", isStatic = true) {
    val wrapper by css {
        padding(32.px, 16.px)
    }

    val post by css {
        marginBottom = 32.px
    }
}

interface ApplicationProps : RProps {
    var coroutineScope: CoroutineScope
}

class ApplicationState : RState {
//    var postWithComments: List<PostWithComments> = emptyList()
//    var users: List<User> = emptyList()
}

class ApplicationComponent : RComponent<ApplicationProps, ApplicationState>() {
    init {
        state = ApplicationState()
    }

    private val coroutineContext
        get() = props.coroutineScope.coroutineContext


    override fun RBuilder.render() {
        div {
            styledA("/") {
                css {
                    specific {
                        paddingLeft = 48.px
                    }
                }
                +"hello world!!!"
            }
        }

        styledDiv {
            css {
                +ApplicationStyles.wrapper
            }

            val commonModelClass = ClassName(
                "io.github.alexoooo.sample.lib.model.CommonModel")
            val commonModelExists = Mirror.contains(commonModelClass)

            val projJsMainModelClass = ClassName(
                "io.github.alexoooo.sample.proj.model.ProjJsMainModel")
            val projJsMainModelExists = Mirror.contains(projJsMainModelClass)

            +"test hello: $commonModelExists - $projJsMainModelExists"

            child(CounterComponent::class) {}

            child(CounterComponent::class) {}

            child(CounterComponent::class) {}
        }
    }
}
