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
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.ui.theme.MAE_TaekwonifyTheme
import com.example.mae_taekwonify.viewModel.RegisterTeamManagerViewModel
import com.example.mae_taekwonify.widgets.CustomOutlinedTextField
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
                CustomOutlinedTextField(
                    value = name,
                    onValueChangeFun = {name = it},
                    showError = !validateName,
                    labelText = "Enter Team Manager Name",
                    errorMessage = validateNameError,
                    leadingIconImageVector = Icons.Default.PermIdentity,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                CustomOutlinedTextField(
                    value = teamName,
                    onValueChangeFun = {teamName = it},
                    showError = !validateTeamName,
                    labelText = "Enter Team Name",
                    errorMessage = validateNameError,
                    leadingIconImageVector = Icons.Default.PermIdentity,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                CustomOutlinedTextField(
                    value = email,
                    onValueChangeFun = {email = it},
                    showError = !validateEmail,
                    labelText = "Enter Email",
                    errorMessage = validateNameError,
                    leadingIconImageVector = Icons.Default.AlternateEmail,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                CustomOutlinedTextField(
                    value = phone,
                    onValueChangeFun = {phone = it},
                    showError = !validatePhone,
                    labelText = "Enter Contact Number",
                    errorMessage = validateNameError,
                    leadingIconImageVector = Icons.Default.Phone,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )

                CustomOutlinedTextField(
                    value = password,
                    onValueChangeFun = {password = it},
                    showError = !validatePassword,
                    labelText = "Enter password",
                    errorMessage = validateNameError,
                    leadingIconImageVector = Icons.Default.Password,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
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