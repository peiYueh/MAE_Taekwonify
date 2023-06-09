package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.models.Chat
import com.example.mae_taekwonify.models.ChatSuppport
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.viewModel.ChatViewModel
import com.example.mae_taekwonify.viewModel.SendChatSupportViewModel
import com.example.mae_taekwonify.widgets.CustomTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TeamManagerHelpdesk(navController: NavHostController, sendChatvm: SendChatSupportViewModel = viewModel(), chatDatavm: ChatViewModel = viewModel()){
    val allChat = chatDatavm.state.value
    val context = LocalContext.current
    var sendMessage by rememberSaveable{ mutableStateOf("") }
    var idCount = 1;
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
                    //display by FAQ enable scrolling
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState())
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(MaterialTheme.colors.primary)
                                    .padding(15.dp)
                            ){
                                Text(
                                    text= "How can participants register for the tournament?",
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    text= "Team manager can register their participants online through our tournament application by filling out the registration form and submitting the required information.",
                                    style = MaterialTheme.typography.body2,
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(MaterialTheme.colors.onPrimary)
                                    .padding(15.dp)
                            ){
                                Text(
                                    text= "Can participants represent a specific taekwondo school or organization?",
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    text= "Yes, participants are welcome to represent their taekwondo schools or organizations. They should indicate their affiliation during the registration process. ",
                                    style = MaterialTheme.typography.body2,
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(MaterialTheme.colors.primary)
                                    .padding(15.dp)
                            ){
                                Text(
                                    text= "Will there be any coaching or officiating opportunities available at the tournament?",
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    text= "Yes, we welcome certified coaches and referees to be part of the tournament. Interested individuals can contact the organizers to inquire about coaching or officiating opportunities.",
                                    style = MaterialTheme.typography.body2,
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(MaterialTheme.colors.onPrimary)
                                    .padding(15.dp)
                            ){
                                Text(
                                    text= "What are the rules and scoring criteria that will be followed in the tournament?",
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    text= "The tournament will follow the rules and scoring criteria set by the World Taekwondo Federation (WTF) or the appropriate governing body. Participants should familiarize themselves with these rules prior to the event.",
                                    style = MaterialTheme.typography.body2,
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(MaterialTheme.colors.primary)
                                    .padding(15.dp)
                            ){
                                Text(
                                    text= "Will there be any awards or recognition for the winners and participants?",
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    text= "Yes, there will be awards and recognition for the winners in each category. Participants will receive certificates of participation, and winners will receive trophies, medals, or other appropriate accolades.",
                                    style = MaterialTheme.typography.body2,
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .background(MaterialTheme.colors.onPrimary)
                                    .padding(15.dp)
                            ){
                                Text(
                                    text= "How can participants register for the tournament?",
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    text= "Team manager can register their participants online through our tournament application by filling out the registration form and submitting the required information.",
                                    style = MaterialTheme.typography.body2,
                                )
                            }
                        }
                    }

                }else{
                    //display chat box
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxHeight()
                    ){
                        LazyColumn(){
                            // loop through the data
                            itemsIndexed(allChat){indexNumber, string ->
                                idCount+=1
                                if(allChat[indexNumber].Sender == "admin123"){
                                    //msg from admin
                                    Card(
                                        backgroundColor = MaterialTheme.colors.secondary
                                    ){
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
                                                    .background(MaterialTheme.colors.onPrimary)
                                                    .padding(10.dp)
                                            ){
                                                Text(
                                                    text= allChat[indexNumber].Content,
                                                    style = MaterialTheme.typography.subtitle1,
                                                )
                                            }
                                        }
                                    }
                                }else{
                                    //msg from user
                                    Card(
                                        backgroundColor = MaterialTheme.colors.secondary
                                    ){
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
                                                    .background(MaterialTheme.colors.primary)
                                                    .padding(10.dp)
            //                                    .align(Alignment.TopCenter)
                                            ){
                                                Text(
                                                    text= allChat[indexNumber].Content,
                                                    style = MaterialTheme.typography.subtitle1,
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

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
                                    textStyle = MaterialTheme.typography.subtitle1,
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
                                                sendChatvm.sendChatToFirebase(
                                                    content = sendMessage,
                                                    context = context,
                                                    newID = idCount.toString()
                                                )
                                                // add msg to chat
                                                allChat.add(Chat("na", "admin123", "na",sendMessage))
                                                //clear text msg
                                                sendMessage = ""



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