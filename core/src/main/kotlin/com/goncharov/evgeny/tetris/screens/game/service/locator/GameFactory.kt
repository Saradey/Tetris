package com.goncharov.evgeny.tetris.screens.game.service.locator

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.game.ui.GameScene

fun createGameScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    navigator: Navigator
) = GameScene(
    viewport, spriteBatch, resourceManager, navigator
)
