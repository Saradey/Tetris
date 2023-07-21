package com.goncharov.evgeny.tetris.screens.start.service.locator

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.start.ui.StartScene

fun createStartScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    navigator: Navigator
) = StartScene(viewport, spriteBatch, resourceManager, navigator)
