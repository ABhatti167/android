package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun pfp() {

    Card(elevation = 10.dp, modifier = Modifier
        .fillMaxSize()
        .padding(top = 70.dp, bottom = 100.dp, end = 10.dp, start = 10.dp)
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp).verticalScroll(rememberScrollState())) {
            Image(painter = painterResource(id = R.drawable.cat),
                contentDescription = "cat",

                modifier = Modifier
                    .size(height = 150.dp, width = 150.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.Red, shape = CircleShape),
                contentScale = ContentScale.Crop
            )


            Text(text = "Wild Cat")
            Text(text = "From Canada")

            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                stats("150", "Followers")
                stats("33330", "views")

            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Button(onClick = {}) {
                    Text(text = "Follow Me!")
                }
                Button(onClick = {}) {
                    Text(text = "Friend Request")
                }
            }
        }
    }
}

@Composable
fun stats(count: String, statss: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = statss)
    }
}
@Preview(showBackground = false)
@Composable
fun view() {
    pfp()
}