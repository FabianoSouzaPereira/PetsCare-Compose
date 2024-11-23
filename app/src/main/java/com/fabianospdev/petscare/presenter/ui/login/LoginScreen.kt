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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.petscare.R
import com.fabianospdev.petscare.presenter.ui.theme.AppTheme
import com.fabianospdev.petscare.presenter.ui.utils.LoadFontsFamily
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
    name: String
) {
    val state by viewModel.state.observeAsState(LoginState.Idle)
    val context = LocalContext.current

    /** Observing the ViewModel state **/
    val username by remember { viewModel.username }
    val password by remember { viewModel.password }

    /** Field validation (calculated in a derived way) **/
    val isUserNameEmpty by remember { viewModel.isUserNameEmpty }
    val isPasswordEmpty by remember { viewModel.isPasswordEmpty }
    val isFormValid by remember { viewModel.isFormValid }

    val showPassword = remember { mutableStateOf(value = false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val showRetryLimitReached by viewModel.showRetryLimitReached.collectAsState()
    var showPopup by remember { mutableStateOf(false) }
    val gradient = Brush.linearGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.secondary
        )
    )

    if (showRetryLimitReached && !showPopup) {
        showPopup = true
        viewModel.resetRetryLimitNotification()
    }

    if (showPopup) {
        ShowPopup(
            viewModel = viewModel,
            message = stringResource(R.string.attempt_limit_reached),
            onDismiss = { showPopup = false },
            imageResId = R.mipmap.ic_launcher_foreground
        )
        viewModel.resetState()
    }

    when (state) {
        is LoginState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is LoginState.Idle -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.onSurface,
                tonalElevation = 5.dp
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = gradient)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
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
                                viewModel.username.value = it
                            },
                            label = { Text(stringResource(R.string.email)) },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusRequester.requestFocus()
                                }
                            ),
                            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                            shape = RoundedCornerShape(25),
                            modifier = Modifier
                                .padding(20.dp, 20.dp, 20.dp, 1.dp)
                                .border(
                                    dimensionResource(R.dimen.textfield_border_size),
                                    MaterialTheme.colorScheme.onPrimary,
                                    shape = RoundedCornerShape(dimensionResource(R.dimen.textfield_rounded_corner_shape))
                                )
                                .clip(RoundedCornerShape(dimensionResource(R.dimen.textfield_rounded_corner_shape)))
                                .focusRequester(focusRequester),
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.email_email_com),
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
                        TextField(
                            value = password,
                            onValueChange = {
                                viewModel.password.value = it
                            },
                            label = { Text(stringResource(R.string.password)) },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    keyboardController?.hide()
                                }
                            ),
                            visualTransformation = if (showPassword.value) VisualTransformation.None else
                                PasswordVisualTransformation(),
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.None
                            ),
                            shape = RoundedCornerShape(25),
                            modifier = Modifier
                                .padding(20.dp, 6.dp, 20.dp, 20.dp)
                                .border(
                                    dimensionResource(R.dimen.textfield_border_size),
                                    MaterialTheme.colorScheme.onPrimary,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clip(RoundedCornerShape(16.dp))
                                .focusRequester(focusRequester),
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
                                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                                    val icon: ImageVector = if (showPassword.value) {
                                        ImageVector.vectorResource(id = R.drawable.baseline_remove_red_eye_24)
                                    } else {
                                        ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24)
                                    }
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = if (showPassword.value) stringResource(id = R.string.hide_password) else
                                            stringResource(id = R.string.show_password),
                                        tint = if (showPassword.value) Color.Blue else Color.Gray
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
                            enabled = isFormValid,
                            interactionSource = remember { MutableInteractionSource() },
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                            shape = MaterialTheme.shapes.large,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary,
                                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                                disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            modifier = Modifier
                                .width(dimensionResource(R.dimen.button_width_medium))
                                .padding(dimensionResource(R.dimen.button_padding))
                                .clip(RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape)))
                                .background(
                                    brush = if (!isFormValid) Brush.verticalGradient(
                                        listOf(
                                            MaterialTheme.colorScheme.surfaceVariant,
                                            MaterialTheme.colorScheme.surfaceVariant)) else gradient)
                                .border(
                                    BorderStroke(
                                        width = dimensionResource(R.dimen.button_border_size),
                                        color = if(!isFormValid) MaterialTheme.colorScheme.outlineVariant else
                                            MaterialTheme.colorScheme.onPrimary
                                    ),
                                    shape = RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape))
                                ),
                            contentPadding = ButtonDefaults.ContentPadding
                        ) {
                            Text(
                                text = context.getString(R.string.login),
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                color = if(!isFormValid) MaterialTheme.colorScheme.outline else
                                    MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }
        is LoginState.Success -> {
            LaunchedEffect(Unit){
                navController.navigate(route = context.getString(R.string.home))
            }
        }
        is LoginState.Error -> {
            val errorMessage = when ((state as LoginState.Error).error) {
                LoginPresenterError.UserNotFound.toString() -> LoginPresenterError.UserNotFound.message
                LoginPresenterError.LoginFailed.toString() -> LoginPresenterError.LoginFailed.message
                else -> LoginPresenterError.UnknownError.message
            }

            ShowRetryButton(viewModel = viewModel, errorMessage = errorMessage,gradient = gradient, onRetry = {
                viewModel.login(username, password)
            })
        }
        is LoginState.NoConnection -> {
            ShowRetryButton(
                viewModel = viewModel,
                errorMessage = (state as LoginState.NoConnection).errorMessage,
                gradient = gradient,
                onRetry = {  viewModel.login(username, password) }
            )
        }
        is LoginState.TimeoutError -> {
            ShowRetryButton(
                viewModel = viewModel,
                errorMessage = (state as LoginState.TimeoutError).message,
                gradient = gradient,
                onRetry = { viewModel.login(username, password) }
            )
        }
        is LoginState.Unauthorized -> {
            ShowSnackBarMessage(snackbarHostState, (state as LoginState.Unauthorized).message)
            ShowRetryButton(
                viewModel = viewModel,
                errorMessage = (state as LoginState.Unauthorized).message,
                gradient = gradient,
                onRetry = { viewModel.login(username, password) }
            )
        }
        is LoginState.ValidationError -> {
            ShowSnackBarMessage(snackbarHostState, (state as LoginState.ValidationError).message)
            HighlightInvalidFields()
        }
    }
}


