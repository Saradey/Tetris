package com.goncharov.evgeny.tetris.screens.difficulty.service.locator

import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.screens.difficulty.DifficultyScreen
import com.goncharov.evgeny.tetris.service.locator.factorys.createViewPort
import com.goncharov.evgeny.tetris.utils.UI_HUD_HEIGHT_SIZE
import com.goncharov.evgeny.tetris.utils.UI_HUD_WIDTH_SIZE
import org.koin.core.module.Module
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.bind
import org.koin.dsl.module

val difficultyModule: Module = module {
    scope(TypeQualifier(DifficultyScreen::class)) {
        scoped { createViewPort(UI_HUD_WIDTH_SIZE, UI_HUD_HEIGHT_SIZE) } bind Viewport::class
        factory { createDifficultyScene(get(), get(), get(), get()) }
    }
}
