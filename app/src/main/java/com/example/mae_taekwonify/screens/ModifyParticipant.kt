package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mae_taekwondo.viewModel.ParticipantDataViewModel
import com.example.mae_taekwonify.models.teamName
import com.example.mae_taekwonify.widgets.CustomTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ModifyParticipant(navController: NavHostController, ParticipantName: String, vm: ParticipantDataViewModel = viewModel()){
    val allData = vm.state.value
    var i = 0
    var selectedParticipant = allData[0]
    allData.forEach {
        if(allData[i].Name == ParticipantName){
            selectedParticipant = allData[i]
        }
        i++
    }
    var name by rememberSaveable { mutableStateOf(selectedParticipant.Name) }
    var email by rememberSaveable { mutableStateOf(selectedParticipant.EmailAdd) }
    var contactNum by rememberSaveable { mutableStateOf(selectedParticipant.ContactNumber) }
    name = selectedParticipant.Name
    email = selectedParticipant.EmailAdd
    contactNum = selectedParticipant.ContactNumber

    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Modification Request",
                showBackIcon = true,
            )
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 25.dp,
                    alignment = Alignment.CenterVertically
                ),
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary, shape = MaterialTheme.shapes.large)
                    .width(350.dp)
                    .padding(top = 20.dp),
            ){
                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = { Text(text = "Participant Name") },
                    placeholder = { Text(text = "Participant Name") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )
                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text(text = "Participant Email") },
                    placeholder = { Text(text = "Partcipant Email") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )
                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = contactNum,
                    onValueChange = {
                        contactNum = it
                    },
                    label = { Text(text = "Participant Contact Number") },
                    placeholder = { Text(text = "Participant Contact Number") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )
                Button(
                    onClick = {
                        // TODO SAY REGISTERED
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground),
                    modifier = Modifier.padding(bottom = 5.dp)
                ) {
                    Text(text = "Modify")
                }
            }
        }

    }
}