package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.widgets.CustomTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CompetitionResult(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Competition Result",
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
                    text = "Competition Result",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Competition Result",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            var goldMedalist by remember{ mutableStateOf("Eyu Ji Yuen") }
            var silverMedalist by remember{ mutableStateOf("Irfan Aiman") }
            var bronzeMedalist1 by remember{ mutableStateOf("William Kek Wai Kuin") }
            var bronzeMedalist2 by remember{ mutableStateOf("Goh Kheng Long") }
            var categorySelected by remember{
                mutableStateOf("")
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(MaterialTheme.colors.onPrimary)
                            .padding(15.dp)
                    ){
                        Text(
                            text= "Gold🥇: \n" + goldMedalist,
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            text= "Silver🥈: \n" + silverMedalist,
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            text= "Bronze🥉: \n" + bronzeMedalist1,
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            text= "Bronze🥉: \n" + bronzeMedalist2,
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colors.secondary)
                        .verticalScroll(rememberScrollState()),
                ) {
                    Card(
                        elevation = 10.dp,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .clickable {
                                categorySelected = "1"
                                goldMedalist = "Eyu Ji Yuen"
                                silverMedalist = "Irfan Aiman"
                                bronzeMedalist1 = "William Kek Wai Kuin"
                                bronzeMedalist2 = "Goh Kheng Long"
                            },
                        backgroundColor = if (categorySelected == "1") {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.primary
                        }
                    ) {
                        Text(
                            text = "Poomsae Male Individual",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Card(
                        elevation = 10.dp,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .clickable {
                                categorySelected = "2"
                                goldMedalist = "Chin Pei Yueh"
                                silverMedalist = "Ong Xin Ying"
                                bronzeMedalist1 = "Goh Min Li"
                                bronzeMedalist2 = "Humaira Abdul Karun"
                            },
                        backgroundColor = if (categorySelected == "2") {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.primary
                        }
                    ) {
                        Text(
                            text = "Poomsae Female Individual",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Card(
                        elevation = 10.dp,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .clickable {
                                categorySelected = "3"
                                goldMedalist = "Eyu JY & Kendra T - SEL"
                                silverMedalist = "Humaira & Jason - SWK"
                                bronzeMedalist1 = "Jackson & Jean L - PEN"
                                bronzeMedalist2 = "Lucas W & Kew ZY - KEL"
                            },
                        backgroundColor = if (categorySelected == "3") {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.primary
                        }
                    ) {
                        Text(
                            text = "Poomsae Mixed Pair",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            categorySelected = "4"
                            goldMedalist = "Chin PY, Ong XY, Kendra T - SEL"
                            silverMedalist = "Chan KY, Chong YW, Han YW - MEL"
                            bronzeMedalist1 = "Dianne C, Jane J, Shane L - SBH"
                            bronzeMedalist2 = "Kristin AL, Christy K, Damia A - KDH"
                        },
                    backgroundColor = if(categorySelected == "4"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Poomsae Female Team",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "Eyu JY, Irfan A, William KWK - SEL"
                            silverMedalist = "Lucas W, Goh KL, Chua KY- KEL"
                            bronzeMedalist1 = "Chai CY, Chai CL, Luke B - JHR"
                            bronzeMedalist2 = "Teh BC, Tan WK, Ervin CHY - PER"
                            categorySelected = "5"
                        },
                    backgroundColor = if(categorySelected == "5"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Poomsae Male Team",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "Nur Amira Aqilah"
                            bronzeMedalist2 = "Tan Qian Wen"
                            categorySelected = "6"
                        },
                    backgroundColor = if(categorySelected == "6"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Female Fin",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "7"
                        },
                    backgroundColor = if(categorySelected == "7"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Female Fly",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "8"
                        },
                    backgroundColor = if(categorySelected == "8"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Female Bantam",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "9"
                        },
                    backgroundColor = if(categorySelected == "9"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Female Feather",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "10"
                        },
                    backgroundColor = if(categorySelected == "10"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Female Middle",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "11"
                        },
                    backgroundColor = if(categorySelected == "11"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Male Fin",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "12"
                        },
                    backgroundColor = if(categorySelected == "12"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Male Fly",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "13"
                        },
                    backgroundColor = if(categorySelected == "13"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Male Bantam",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "14"
                        },
                    backgroundColor = if(categorySelected == "14"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Male Feather",
                        style = MaterialTheme.typography.body2,
                    )
                }
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable{
                            goldMedalist = "To Be Announced"
                            silverMedalist = "To Be Announced"
                            bronzeMedalist1 = "To Be Announced"
                            bronzeMedalist2 = "To Be Announced"
                            categorySelected = "15"
                        },
                    backgroundColor = if(categorySelected == "15"){
                        MaterialTheme.colors.onPrimary
                    }else{
                        MaterialTheme.colors.primary
                    }
                ){
                    Text(
                        text = "Sparring Male Mid",
                        style = MaterialTheme.typography.body2,
                    )
                }
                }
            }
        }
    }
}