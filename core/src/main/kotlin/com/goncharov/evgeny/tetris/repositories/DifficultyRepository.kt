package com.goncharov.evgeny.tetris.repositories

interface DifficultyRepository {

    fun setDifficultyLvl(difficultyLvl: Int)

    fun getDifficultyLvl(): Int
}
