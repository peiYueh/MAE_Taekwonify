package com.example.mae_taekwonify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = BeigeBackground,
    primary = PrimaryColorBeige,
    secondary = PrimaryColorRed,
    onBackground = ActionBlue,
    primaryVariant = TopAppBrown
)

private val LightColorPalette = lightColors(
    background = BeigeBackground,
    primary = PrimaryColorBeige,
    secondary = PrimaryColorRed,
    onBackground = ActionBlue,
    primaryVariant = TopAppBrown

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MAE_TaekwonifyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = CustomTypography,
        shapes = Shapes,
        content = content
    )
}