package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.widgets.CustomTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddParticipant(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Participant Details",
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
                    text = "Add Participant",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Add Participant",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
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
                            .height(150.dp)
                            .width(320.dp)
                            .align(Alignment.Center)
                            .padding(10.dp)
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = "Please use the template provided below to enter team member details and email it to admin.",
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier
                                    .padding(5.dp),
                            )
                        }
                    }
                }
                Text(
                    text="Step 1:",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(top = 10.dp)
                )
                val context = LocalContext.current
                val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/164liInZKgBYVoeUuI3Y2f1oZKIfxardTCAGF7AIIwGk/edit?usp=sharing")) }

                Button(
                    onClick = {
                        //go to download excel file
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = MaterialTheme.colors.onBackground
                    ),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                ){
                    Text(text = "📩 Download Template 📩")
                }

                Text(
                    text="Step 2:",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle2
                )
//                val intent2 = remember { Intent(Intent.ACTION_VIEW, Uri.parse("taekwondo_malaysia@gmail.com")) }

                Button(
                    onClick = {
                        //open email and send
                        val intent2 = Intent(Intent.ACTION_SEND)
                        intent2.type = "vnd.android.cursor.item/email" // or "message/rfc822"
                        intent2.putExtra(Intent.EXTRA_EMAIL, arrayOf("taekwondo_malaysia@gmail.com"))
                        intent2.putExtra(Intent.EXTRA_SUBJECT, "National Championship Team Registration")
                        context.startActivity(intent2)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = MaterialTheme.colors.onBackground
                    ),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                ){
                    Text(text = "📧 Send Email 📧")
                }

                Text(
                    text="Step 3:",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle2
                )
                Button(
                    onClick = {
                        //my team route
                        navController.navigate(Routes.ParticipantList.route+"/Selangor")
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = MaterialTheme.colors.onBackground
                    ),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                ){
                    Text(text = "👥 Check Participants 👥")
                }
            }
        }
    }
}