package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mae_taekwondo.viewModel.ParticipantDataViewModel
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.viewModel.BoutStatusViewModel
import com.example.mae_taekwonify.viewModel.FollowingViewModel
import com.example.mae_taekwonify.widgets.CustomTopBar
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ManageTeam(navController: NavHostController, vm: BoutStatusViewModel = viewModel(), participantVm: ParticipantDataViewModel = viewModel()){
    val currentA = 7
    val currentB = 8
    val currentC = 10
    val boutData = vm.state.value
    val userID = FirebaseAuth.getInstance().currentUser?.uid;
    val allParticipants = participantVm.state.value
    val myTeam = ArrayList<String>()
    for(participant in allParticipants){
        if(participant.Team == "Selangor"){
            myTeam.add(participant.id)
        }
    }
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Manage Team",
                showBackIcon = true,
            )
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {
            Box() {

                //you are viewing by...

                Text(
                    text = "Selangor",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Selangor",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp

                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                //participant - ring - bout
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .height(400.dp)
                        .padding(10.dp)
                        .background(MaterialTheme.colors.secondary)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp, 5.dp, 5.dp, 1.dp)
                            .background(MaterialTheme.colors.primary)
                    ) {
                        Text(
                            text = "Upcoming Match",
                            style = MaterialTheme.typography.body1,
//                            modifier = Modifier.width(250.dp)
                        )

                    }
                    LazyColumn() {
                        itemsIndexed(allParticipants) { indexNumber, string ->
                            if (myTeam.contains(allParticipants[indexNumber].id)) {
                                //means the participant is followed
                                //get all participant bout number
                                var boutRing = 'A'
                                var nearestBout = 1
                                for (bout in boutData) {
                                    if (bout.Blue == allParticipants[indexNumber].id || bout.Red == allParticipants[indexNumber].id) {
                                        //add to array list
                                        boutRing = bout.id[0]
                                        var boutNumber =
                                            bout.id.replace("""[A,B,C]""".toRegex(), "").toInt()
                                        //check if it is later than cur bout and the earliest for the other
                                        if (boutRing == 'A') {
                                            if (boutNumber > currentA) {
                                                //determine the earliest bout
                                                if (boutNumber < nearestBout || nearestBout == 1) {
                                                    nearestBout = boutNumber
                                                }
                                            }
                                        } else if (boutRing == 'B') {
                                            if (boutNumber > currentB) {
                                                //determine the earliest bout
                                                if (boutNumber < nearestBout || nearestBout == 1) {
                                                    nearestBout = boutNumber
                                                }
                                            }
                                        } else {
                                            if (boutNumber > currentC) {
                                                //determine the earliest bout
                                                if (boutNumber < nearestBout || nearestBout == 1) {
                                                    nearestBout = boutNumber
                                                }
                                            }
                                        }
                                    }
                                }
                                //table for upcoming matches
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp, 1.dp, 5.dp, 1.dp)
                                        .background(MaterialTheme.colors.primary)
                                ) {
                                    Text(
                                        text = allParticipants[indexNumber].Name,
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.width(250.dp)
                                    )
                                    Text(
                                        text = boutRing.toString(),
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.width(50.dp)
                                    )
                                    Text(
                                        text = nearestBout.toString(),
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.width(30.dp)
                                    )

                                }

                            }

                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .width(320.dp)
                        .padding(10.dp)
                ){
                    //onClickFun = { navController.navigate(Routes.Profile.route) }-> copy this soon
                    val iconModifier = Modifier
                        .size(50.dp)
                    //ADD MEMBER TODO
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.add_member), contentDescription = null,
                            modifier = Modifier.clickable { navController.navigate(Routes.AddParticipant.route) }.size(55.dp))
                        Text(text = "Add Member",textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                    }
                    // VIEW ALL MEMBER -> Lead to participant list
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.my_team), contentDescription = null,
                            modifier = Modifier.clickable { navController.navigate(Routes.ParticipantList.route+"/Selangor") }.size(55.dp))
                        Text(text = "View All Member", textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)
                    }
                }
            }
        }
    }
}