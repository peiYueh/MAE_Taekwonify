package com.example.mae_taekwonify.widgets

import android.content.ClipDescription
import android.opengl.Visibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat.FocusDirection
import com.example.mae_taekwonify.R
import com.google.common.cache.AbstractLoadingCache
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable

fun CustomOutlinedTextField(
    value: String,
    onValueChangeFun: (String) -> Unit,
    labelText: String,
    isPasswordField: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityChange: (Boolean) -> Unit = {},
    leadingIconImageVector: ImageVector,
    leadingIconDescription: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    showError: Boolean = false,
    errorMessage: String = ""
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChangeFun,
            modifier = Modifier.padding(bottom = 10.dp),
            label = { Text(text = labelText) },
            singleLine = true,
            textStyle = MaterialTheme.typography.button,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colors.primary,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(60.dp),
            leadingIcon = {
                Icon(
                    imageVector = leadingIconImageVector,
                    contentDescription = leadingIconDescription,
                    tint = if (showError) MaterialTheme.colors.error else MaterialTheme.colors.primary
                )
            },
            isError = showError,
            trailingIcon = {
                if (showError && !isPasswordField) Icon(imageVector = Icons.Filled.Error, contentDescription = stringResource(
                    id = R.string.error_icon))

                if(isPasswordField){
                    IconButton(onClick = { onVisibilityChange(!isPasswordVisible) }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = stringResource(R.string.password_hint )
                        )
                        
                    }
                }
            },
            visualTransformation = when {
                isPasswordField && isPasswordVisible -> VisualTransformation.None
                isPasswordField -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            keyboardOptions = keyboardOptions,
        )
        if(showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 8.dp).offset(y = (-10).dp).align(Alignment.CenterHorizontally)
            )
        }
    }

}
