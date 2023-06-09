package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.mae_taekwondo.viewModel.ParticipantDataViewModel
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.viewModel.BoutStatusViewModel
import com.example.mae_taekwonify.viewModel.FollowingViewModel
import com.example.mae_taekwonify.widgets.CustomTopBar
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FollowingParticipants(navController: NavHostController, vm: BoutStatusViewModel = viewModel(), followingvm: FollowingViewModel = viewModel(), participantVm: ParticipantDataViewModel = viewModel()){
    val currentA = 7
    val currentB = 8
    val currentC = 10
    val boutData = vm.state.value
    val allFollowers = followingvm.state.value
    val userID = FirebaseAuth.getInstance().currentUser?.uid;
    val allParticipants = participantVm.state.value
    // get all id followed by the user
    val myFollowings = ArrayList<String>()
    for(follow in allFollowers){
        if(follow.follower == userID){
            myFollowings.add(follow.following)
        }
    }
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Followed Participants",
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
                    text = "My Following",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "My Following",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp

                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                //participant - ring - bout
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(10.dp)
                        .background(MaterialTheme.colors.secondary)
                ){
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp, 2.dp, 5.dp, 2.dp)
                            .background(MaterialTheme.colors.primary)
                    ){
                        Text(
                            text = "Upcoming Match",
                            style = MaterialTheme.typography.body1
                        )
                    }
                    LazyColumn(){

                        itemsIndexed(allParticipants){ indexNumber, string->
                            if(myFollowings.contains(allParticipants[indexNumber].id)){
                                //means the participant is followed
                                //get all participant bout number
                                var boutRing = 'A'
                                var nearestBout = 0
                                for(bout in boutData){
                                    if(bout.Blue == allParticipants[indexNumber].id || bout.Red == allParticipants[indexNumber].id){
                                        //add to array list
                                        boutRing = bout.id[0]
                                        var boutNumber = bout.id.replace("""[A,B,C]""".toRegex(), "").toInt()
                                        //check if it is later than cur bout and the earliest for the other
                                        if(boutRing=='A'){
                                            if(boutNumber > currentA){
                                                //determine the earliest bout
                                                if(boutNumber < nearestBout || nearestBout == 0){
                                                    nearestBout = boutNumber
                                                }
                                            }
                                        }else if (boutRing =='B'){
                                            if(boutNumber > currentB){
                                                //determine the earliest bout
                                                if(boutNumber < nearestBout || nearestBout == 0){
                                                    nearestBout = boutNumber
                                                }
                                            }
                                        }else{
                                            if(boutNumber > currentC){
                                                //determine the earliest bout
                                                if(boutNumber < nearestBout || nearestBout == 0){
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
                                ){
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
                                        modifier = Modifier.width(50.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                //if the participant is in the following list, list out, direct them to their details
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .background(MaterialTheme.colors.secondary)
                ){
                    //list all following players
                    LazyColumn(){
                        itemsIndexed(allParticipants){indexNumber, string ->
                            //if is in following, display
                            if(myFollowings.contains(allParticipants[indexNumber].id)){
                                Card(elevation = 5.dp, modifier = Modifier.padding(3.dp)){
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                            .background(MaterialTheme.colors.primary)
                                            .clickable { navController.navigate(Routes.ParticipantDetails.route+"/"+allParticipants[indexNumber].Name)}
                                    ){
                                        Image(
                                            painter = rememberAsyncImagePainter(allParticipants[indexNumber].profilePic),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .size(60.dp)
                                        )
                                        Text(
                                            text = allParticipants[indexNumber].Name,
                                            style = MaterialTheme.typography.body1,
                                        )
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