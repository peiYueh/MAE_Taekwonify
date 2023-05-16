package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.widgets.CustomTopBar
//,

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EliminationChart(navController: NavHostController, EventCategory: String){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Elimination Chart",
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
                    text = "Elimination Chart",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Elimination Chart",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            var img = R.drawable.male_idv
            var categorySelected by remember{
                mutableStateOf("")
            }
            //determine the image fetched from params - EventCategory
            var splitEvent = EventCategory.split("|")
            println(splitEvent[0])
            println(splitEvent[1])
            if(splitEvent[1]=="Female"){
                when (splitEvent[0]) {
                    "I" -> img = R.drawable.male_idv
                    "p" -> img = R.drawable.mixed_pair
                    "T" -> img = R.drawable.feamale_team
                    "S-FIN" -> img = R.drawable.female_fin
                    "S-FLY" -> img = R.drawable.female_fly
                    "S-FEA" -> img = R.drawable.female_fea
                    "S-B" -> img = R.drawable.female_ban
                    "S-M" -> img = R.drawable.female_mid
                    else -> {
                        println("SHITT")
                        img = R.drawable.male_idv
                    }
                }
            }else{
                when (splitEvent[0]) {
                    "I" -> img = R.drawable.male_idv
                    "p" -> img = R.drawable.mixed_pair
                    "T" -> img = R.drawable.male_team
                    "S-FIN" -> img = R.drawable.male_fin
                    "S-FLY" -> img = R.drawable.male_fly
                    "S-FEA" -> img = R.drawable.male_fea
                    "S-B" -> img = R.drawable.male_ban
                    "S-M" -> img = R.drawable.male_mid
                    else -> {
                        println("SHITT")
                        img = R.drawable.male_idv
                    }
                }
            }

            var imageID by remember{
                mutableStateOf(img)
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Column(
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                ){
                    Image(
                        painter = painterResource(id = imageID),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colors.secondary)
                        .verticalScroll(rememberScrollState()),
                ){
                    Card(
                        elevation = 10.dp,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .clickable{
                                imageID = R.drawable.male_idv
                                categorySelected = "1";
                            },
                        backgroundColor = if(categorySelected == "1"){
                            MaterialTheme.colors.onPrimary
                        }else{
                            MaterialTheme.colors.primary
                        }
                    ){
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
                            .clickable{
                                imageID = R.drawable.female_idv
                                categorySelected = "2"
                            },
                        backgroundColor = if(categorySelected == "2"){
                            MaterialTheme.colors.onPrimary
                        }else{
                            MaterialTheme.colors.primary
                        }
                    ){
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
                            .clickable{
                                imageID = R.drawable.mixed_pair
                                categorySelected = "3"
                            },
                        backgroundColor = if(categorySelected == "3"){
                            MaterialTheme.colors.onPrimary
                        }else{
                            MaterialTheme.colors.primary
                        }
                    ){
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
                                imageID = R.drawable.feamale_team
                                categorySelected = "4"
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
                                imageID = R.drawable.male_team
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
                                imageID = R.drawable.female_fin
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
                                imageID = R.drawable.female_fly
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
                                imageID = R.drawable.female_ban
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
                                imageID = R.drawable.female_fea
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
                                imageID = R.drawable.female_mid
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
                                imageID = R.drawable.male_fin
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
                                imageID = R.drawable.male_fly
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
                                imageID = R.drawable.male_ban
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
                                imageID = R.drawable.male_fea
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
                                imageID = R.drawable.male_mid
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