package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.ui.theme.MAE_TaekwonifyTheme
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.widgets.CustomTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Homepage(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Team Manager Login",
                showBackIcon = true,
            )
        }){
        Text("hi")
    }
}

//@Preview
//@Composable
//fun MainScreen()