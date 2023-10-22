package io.github.alexoooo.sample.proj.view

import io.github.alexoooo.sample.lib.PersistentList
import io.github.alexoooo.sample.lib.persistentListOf


data class TicTacToeState(
    val next: TicTacToePlayer,
    val cells: PersistentList<PersistentList<TicTacToePlayer>>
) {
    companion object {
        val empty = TicTacToeState(
            next = TicTacToePlayer.X,
            cells = persistentListOf(
                persistentListOf(TicTacToePlayer.Blank, TicTacToePlayer.Blank, TicTacToePlayer.Blank),
                persistentListOf(TicTacToePlayer.Blank, TicTacToePlayer.Blank, TicTacToePlayer.Blank),
                persistentListOf(TicTacToePlayer.Blank, TicTacToePlayer.Blank, TicTacToePlayer.Blank)
            )
        )
    }


    fun play(row: Int, col: Int): TicTacToeState {
        return TicTacToeState(
            next.flip(),
            cells.set(row, cells[row].set(col, next)))
    }
}