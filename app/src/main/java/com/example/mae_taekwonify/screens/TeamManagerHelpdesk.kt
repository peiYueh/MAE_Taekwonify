package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.widgets.CustomTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TeamManagerHelpdesk(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Team Manager Help Desk",
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
                    text = "Help Desk",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Help Desk",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp.dp
            val half = screenWidth/2
            var viewSelected by remember{
                mutableStateOf("1")
            }

            //two selection (FAQ | Support)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 0.dp),
                horizontalArrangement = Arrangement.Center,
            ){
                    //toggle faq view
                Card(
                    shape = RoundedCornerShape(0),
                    backgroundColor = if(viewSelected == "1"){
                        MaterialTheme.colors.secondary
                    }else{
                        MaterialTheme.colors.onSecondary
                    }
                ){
                    Text(
                        text = "FAQ",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
//                            .background(MaterialTheme.colors.secondary)
                            .width(half)
                            .padding(5.dp)
                            .clickable {
                                viewSelected = "1"
                            }
                    )
                }
                Card(
                    shape = RoundedCornerShape(0),
                    backgroundColor = if(viewSelected == "2"){
                        MaterialTheme.colors.secondary
                    }else{
                        MaterialTheme.colors.onSecondary
                    }
                ){
                    //toggle support chat
                    Text(
                        text = "Support",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
                            .width(half)
                            .padding(5.dp)
                            .clickable {
                                viewSelected = "2"
                            }
                    )
                }


            }
            //if one is selected, display this
            Box(
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 10.dp)
                    .fillMaxSize()
                    .background(MaterialTheme.colors.secondary)
            ){
                if(viewSelected == "1"){
                    //display by post
                }else{
                    //display chat box
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxHeight()
                    ){
                        Column(){
                            //contains chat
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                            ){
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f)
                                        .padding(10.dp)
                                        .clip(RoundedCornerShape(25.dp))
                                        .background(MaterialTheme.colors.primary)
                                        .padding(10.dp)
                                ){
                                    Text(
                                        text="Hey how are you",
                                        style = MaterialTheme.typography.subtitle1,
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                            ){
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f)
                                        .padding(10.dp)
                                        .clip(RoundedCornerShape(25.dp))
                                        .background(MaterialTheme.colors.onPrimary)
                                        .padding(10.dp)
//                                    .align(Alignment.TopCenter)
                                ){
                                    Text(
                                        text="I'm Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nunc  purus, consectetur eu venenatis nec, vehicula ut libero. Vivamus  facilisis pulvinar. ",
                                        style = MaterialTheme.typography.subtitle1,
                                    )
                                }
                            }

                        }
                        var sendMessage by rememberSaveable{ mutableStateOf("") }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.secondary),

                        ){
                            Box(

                            ){
                                //chat input text field for user to send message
                                TextField(
                                    singleLine = true,
                                    value = sendMessage,
                                    onValueChange = {
                                        sendMessage = it
                                    },
                                    placeholder = { Text(text = "Ask something...") },
                                    modifier = Modifier
                                        .background(MaterialTheme.colors.primary)
//                                        .padding(10.dp, 0.dp, 3.dp, 10.dp)
                                        .fillMaxWidth()
                                        .height(50.dp)
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top=5.dp),
//                                    verticalAlignment = Alignment,
                                    horizontalArrangement = Arrangement.End,
                                ){
                                    Image(painter = painterResource(id = R.drawable.send), contentDescription = null,
                                        modifier = Modifier
                                            .clickable {
                                                //send msg
                                            }
                                            .size(40.dp)
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