package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.widgets.CustomTopBar
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedalTally(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Medal Tally",
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

                //you are viewing by...
                Text(
                    text = "Medal Tally",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Medal Tally",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp

                )
            }
            //medal tally table
            Column(
                modifier = Modifier
                    .padding(10.dp, 15.dp, 10.dp, 10.dp)
                    .background(MaterialTheme.colors.primary)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(border = BorderStroke(width = 2.dp, Color.Black))
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        modifier = Modifier.padding(top = 10.dp)
                    ){
                        Text(
                            text = "Team Name",
                            style = MaterialTheme.typography.body1
                        )
                        Text(
                            text = "Selangor",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Kelantan",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Kuala Lumpur",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Pahang",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Johor",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Perak",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Perlis",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Sabah",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Malacca",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Sarawak",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Negeri Sembilan",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Penang",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Kedah",
                            style = MaterialTheme.typography.body2
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.gold_medal), contentDescription = null,
                            modifier = Modifier.size(50.dp))
                        Text(
                            text = "5",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "4",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(painter = painterResource(id = R.drawable.silver_medal), contentDescription = null,
                            modifier = Modifier.size(50.dp))
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "4",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(painter = painterResource(id = R.drawable.bronze_medal), contentDescription = null,
                            modifier = Modifier.size(50.dp))
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}