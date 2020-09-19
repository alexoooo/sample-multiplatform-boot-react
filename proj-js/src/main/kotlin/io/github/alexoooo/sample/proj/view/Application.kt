package io.github.alexoooo.sample.proj.view

import io.github.alexoooo.sample.lib.ClassName
import io.github.alexoooo.sample.lib.Mirror
import kotlinx.coroutines.CoroutineScope
import kotlinx.css.marginBottom
import kotlinx.css.padding
import kotlinx.css.paddingLeft
import kotlinx.css.px
import react.*
import react.dom.br
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
    var ticTacToeState: TicTacToeState = TicTacToeState.empty
}


class ApplicationComponent : RPureComponent<ApplicationProps, ApplicationState>() {
    init {
        state = ApplicationState()
    }


    private fun handleClick(row: Int, col: Int) {
        setState {
            ticTacToeState = ticTacToeState.play(row, col)
        }
    }


    override fun RBuilder.render() {
        div {
            styledA("/") {
                css {
                    specific {
                        paddingLeft = 48.px
                    }
                }

                val commonModelClass = ClassName(
                    "io.github.alexoooo.sample.lib.model.CommonModel")

                val contains = Mirror.contains(commonModelClass)
                val constructorArgs = Mirror.constructorArgumentNames(commonModelClass)
                val sampleModel = Mirror.create(commonModelClass, listOf("foo", 42.0))

                +"hello world!!! - $contains - $constructorArgs - $sampleModel"
            }
        }

        styledDiv {
            css {
                +ApplicationStyles.wrapper
            }

            +"Next player: ${state.ticTacToeState.next}"
            br {}

            for (row in 0 .. 2) {
                for (col in 0 .. 2) {
                    child(TicTacToeCell::class) {
                        key = "$row/$col"

                        attrs {
                            this.ticTacToeState = state.ticTacToeState
                            this.row = row
                            this.col = col

                            onClick = {
                                handleClick(row, col)
                            }
                        }
                    }
                }
                br {}
            }
        }
    }
}
