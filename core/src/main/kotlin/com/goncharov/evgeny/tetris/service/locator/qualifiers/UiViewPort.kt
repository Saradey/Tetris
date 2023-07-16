package com.goncharov.evgeny.tetris.service.locator.qualifiers

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

object UiViewPort : Qualifier {

    private const val QUALIFIER_NAME = "UiViewPort"

    override val value: QualifierValue = QUALIFIER_NAME
}
