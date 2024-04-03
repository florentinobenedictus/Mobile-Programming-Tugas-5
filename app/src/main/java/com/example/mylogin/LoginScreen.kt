package com.example.mylogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = R.drawable.icon_login),
            contentDescription = "Login image",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Welcome Back",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to your account")

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = "Email address")
                }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { Log.i("LoginPassword", "Email: $email | Password: $password") }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Forgot password?",
            modifier = Modifier.clickable {
                Log.i("ForgotPassword", "Forgot password clicked")
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Or sign in with")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_facebook),
                contentDescription = "Facebook Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Facebook clicked
                        Log.i("LoginFacebook", "Using Facebook login")
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.icon_github),
                contentDescription = "Github Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Github clicked
                        Log.i("LoginGithub", "Using Github login")
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.icon_twitter),
                contentDescription = "Twitter Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Twitter clicked
                        Log.i("LoginTwitter", "Using Twitter login")
                    }
            )
        }

    }
}