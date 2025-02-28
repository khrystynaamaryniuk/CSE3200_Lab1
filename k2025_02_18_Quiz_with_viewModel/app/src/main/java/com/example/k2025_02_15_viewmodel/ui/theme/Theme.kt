package com.example.k2025_02_15_viewmodel.views.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    background = DarkGreen,
    surface = MediumGreen,
    onPrimary = SoftWhite,
    onSecondary = SoftWhite,
    onBackground = SoftWhite,
    onSurface = SoftWhite
)

private val LightColorPalette = lightColorScheme(
    background = SoftWhite,
    surface = MediumGreen,
    onPrimary = DarkGreen,
    onSecondary = TextDark,
    onBackground = TextDark,
    onSurface = DarkGreen
)

@Composable
fun BooleanQuestionsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
