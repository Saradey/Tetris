package com.goncharov.evgeny.tetris.resources

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager

class ResourceManager(
    private val assetManager: AssetManager
) {

    fun loadedAllResources() {
        assetManager.load(GAME_ASSET_DESCRIPTOR)
        assetManager.load(UI_ASSET_DESCRIPTOR)
        assetManager.load(SOUND_CLEAR_LINE_DESCRIPTOR)
        assetManager.load(SOUND_CLICK_BUTTON_DESCRIPTOR)
        assetManager.load(SOUND_FALL_TO_FLOOR_DESCRIPTOR)
        assetManager.load(SOUND_GAME_OVER_DESCRIPTOR)
        assetManager.load(SOUND_TERN_FIGURE_DESCRIPTOR)
        assetManager.finishLoading()
    }

    operator fun <T> get(assetDescriptor: AssetDescriptor<T>): T {
        return assetManager[assetDescriptor]
    }
}
