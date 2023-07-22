package com.goncharov.evgeny.tetris.service.locator.factorys

import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.repositories.DifficultyRepository
import com.goncharov.evgeny.tetris.repositories.DifficultyRepositoryImpl

fun createViewPort(width: Float, height: Float): FitViewport = FitViewport(width, height)

fun createDifficultyRepository() : DifficultyRepository = DifficultyRepositoryImpl()
