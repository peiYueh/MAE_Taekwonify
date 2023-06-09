package com.example.mae_taekwonify.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mae_taekwonify.nav.Routes
import com.example.mae_taekwonify.R
import com.example.mae_taekwonify.viewModel.LoginViewModel
import com.example.mae_taekwonify.widgets.CustomDialogClose
import com.example.mae_taekwonify.widgets.CustomTopBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TeamManagerLogin(navController: NavHostController, vm: LoginViewModel = viewModel()){
    val scope = rememberCoroutineScope()
    var showPassword by rememberSaveable { mutableStateOf(false) }
    var showLoginError by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Team Manager Login",
                showBackIcon = true,
            )
        }){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(modifier = Modifier
                .padding(bottom = 10.dp),){
                Text(
                    text = "Team Manager Login",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
                Text(
                    text = "Team Manager Login",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 3.dp),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 40.dp,
                    alignment = Alignment.CenterVertically
                ),
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary, shape = MaterialTheme.shapes.large)
                    .height(280.dp)
                    .width(350.dp)
                    .padding(top = 20.dp),
            ){
                TextField(
                    value = vm.email,
                    onValueChange = {
                        vm.email = it
                    },
                    label = { Text(text = stringResource(R.string.email_label)) },
                    placeholder = { Text(text = "Email") },
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .layoutId("email_text"),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1
                )
                TextField(
                    value = vm.password,
                    onValueChange = {
                        vm.password = it
                    },
                    singleLine = true,
                    label = { Text(text = "Enter password") },
                    placeholder = { Text(text = "Password") },
                    textStyle = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .layoutId("password_text"),
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
                        scope.launch {
                            isLoading = true
                            val data = vm.logInWithEmail()
                            if(data!= null) {
                                navController.navigate(Routes.Homepage.route)
                            } else {
                                showLoginError = true
                            }
                            isLoading = false
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onBackground)
                ) {
                    Text(text = "Login")
                }
            }
            ClickableText(
                text = AnnotatedString("Register for a team"),
                onClick = {
                    navController.navigate(Routes.TeamManagerSignUp.route)
                },
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.taekwondo_img),
                contentDescription = stringResource(id = com.example.mae_taekwonify.R.string.taekwondo_img),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(300.dp)
                    .align(alignment = Alignment.End)
            )
            if (showLoginError) {
                CustomDialogClose(
                    alertTitle = stringResource(id = R.string.login_error_header),
                    alertBody = stringResource(id = R.string.login_error_desc),
                    onDismissFun = { showLoginError = false },
                    btnCloseClick = { showLoginError = false }
                )
            }
        }
    }
}

