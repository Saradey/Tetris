package com.goncharov.evgeny.tetris.service.locator

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import org.koin.core.module.Module
import org.koin.dsl.module

val gdxDependencyModule: Module = module {
    single {
        SpriteBatch()
    }
}
