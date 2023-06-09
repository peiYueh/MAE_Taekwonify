package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.widgets.CustomTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CompetitionInfo(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Competition Details",
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
                    text = "Competition Details",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Competition Details",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                    letterSpacing = .2.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .fillMaxSize()
                    .padding(8.dp, 0.dp, 8.dp, 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colors.secondary)
                    .padding(8.dp, 0.dp, 8.dp, 10.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ){
                    Box(
                        modifier = Modifier
                            .width(550.dp)
                            .padding(5.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(MaterialTheme.colors.primary)
                            .padding(5.dp)
                    ){
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                                .verticalScroll(rememberScrollState())
                        ){
                            Text(
                                text = "🏁 Competition Name:",
                                style = MaterialTheme.typography.body1,
                            )
                            Text(
                                text = "National Championship\n",
                                style = MaterialTheme.typography.body2,
                            )
                            Text(
                                text = "🗓️ Competition Date:",
                                style = MaterialTheme.typography.body1,
                            )
                            Text(
                                text = "28 & 29 Nov 2023\n",
                                style = MaterialTheme.typography.body2,
                            )
                            Text(
                                text = "📌 Competition Venue:",
                                style = MaterialTheme.typography.body1,
                            )
                            Text(
                                text = "Wisma OCM\n",
                                style = MaterialTheme.typography.body2,
                            )
                            Text(
                                text = "🥋 Organizer:",
                                style = MaterialTheme.typography.body1,
                            )
                            Text(
                                text = "Taekwondo Malaysia (TM)",
                                style = MaterialTheme.typography.body2,
                            )
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Image(painter = painterResource(id = R.drawable.tmlogo),
                                    contentDescription = null,
                                    modifier = Modifier.size(60.dp)
                                )
                                val context = LocalContext.current
                                val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir//Sports+Arena+Olympic+Council+of+Malaysia/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x31cc4989b7624781:0xab29d5e022036e95?sa=X&ved=2ahUKEwjr0-DO2rH_AhU5sVYBHVDUAI8Q9Rd6BAhdEAU")) }
                                Button(
                                    onClick = {
                                        context.startActivity(intent)
                                    },
                                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                                ) {
                                    Text(text = "📍 Bring Me There 📍")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}