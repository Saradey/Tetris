package com.goncharov.evgeny.tetris.service.locator

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FillViewport
import com.goncharov.evgeny.tetris.service.locator.qualifiers.UiViewPort
import com.goncharov.evgeny.tetris.utils.UI_HUD_HEIGHT_SIZE
import com.goncharov.evgeny.tetris.utils.UI_HUD_WIDTH_SIZE
import org.koin.core.module.Module
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val gdxDependencyModule: Module = module {
    single {
        SpriteBatch()
    }
    factory {
        FillViewport(UI_HUD_WIDTH_SIZE, UI_HUD_HEIGHT_SIZE)
    } withOptions {
        qualifier = UiViewPort
    }
}

val modules = listOf(
    gdxDependencyModule
)
