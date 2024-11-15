package com.fabianospdev.petscare.presenter.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.petscare.R
import com.fabianospdev.petscare.montserratFamily
import com.fabianospdev.petscare.presenter.ui.theme.AppTheme

@Composable
fun LoginScreen(navController: NavHostController, name: String){
    val context = LocalContext.current

    var username by remember { mutableStateOf(value =  "") }
    var password by remember { mutableStateOf(value = "") }
    var showPassword by remember { mutableStateOf(value = false) }
    var isUserNameEmpty by remember { mutableStateOf(value = username.isEmpty()) }
    val fingerprint = android.os.Build.FINGERPRINT

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = "logo",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Login",
                fontSize = 26.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = MaterialTheme.colorScheme.primary),
            )
            Spacer(modifier = Modifier.height(3.dp))
            TextField(
                value = username,
                onValueChange = {
                    username = it
                    isUserNameEmpty = it.isEmpty()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                shape = RoundedCornerShape(25),
                modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 1.dp)
                    .border(2.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp)),
                placeholder = {
                    Text(
                        "email@email.com",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f), // Cor do placeholder
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        maxLines = 1
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    errorTextColor = MaterialTheme.colorScheme.error,
                    focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorContainerColor = MaterialTheme.colorScheme.errorContainer,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorIndicatorColor = MaterialTheme.colorScheme.error,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    errorCursorColor = MaterialTheme.colorScheme.error,
                    focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorLeadingIconColor = MaterialTheme.colorScheme.error,
                    focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorTrailingIconColor = MaterialTheme.colorScheme.error,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorLabelColor = MaterialTheme.colorScheme.error,
                    focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorPlaceholderColor = MaterialTheme.colorScheme.error,
                    focusedSupportingTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedSupportingTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledSupportingTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorSupportingTextColor = MaterialTheme.colorScheme.error,
                    focusedPrefixColor = MaterialTheme.colorScheme.primary,
                    unfocusedPrefixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledPrefixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorPrefixColor = MaterialTheme.colorScheme.error,
                    focusedSuffixColor = MaterialTheme.colorScheme.primary,
                    unfocusedSuffixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledSuffixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorSuffixColor = MaterialTheme.colorScheme.error
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(3.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.None
                ),
                shape = RoundedCornerShape(25),
                modifier = Modifier.padding(20.dp, 3.dp, 20.dp, 20.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp)),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    errorTextColor = MaterialTheme.colorScheme.error,
                    focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorContainerColor = MaterialTheme.colorScheme.errorContainer,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorIndicatorColor = MaterialTheme.colorScheme.error,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    errorCursorColor = MaterialTheme.colorScheme.error,
                    focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorLeadingIconColor = MaterialTheme.colorScheme.error,
                    focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorTrailingIconColor = MaterialTheme.colorScheme.error,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorLabelColor = MaterialTheme.colorScheme.error,
                    focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorPlaceholderColor = MaterialTheme.colorScheme.error,
                    focusedSupportingTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedSupportingTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledSupportingTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorSupportingTextColor = MaterialTheme.colorScheme.error,
                    focusedPrefixColor = MaterialTheme.colorScheme.primary,
                    unfocusedPrefixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledPrefixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorPrefixColor = MaterialTheme.colorScheme.error,
                    focusedSuffixColor = MaterialTheme.colorScheme.primary,
                    unfocusedSuffixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledSuffixColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    errorSuffixColor = MaterialTheme.colorScheme.error
                ),
                placeholder = {
                    Text(
                        text = "Q@nm#44u",
                        fontSize = 16.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.Normal,
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        ),
                        maxLines = 1
                    )
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Password Icon")
                },
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        val icon: ImageVector = if (showPassword) {
                            ImageVector.vectorResource(R.drawable.baseline_visibility_off_24)
                        } else {
                            ImageVector.vectorResource(id = R.drawable.baseline_remove_red_eye_24)
                        }
                        Icon(
                            imageVector = icon,
                            contentDescription = if (showPassword) "Hide Password" else "Show Password",
                            tint = Color.Gray
                        )
                    }
                },
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(route = "Home") },
                enabled = true,
                interactionSource = remember { MutableInteractionSource() },
                border = BorderStroke(1.dp, color = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified
                ),
                contentPadding = ButtonDefaults.ContentPadding
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview(
    name =  "login screen",
    group = "auth",
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DefaultLogin() {
    AppTheme {
        LoginScreen(navController = rememberNavController(), name = "Login")
    }
}