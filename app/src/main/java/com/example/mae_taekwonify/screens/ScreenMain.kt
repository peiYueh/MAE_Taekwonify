package com.example.mae_taekwonify.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mae_taekwonify.nav.Routes
import com.google.firebase.auth.FirebaseAuth

//will have to auth firebaseauth soon refer to road help
@Composable
fun ScreenMain(auth: FirebaseAuth){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Menu.route){
        composable(Routes.Menu.route){
            Home(navController = navController)
        }
        composable(route = Routes.TeamManagerLogin.route){
            TeamManagerLogin(navController = navController)
        }
        composable(route = Routes.TeamManagerSignUp.route){
            TeamManagerSignUp(navController = navController, auth = auth)
        }
        composable(route = Routes.Homepage.route){
            Homepage(navController = navController)
        }


    }
}