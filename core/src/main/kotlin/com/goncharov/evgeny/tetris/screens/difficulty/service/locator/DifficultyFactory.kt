package com.goncharov.evgeny.tetris.screens.difficulty.service.locator

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.repositories.DifficultyRepository
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.difficulty.ui.DifficultyScene

fun createDifficultyScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    navigator: Navigator,
    difficultyRepository: DifficultyRepository
) = DifficultyScene(viewport, spriteBatch, resourceManager, navigator, difficultyRepository)