@Composable
fun HighlightInvalidFields() {
    TODO("Not yet implemented")
}

@Composable
fun ShowToastMessage(message: String) {
    val context = LocalContext.current
    LaunchedEffect(message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun ShowSnackBarMessage(snackbarHostState: SnackbarHostState, message: String) {
    LaunchedEffect(message) {
        snackbarHostState.showSnackbar(message)
    }
}

@Composable
fun ShowTextViewMessage(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.error
            )
        )
    }
}

@Composable
fun ShowDialog(message: String, gradient: Brush, onDismiss: () -> Unit){
    AlertDialog(
        modifier = Modifier
            .size(width = 300.dp, height = 300.dp)
            .clip(RoundedCornerShape(dimensionResource(R.dimen.alert_clip_rounded_corner_shape)))
            .background(gradient)
            .border(
                BorderStroke(
                    width = dimensionResource(R.dimen.alert_border_border_stroke),
                    color = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(22.dp)
            ),
        onDismissRequest = onDismiss,
        title = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Something went wrong",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error,
                    fontStyle = FontStyle.Normal
                )
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.alert_border_verticalArrangement))
            ) {
                Text(
                    text = "The following error occurred:",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 18.sp
                )
                Text(
                    text = message,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 22.sp
                )
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Row {
                    Button(
                        onClick = {
                            onDismiss()
                        },
                        modifier = Modifier
                            .width(dimensionResource(R.dimen.button_width_small))
                            .clip(RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape)))
                            .background(gradient)
                            .border(
                                BorderStroke(
                                    width = dimensionResource(R.dimen.button_border_size),
                                    color = MaterialTheme.colorScheme.onPrimary
                                ),
                                shape = RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape))
                            ),
                    ) {
                        Text("Ok")
                    }
                }
            }
        },
        tonalElevation = 5.dp,
    )
}


@Composable
fun ShowRetryButton(
    viewModel: LoginViewModel,
    errorMessage: String,
    gradient: Brush,
    onRetry: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color =  MaterialTheme.colorScheme.onSurfaceVariant,
        tonalElevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .padding(16.dp)
            ) {
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    ),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.onTertiary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.something_wrong),
                            fontSize = with(LocalDensity.current) {
                                dimensionResource(id = R.dimen.title_font_text_size).value.sp
                            },
                            fontFamily = LoadFontsFamily.karlaFamily,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onError,
                            fontStyle = FontStyle.Normal,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = stringResource(R.string.the_problem_reported_was, errorMessage))
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(text = stringResource(R.string.please_try_again_later_but_if_the_problem_persists_report_the_problem_to_your_service_provider))
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .height(80.dp)
            ) {
                Button(
                    onClick = onRetry,
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_width_medium))
                        .align(Alignment.BottomCenter)
                        .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 0.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape)))
                        .background(MaterialTheme.colorScheme.primary)
                        .border(
                            BorderStroke(
                                width = dimensionResource(R.dimen.button_border_size),
                                color = MaterialTheme.colorScheme.onPrimary
                            ),
                            shape = RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape))
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = stringResource(R.string.try_again),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 50.dp)
                    .align(Alignment.CenterHorizontally)
                    .height(80.dp)
            ) {
                Button(
                    onClick = {
                        viewModel.clearInputFields()
                        viewModel.resetState()
                    },
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_width_medium))
                        .align(Alignment.BottomCenter)
                        .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 16.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape)))
                        .background(MaterialTheme.colorScheme.secondary)
                        .border(
                            BorderStroke(
                                width = dimensionResource(R.dimen.button_border_size),
                                color = MaterialTheme.colorScheme.onSecondary
                            ),
                            shape = RoundedCornerShape(dimensionResource(R.dimen.button_rounded_corner_shape))
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text(
                        text = "Cancel",
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}


@Composable
fun ShowPopup(
    viewModel: LoginViewModel,
    message: String,
    onDismiss: () -> Unit,
    imageResId: Int
) {
    Popup(
        alignment = Alignment.Center,
        onDismissRequest = onDismiss
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            modifier = Modifier
                .padding(32.dp)
                .width(320.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(24.dp)
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Popup Image",
                    modifier = Modifier
                        .size(160.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = message,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleLarge,
                        color =  MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                LaunchedEffect(Unit) {
                    delay(3000)
                    viewModel.clearInputFields()
                    onDismiss()
                }
            }
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
    /** This preview uses a ViewModel. ViewModels often trigger operations not supported by Compose Preview,
     * such as database access, I/ O operations, or network requests. You can read more about preview limitations
     * in our external documentation.
     */
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.onSurface,
            tonalElevation = 5.dp
        ) {
            LoginScreen(navController = rememberNavController(), name = stringResource(R.string.login))
        }
    }
}
