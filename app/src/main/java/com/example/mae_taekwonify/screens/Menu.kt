package com.example.mae_taekwonify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.ui.theme.MAE_TaekwonifyTheme
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes

@Composable
fun Home(navController: NavHostController){
    MAE_TaekwonifyTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.taekwondo_img),
                    contentDescription = stringResource(id = R.string.taekwondo_img),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(300.dp)
                )

                Text(
                    text = "TAEKWONIFY",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "TAEKWONIFY",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 36.dp,
                    alignment = Alignment.CenterVertically
                ),
                modifier = Modifier
                    .background(MaterialTheme.colors.primary, shape = MaterialTheme.shapes.large)
                    .height(360.dp)
                    .width(300.dp)
                    .padding(all = 24.dp),
            ) {
                Button(
                    onClick = {
                        /*NOT IMPLEMENTING*/
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                ) {
                    Text(text = "I’m a Participant")
                }
                Button(
                    onClick = {
                        /*NOT IMPLEMENTING*/
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                ) {
                    Text(text = "I’m a Supporter")
                }
                Button(
                    onClick = {
                        navController.navigate(Routes.TeamManagerLogin.route)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                ) {
                    Text(text = "I’m a Team Manager")
                }
            }

        }
    }
}
