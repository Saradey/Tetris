package com.goncharov.evgeny.tetris.resources

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Skin

val GAME_ASSET_DESCRIPTOR = AssetDescriptor(GAME_ASSET_PATH, TextureAtlas::class.java)
val UI_ASSET_DESCRIPTOR = AssetDescriptor(UI_ASSET_PATH, Skin::class.java)

val SOUND_CLEAR_LINE_DESCRIPTOR = AssetDescriptor(SOUND_CLEAR_LINE_PATH, Sound::class.java)
val SOUND_CLICK_BUTTON_DESCRIPTOR = AssetDescriptor(SOUND_CLICK_BUTTON_PATH, Sound::class.java)
val SOUND_FALL_TO_FLOOR_DESCRIPTOR = AssetDescriptor(SOUND_FALL_TO_FLOOR_PATH, Sound::class.java)
val SOUND_GAME_OVER_DESCRIPTOR = AssetDescriptor(SOUND_GAME_OVER_PATH, Sound::class.java)
val SOUND_TERN_FIGURE_DESCRIPTOR = AssetDescriptor(SOUND_TERN_FIGURE_PATH, Sound::class.java)
