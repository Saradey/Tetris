package com.goncharov.evgeny.tetris.repositories

class DifficultyRepositoryImpl : DifficultyRepository {

    private var difficultyLevel = 1

    override fun setDifficultyLvl(difficultyLvl: Int) {
        difficultyLevel = difficultyLvl
    }

    override fun getDifficultyLvl(): Int {
        return difficultyLevel
    }
}
