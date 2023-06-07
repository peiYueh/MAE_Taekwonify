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
//+"/{EventCategory}"
    NavHost(navController = navController, startDestination = Routes.CompetitionInfo.route){
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
        composable(route = Routes.ParticipantList.route+"/{TeamName}"){backStackEntry ->
            backStackEntry.arguments?.getString("TeamName")
                ?.let { ParticipantList(navController = navController, it) }
        }
        composable(route = Routes.ParticipantDetails.route+"/{ParticipantName}"){backStackEntry ->
            backStackEntry.arguments?.getString("ParticipantName")
                ?.let { ParticipantDetails(navController = navController, it) }
        }
        composable(route = Routes.ModifyParticipants.route+"/{ParticipantName}"){backStackEntry ->
            backStackEntry.arguments?.getString("ParticipantName")
                ?.let { ModifyParticipant(navController = navController, it) }
        }
        composable(route = Routes.EliminationChart.route+"/{EventCategory}"){backStackEntry ->
            backStackEntry.arguments?.getString("EventCategory")
                ?.let { EliminationChart(navController = navController, it) }
        }
        composable(route = Routes.ManageTeam.route){
            ManageTeam(navController = navController)
        }
        composable(route = Routes.FollowingParticipants.route){
            FollowingParticipants(navController = navController)
        }
        composable(route = Routes.MedalTally.route){
            MedalTally(navController = navController)
        }
        composable(route = Routes.CompetitionProgress.route){
            CompetitionProgress(navController = navController)
        }
        composable(route = Routes.CompetitionInfo.route){
            CompetitionInfo(navController = navController)
        }
        composable(route = Routes.TeamManagerHelpdesk.route){
            TeamManagerHelpdesk(navController = navController)
        }
        composable(route = Routes.TeamList.route){
            TeamList(navController = navController)
        }
        composable(route = Routes.AddParticipant.route){
            AddParticipant(navController = navController)
        }


    }
}