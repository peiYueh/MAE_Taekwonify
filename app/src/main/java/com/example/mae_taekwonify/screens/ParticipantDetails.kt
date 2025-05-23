package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.mae_taekwondo.viewModel.ParticipantDataViewModel
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.viewModel.FollowUnfollowViewModel
import com.example.mae_taekwonify.viewModel.FollowingViewModel
import com.example.mae_taekwonify.widgets.CustomTopBar
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ParticipantDetails(navController: NavHostController, ParticipantName: String, vm: ParticipantDataViewModel = viewModel(), followingvm: FollowingViewModel = viewModel(), followvm: FollowUnfollowViewModel = viewModel()) {
    val allData = vm.state.value
    val allFollowers = followingvm.state.value
    val userID = FirebaseAuth.getInstance().getCurrentUser()?.getUid();
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Participant Details",
                showBackIcon = true,
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box() {
                Text(
                    text = ParticipantName,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = ParticipantName,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .fillMaxSize()
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colors.secondary)
                    .padding(8.dp, 0.dp, 8.dp, 10.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    itemsIndexed(allData) { indexNumber, string ->
                        if (allData[indexNumber].Name == ParticipantName) {
                            Image(
                                painter = rememberAsyncImagePainter(allData[indexNumber].profilePic),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(250.dp)
                                    .padding(20.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .width(800.dp)
                                    .padding(5.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colors.primary)
                                    .padding(5.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp)
                                ) {
                                    Text(
                                        text = "Participant Details:",
                                        style = MaterialTheme.typography.body1,
                                    )
                                    Text(
                                        text = "Team: " + allData[indexNumber].Team,
                                        style = MaterialTheme.typography.body2,
                                    )
                                    Text(
                                        text = "DOB: " + allData[indexNumber].DOB,
                                        style = MaterialTheme.typography.body2,
                                    )
                                    Text(
                                        text = "Gender: " + allData[indexNumber].Gender,
                                        style = MaterialTheme.typography.body2,
                                    )
                                    Text(
                                        text = "Email: " + allData[indexNumber].EmailAdd,
                                        style = MaterialTheme.typography.body2,
                                    )

                                    Text(
                                        text = "\nParticipating Event:",
                                        style = MaterialTheme.typography.body1,
                                    )
                                    //separate all categories from data
                                    var eventList = ""
                                    var i = 0;
                                    var event = allData[indexNumber].Event.split("|")
                                    for (evt in event) {
                                        i++
                                        when (evt) {
                                            "I" -> eventList = "Poomsae Individual"
                                            "p" -> eventList = "Poomsae Pair"
                                            "T" -> eventList = "Poomsae Team"
                                            "S-FIN" -> eventList = "Sparring Fin Weight"
                                            "S-FLY" -> eventList = "Sparring Fly Weight"
                                            "S-FEA" -> eventList = "Sparring Feather Weight"
                                            "S-B" -> eventList = "Sparring Bantam Weight"
                                            "S-W" -> eventList = "Sparring Wealther Weight"
                                            "S-M" -> eventList = "Sparring Middle Weight"
                                            "S-H" -> eventList = "Sparring Heavy Weight"
                                            else -> {
                                                eventList = "Sparring"
                                            }
                                        }
                                        Text(
                                            text = eventList,
                                            style = MaterialTheme.typography.body2,
                                            modifier = Modifier
                                                .clickable{
                                                    navController.navigate(Routes.EliminationChart.route+"/"+evt+"|"+allData[indexNumber].Gender)
                                                },
                                        )
                                    }
                                    var followStatus by remember { mutableStateOf("FOLLOW") }
                                    var followID = ""
                                    for (follow in allFollowers) {
                                        if (follow.follower == userID && allData[indexNumber].id == follow.following) {
                                            followID = follow.id
                                            followStatus = "UNFOLLOW"
                                            break
                                        }
                                    }
                                    Column(
                                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                                        ){
                                            Button(
                                                onClick = {
                                                    if (followStatus == "FOLLOW") {
                                                        //means follow the ppl
                                                        followID = followvm.addFollowingToFirebase(
                                                            Following = allData[indexNumber].id,
                                                            context = context
                                                        )
                                                        //return followID and set follow id
                                                        followStatus = "UNFOLLOW"
                                                    } else {
                                                        //remove the person from database following list
                                                        followvm.deleteFollowingFromFirebase(
                                                            followID = followID,
                                                            context = context
                                                        )
                                                        followStatus = "FOLLOW"
                                                    }
                                                },
                                                colors = ButtonDefaults.outlinedButtonColors(
                                                    backgroundColor = MaterialTheme.colors.onBackground
                                                ),
                                                modifier = Modifier
                                                    .padding(top = 10.dp)
                                            ) {
                                                Text(text = followStatus)
                                            }
                                            if(allData[indexNumber].Team == "Selangor"){
                                                Button(
                                                    onClick = {
                                                        //go to modify page
                                                        navController.navigate(Routes.ModifyParticipants.route+"/"+allData[indexNumber].Name)
                                                    },
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        backgroundColor = MaterialTheme.colors.onBackground
                                                    ),
                                                    modifier = Modifier
                                                        .padding(top = 10.dp)
                                                ){
                                                    Text(text = "MODIFY")
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}