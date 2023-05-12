package com.example.mae_taekwonify.widgets


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

//@Preview
@Composable
fun CustomTopBar(navController: NavHostController, title: String, showBackIcon : Boolean) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h3,
//                modifier = Modifier
//                    .background(MaterialTheme.colors.primaryVariant)
//                    .fillMaxSize()
//                ,
            )
        },
        navigationIcon = if (showBackIcon && navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"

                    )
                }
            }
        } else {
            null
        }
    )
}