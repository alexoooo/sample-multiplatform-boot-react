package io.github.alexoooo.sample.proj.view

//import io.github.alexoooo.sample.proj.wrap.CloseIcon
//import io.github.alexoooo.sample.proj.wrap.MaterialIconButton
//import io.github.alexoooo.sample.proj.wrap.PanoramaFishEyeIcon
//import io.github.alexoooo.sample.proj.wrap.SelectAllIcon
//import react.RBuilder
//import react.RPureComponent
//import react.State
//
//
//class TicTacToeCell : RPureComponent<TicTacToeCell.Props, State>() {
//    interface Props : react.Props {
//        var row: Int
//        var col: Int
//        var ticTacToeState: TicTacToeState
//
//        var onClick: () -> Unit
//    }
//
//
//    override fun RBuilder.render() {
//        val player = props.ticTacToeState.cells[props.row][props.col]
//
//        child(MaterialIconButton::class) {
//            attrs {
//                onClick = {
//                    props.onClick()
//                }
//            }
//
//            when (player) {
//                TicTacToePlayer.Blank ->
//                    child(SelectAllIcon::class) {}
//
//                TicTacToePlayer.X ->
//                    child(CloseIcon::class) {}
//
//                TicTacToePlayer.O ->
//                    child(PanoramaFishEyeIcon::class) {}
//            }
//        }
//    }
//}