package com.example.mae_taekwonify.nav

sealed class Routes(val route: String){
    object Menu : Routes("Menu")
    object TeamManagerLogin : Routes("TeamManagerLogin")
    object TeamManagerSignUp : Routes("TeamManagerSignUp")
    object Homepage : Routes("Homepage")
}