package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.ui.theme.MAE_TaekwonifyTheme
import com.example.mae_taekwonify.viewModel.RegisterTeamManagerViewModel
import com.example.mae_taekwonify.widgets.CustomTopBar
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TeamManagerSignUp(navController: NavController, auth: FirebaseAuth, vm: RegisterTeamManagerViewModel = viewModel()){
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    var showPassword by rememberSaveable { mutableStateOf(false) }

    var name by rememberSaveable { mutableStateOf("") }
    var teamName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable{ mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var validateName by rememberSaveable { mutableStateOf(true) }
    var validateTeamName by rememberSaveable { mutableStateOf(true) }
    var validateEmail by rememberSaveable { mutableStateOf(true) }
    var validatePhone by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    val validateNameError = "Please input a valid name"
    val validateTeamNameError = "Please input a valid Team name"
    val validateEmailError = "Please input a valid email"
    val validatePhoneError = "Please enter a valid Malaysia phone number"
    val validatePasswordError = "Please mix uppercase and lowercase letters and a number with a minimum length of 8 "

    fun validateData(name: String, teamName: String, email:String, phone: String, password: String): Boolean {
        val passwordRegex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}".toRegex()
        //val passwordRegex = "(^\\d+\$).([a-zA-z]*).{8,}".toRegex()

        validateName = name.isNotBlank()
        validateTeamName = teamName.isNotBlank()
        validateEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        validatePhone = Patterns.PHONE.matcher(phone).matches()
        validatePassword = passwordRegex.matches(password)

        return validateName && validateEmail && validatePhone && validatePassword && validateTeamName
    }

    fun register (
        name: String,
        teamName: String,
        email: String,
        phone: String,
        password: String
    ) {
        if (validateData(name, teamName, email, phone, password)) {
            println("SUCCESS ALL VALID")
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        vm.addDataToFirebase(
                            name = name,
                            teamName = teamName,
                            email = email,
                            phone = phone,
                            context = context)
                        navController.navigate(Routes.TeamManagerLogin.route) // testing
                    } else {
                        Toast.makeText(context, "Please review the fields", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController as NavHostController,
                title = "Team Manager Registration",
                showBackIcon = true,
            )
        }){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(modifier = Modifier
                .padding(bottom = 20.dp),){
                Text(
                    text = "Team Registration",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Team Registration",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 25.dp,
                    alignment = Alignment.CenterVertically
                ),
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary, shape = MaterialTheme.shapes.large)
                    .width(350.dp)
                    .padding(top = 20.dp),
            ){
                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = { Text(text = "Enter Team Manager Name") },
                    placeholder = { Text(text = "Team Manager Name") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )

                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = teamName,
                    onValueChange = {
                        teamName = it
                    },
                    label = { Text(text = "Enter Team Name") },
                    placeholder = { Text(text = "Team Name") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )

                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text(text = "Enter email") },
                    placeholder = { Text(text = "Email") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )

                TextField(
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,
                    value = phone,
                    onValueChange = {
                        phone = it
                    },
                    label = { Text(text = "Enter Contact Number") },
                    placeholder = { Text(text = "Contact Number") },
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )

                TextField(
                    singleLine = true,
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text(text = "Enter password") },
                    placeholder = { Text(text = "Password") },
                    textStyle = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.background(MaterialTheme.colors.primary),
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (showPassword)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Please provide localized description for accessibility services
                        val description = if (showPassword) "Hide password" else "Show password"

                        IconButton(onClick = {showPassword = !showPassword}){
                            Icon(imageVector  = image, description)
                        }
                    }
                )

                Button(
                    onClick = {
                        register(name, teamName, email, phone, password)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground),
                    modifier = Modifier.padding(bottom = 5.dp)
                ) {
                    Text(text = "Register")

                }
            }

        }
    }
}