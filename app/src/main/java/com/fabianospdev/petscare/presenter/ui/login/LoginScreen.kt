package com.fabianospdev.petscare.presenter.ui.login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.petscare.R
import com.fabianospdev.petscare.presenter.ui.theme.AppTheme
import com.fabianospdev.petscare.presenter.ui.utils.LoadFontsFamily
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
    name: String
) {
    val state by viewModel.state.observeAsState(LoginState.Loading)
    val context = LocalContext.current

    var username by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var showPassword by remember { mutableStateOf(value = true) }
    var isUserNameEmpty by remember { mutableStateOf(value = username.isEmpty()) }
    var isPasswordEmpty by remember { mutableStateOf(value = password.isEmpty()) }

    val gradient = Brush.linearGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.secondary
        )
    )

    when (state) {
        is LoginState.Loading -> {
            CircularProgressIndicator()
        }

        is LoginState.Success -> {

            /** Navigation to Home is login success */
            LaunchedEffect(Unit) {
                navController.navigate(route = context.getString(R.string.home))
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.onSurface,
                tonalElevation = 5.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = gradient)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                            contentDescription = "logo",
                            modifier = Modifier.size(200.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(R.string.login),
                            fontSize = with(LocalDensity.current) {
                                dimensionResource(id = R.dimen.title_font_text_size).value.sp
                            },
                            fontFamily = LoadFontsFamily.karlaFamily,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontStyle = FontStyle.Normal
                        )
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.minium_space_betwing_elements)))
                        TextField(
                            value = username,
                            onValueChange = {
                                username = it
                                isUserNameEmpty = it.isEmpty()
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                            shape = RoundedCornerShape(25),
                            modifier = Modifier
                                .padding(20.dp, 20.dp, 20.dp, 1.dp)
                                .border(
                                    dimensionResource(R.dimen.textfield_border_size),
                                    MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(dimensionResource(R.dimen.textfield_rounded_corner_shape))
                                )
                                .clip(RoundedCornerShape(dimensionResource(R.dimen.textfield_rounded_corner_shape))),
                            placeholder = {
                                Text(
                                    stringResource(R.string.email_email_com),
                                    style = TextStyle(
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
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
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.minium_space_betwing_elements)))
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
                            modifier = Modifier
                                .padding(20.dp, 3.dp, 20.dp, 20.dp)
                                .border(
                                    dimensionResource(R.dimen.textfield_border_size),
                                    MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(16.dp)
                                )
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
                                    text = stringResource(R.string.q_nm_44u),
                                    fontSize = 16.sp,
                                    fontFamily = LoadFontsFamily.montserratFamily,
                                    fontWeight = FontWeight.Normal,
                                    style = LocalTextStyle.current.copy(
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                                    ),
                                    maxLines = 1
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = stringResource(R.string.password_icon),
                                    tint = if (isPasswordEmpty) Color.Gray else Color.Green
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { showPassword = !showPassword }) {
                                    val icon: ImageVector = if (showPassword) {
                                        ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24)
                                    } else {
                                        ImageVector.vectorResource(id = R.drawable.baseline_remove_red_eye_24)
                                    }
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = if (showPassword) stringResource(id = R.string.hide_password) else
                                            stringResource(
                                                id = R.string.show_password
                                            ),
                                    )
                                }
                            },
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                viewModel.login(username, password)
                            },
                            enabled = true,
                            interactionSource = remember { MutableInteractionSource() },
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                            shape = MaterialTheme.shapes.large,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary,
                                disabledContainerColor = Color.Unspecified,
                                disabledContentColor = Color.Unspecified
                            ),
                            modifier = Modifier
                                .width(dimensionResource(R.dimen.button_width_medium))
                                .padding(dimensionResource(R.dimen.button_padding))
                                .clip(RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape)))
                                .background(gradient)
                                .border(
                                    BorderStroke(
                                        width = dimensionResource(R.dimen.button_border_size),
                                        color = MaterialTheme.colorScheme.onPrimary
                                    ),
                                    shape = RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape))
                                ),
                            contentPadding = ButtonDefaults.ContentPadding
                        ) {
                            Text(
                                text = context.getString(R.string.login),
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }

        is LoginState.Error -> {
            val errorMessage = when ((state as LoginState.Error).error) {
                LoginPresenterError.UserNotFound.toString() -> "User not found"
                LoginPresenterError.LoginFailed.toString() -> "Login Failed"
                else -> "Unknown error"
            }

            LaunchedEffect(errorMessage) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }

            Text("Error: $errorMessage")
        }
    }
}

@Preview(
    name = "login screen",
    group = "auth",
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DefaultLogin() {
    AppTheme {
        LoginScreen(navController = rememberNavController(), name = stringResource(R.string.login))
    }
}