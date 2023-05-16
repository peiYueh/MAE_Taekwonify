package com.example.mae_taekwonify.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.mae_taekwonify.R

@OptIn(ExperimentalTextApi::class)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

//@OptIn(ExperimentalTextApi::class)
//val pacificoFontName = GoogleFont("Pacifico")
//
//@OptIn(ExperimentalTextApi::class)
//val pacifico = FontFamily(Font(googleFont = pacificoFontName, fontProvider = provider))

//@OptIn(ExperimentalTextApi::class)
//val kanitFontName = GoogleFont("Kanit")
//
//@OptIn(ExperimentalTextApi::class)
//val kanitFontFamily = FontFamily(
//    Font(googleFont = kanitFontName, fontProvider = provider, weight = FontWeight.Normal),
//    Font(googleFont = kanitFontName, fontProvider = provider, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
//)

val Oswald = FontFamily(
    Font(R.font.oswaldb, FontWeight.Bold)
//    Font(R.font.oswaldr),
)

val QuickSand = FontFamily(
    Font(R.font.quicksand_bold, FontWeight.Bold)
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val OpenSans = FontFamily(
    Font(R.font.opensans_regular),
    Font(R.font.opensans_bold, FontWeight.Bold)
)
// Set of Material typography styles to start with
val CustomTypography = Typography(
    h1 = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.W900,
        fontSize = 40.sp,
        color = Color.White,
        ),
    h2 = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.W900,
        fontSize = 40.sp,
        color = PrimaryColorRed,
    ),
    h3 = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color.Black,
    ),
    h4 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline
    ),
    h5 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Color.Black
    ),
    h6 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = Color.White
    ),
    body1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.W900,
        fontSize = 25.sp,
        color = Color.Black
    ),
    body2 = TextStyle(
        fontFamily = Montserrat,
        fontSize = 20.sp,
        color = Color.Black
    ),

    button = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Color.White
    ),

)