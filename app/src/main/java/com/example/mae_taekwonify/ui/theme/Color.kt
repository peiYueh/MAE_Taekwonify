package com.example.mae_taekwonify.ui.theme

import androidx.compose.ui.graphics.Color

val BeigeBackground = "#BFA6A2".color
val PrimaryColorBeige = "#F3EED9".color
val PrimaryColorRed = "#780000".color
val ActionBlue = "#003049".color
val TopAppBrown = "#856C68".color
val selectedYellow = "#FFEFAD".color

val String.color
    get() = Color(android.graphics.Color.parseColor(this))
