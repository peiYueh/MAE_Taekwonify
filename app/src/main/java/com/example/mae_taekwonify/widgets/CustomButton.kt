package com.example.mae_taekwonify.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    btnText: String,
    onClickFun: () -> Unit,
    btnColor: Color
) {
    Button(
        onClick = onClickFun,
        shape = RoundedCornerShape(60.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = btnColor)
    ) {
        Text(
            text = btnText,
            color = MaterialTheme.colors.secondary
        )
    }
}

@Composable
fun CustomTextButton(
    btnText: String,
    onClickFun: () -> Unit,
) {
    TextButton(
        onClick = onClickFun,
    ) {
        Text(
            text = btnText,
            color = MaterialTheme.colors.secondary
        )
    }
}

@Composable
fun IconButton(
    onClickFun: () -> Unit,
    icon: ImageVector,
) {
    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
        Button(
            onClick =  onClickFun ,
            modifier = Modifier.size(80.dp),
            contentPadding = PaddingValues(1.dp)
        ) {
            // Inner content including an icon and a text label
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }

    }
}