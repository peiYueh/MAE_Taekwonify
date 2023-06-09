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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.models.teamName
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.widgets.CustomTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "RestrictedApi")
@Composable
fun TeamList(navController: NavHostController){
    val items by remember{
        mutableStateOf(teamName)
    }
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "View Participant",
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
                    text = "Participant",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Participant",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
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
                    itemsIndexed(items){indexNumber, string ->
                        var pic = "R.drawable." + items[indexNumber].photo
                        val context = LocalContext.current
                        val drawableId = remember(pic) {
                            context.resources.getIdentifier(
                                items[indexNumber].photo,
                                "drawable",
                                "com.example.mae_taekwonify"
                            )
                        }
                        Card(elevation = 10.dp, modifier = Modifier.padding(10.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                                    .background(MaterialTheme.colors.primary)
                                    .clickable { navController.navigate(Routes.ParticipantList.route+
                                            "/"+items[indexNumber].name)}
                            ){
                                Image(
                                    painter = painterResource(id = drawableId),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(100.dp)
                                    ,
                                )
                                Text(
                                    text = items[indexNumber].name,
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

