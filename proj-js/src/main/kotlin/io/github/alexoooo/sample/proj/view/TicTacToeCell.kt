package io.github.alexoooo.sample.proj.view

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RProps
import react.RPureComponent
import react.RState
import react.dom.span


class TicTacToeCell : RPureComponent<TicTacToeCell.Props, RState>() {
    interface Props : RProps {
        var row: Int
        var col: Int
        var ticTacToeState: TicTacToeState

        var onClick: () -> Unit
    }


    override fun RBuilder.render() {
        val player = props.ticTacToeState.cells[props.row][props.col]
        span {
            attrs {
                onClickFunction = {
                    props.onClick()
                }
            }

            +"[${player.display}]"
        }
    }
}