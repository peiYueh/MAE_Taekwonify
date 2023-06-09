package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.widgets.CustomTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CompetitionProgress(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Participant Profile",
                showBackIcon = true,
            )
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box() {
                Text(
                    text = "Competition Progress",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Competition Progress",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(500.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colors.secondary)
                    .padding(10.dp)
            ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colors.primary)
                            .padding(10.dp)
                    ){
                        Text(
                            text = "RING A",
                            style = MaterialTheme.typography.body1,
                        )
                        Text(
                            text = "Current Bout: 7\n" +
                                    "Average Duration: 4 mins",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colors.primary)
                            .padding(10.dp)
                    ){
                        Text(
                            text = "RING B",
                            style = MaterialTheme.typography.body1,
                        )
                        Text(
                            text = "Current Bout: 8\n" +
                                    "Average Duration: 3.7 mins",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colors.primary)
                            .padding(10.dp)
                    ){
                    Text(
                        text = "RING C",
                        style = MaterialTheme.typography.body1,
                    )
                    Text(
                        text = "Current Bout: 10\n" +
                                "Average Duration: 3 mins",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Button(
                    onClick = {
                        //navigate to view result page
                        navController.navigate(Routes.CompetitionResult.route)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                ) {
                    Text(text = "🎖️ View Result 🎖️")
                }
            }
        }
    }
}