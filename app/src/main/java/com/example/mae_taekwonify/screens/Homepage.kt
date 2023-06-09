package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.viewModel.LoginViewModel
import com.example.mae_taekwonify.widgets.CustomTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Homepage(navController: NavHostController,vm: LoginViewModel = viewModel()){
    val getData = vm.email
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Welcome!",
                showBackIcon = false,
            )
        }){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .padding(bottom = 10.dp)
            ){
                Text(
                    text = "National Championship",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.TopCenter),
                )
                Text(
                    text = "National Championship",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(start = 2.dp),
                )
            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary)
                    .height(200.dp)
                    .width(350.dp)
                    .align(Alignment.CenterHorizontally)
                ){
                //announcement box
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .height(170.dp)
                        .width(320.dp)
                        .align(Alignment.Center)
                        .padding(10.dp)
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Organizer Announcement",
                            style = MaterialTheme.typography.h3,
                            modifier = Modifier
                                .padding(5.dp),
                        )
                        Text(
                            text = "We will have a lunch break at 12:30pm and continue at 1:00pm",
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier
                                .padding(3.dp),
                        )
                    }
                }
            }
            Box{
                Column(modifier = Modifier.padding(5.dp)){
                    //list of function
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(320.dp)
                            .padding(top = 5.dp)
                    ){
                        val iconModifier = Modifier
                            .size(50.dp)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.participants), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.TeamList.route) }.size(55.dp))
                            Text(text = "Participant \nInformation",textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.my_team), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.ManageTeam.route) }.size(55.dp))
                            Text(text = "My Team", textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.followed), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.FollowingParticipants.route) }.size(55.dp))
                            Text(text = "My Following", textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                    }
                    //row 2
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(320.dp)
                            .padding(top = 5.dp)
                    ){
                        val iconModifier = Modifier
                            .size(50.dp)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.medal_tally), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.MedalTally.route) }.size(55.dp))
                            Text(text = "Medal Tally",textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.competition_progress), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.CompetitionProgress.route) }.size(55.dp))
                            Text(text = "Competition \nProgress", textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.competition_info), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.CompetitionInfo.route) }.size(55.dp))
                            Text(text = "Competition \nInformation", textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                    }
                    //row 3
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(320.dp)
                            .padding(top = 5.dp)
                    ){
                        val iconModifier = Modifier
                            .size(50.dp)
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.team_manager_help_desk), contentDescription = null,
                                modifier = Modifier.clickable { navController.navigate(Routes.TeamManagerHelpdesk.route) }.size(55.dp))
                            Text(text = "Team Manager \nHelp Desk",textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                        }
                    }
                    Box(
                        modifier = Modifier.width(320.dp)
                    ){
                        //sign out
                        Button(
                            modifier = Modifier
                                .align(Alignment.BottomEnd),
                            onClick = {
                                navController.navigate(Routes.Menu.route)
                            },
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                        ) {
                            Text(text = "Sign Out", fontSize = 10.sp)
                        }
                    }
                }
            }
        }
    }
}
