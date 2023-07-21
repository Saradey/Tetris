package com.goncharov.evgeny.tetris.service.locator

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.start.service.locator.startModule
import org.koin.core.module.Module
import org.koin.dsl.module

val gdxDependencyModule: Module = module {
    single {
        SpriteBatch()
    }
    single {
        AssetManager()
    }
    single {
        ResourceManager(get())
    }
}

fun createCoreModule(navigator: Navigator): Module = module {
    single {
        navigator
    }
}

val allModules = listOf(
    gdxDependencyModule,
    startModule
)
