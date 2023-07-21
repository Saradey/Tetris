package com.goncharov.evgeny.tetris.navigation

sealed interface NavigationKey {

    object StartScreenKey : NavigationKey

    object DifficultyScreenKey : NavigationKey

    object GameScreenKey : NavigationKey
}
