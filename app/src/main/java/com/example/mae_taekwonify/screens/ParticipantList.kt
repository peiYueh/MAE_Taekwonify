package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
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
import com.example.mae_taekwonify.widgets.CustomTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ParticipantList(navController: NavHostController,TeamName: String, vm: ParticipantDataViewModel = viewModel()){
    val getData = vm.state.value
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
                    text = TeamName,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = TeamName,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp

                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(MaterialTheme.colors.secondary)
            ){
                LazyColumn(){
                    itemsIndexed(getData){indexNumber, string ->
                        if(getData[indexNumber].Team ==TeamName){
                            Card(elevation = 10.dp, modifier = Modifier.padding(10.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                        .background(MaterialTheme.colors.primary)
                                        .clickable { navController.navigate(Routes.ParticipantDetails.route
                                                +"/"+getData[indexNumber].Name)}
                                ){
                                    Image(
                                        painter = rememberAsyncImagePainter(getData[indexNumber].profilePic),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(100.dp)
                                    )
                                    Text(
                                        text = getData[indexNumber].Name,
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