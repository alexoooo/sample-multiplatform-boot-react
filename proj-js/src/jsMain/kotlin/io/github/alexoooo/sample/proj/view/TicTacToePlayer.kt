package io.github.alexoooo.sample.proj.view


enum class TicTacToePlayer(
    val display: String
) {
    Blank(" "),
    X("X"),
    O("O");


    fun flip(): TicTacToePlayer {
        return when (this) {
            X -> O
            O -> X

            Blank -> throw IllegalStateException()
        }
    }
}