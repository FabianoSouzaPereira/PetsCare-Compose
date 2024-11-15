package com.fabianospdev.petscare.presenter.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.petscare.R
import com.fabianospdev.petscare.presenter.ui.theme.AppTheme
import com.fabianospdev.petscare.presenter.ui.utils.LoadFontsFamily.montserratFamily

@Composable
fun HomeScreen(navController: NavHostController, name: String){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.home_screen),
                fontSize = 26.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = MaterialTheme.colorScheme.primary)
            )
        }
    }
}


@Preview(
    name =  "Home Screen",
    group = "auth",
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DefaultLogin() {
    AppTheme {
        HomeScreen(navController = rememberNavController(), name = stringResource(R.string.home))
    }
}