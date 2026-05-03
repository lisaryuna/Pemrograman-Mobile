package com.example.tugaslayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen()
        }
    }
}

@Composable
fun DetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
            .padding(20.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color(0xFF123456))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Title",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = "Sub-Title",
                    fontSize = 14.sp,
                    color = Color.Black
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating Star",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "9.23",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tes 1234567890. 2410817220012. pacar bina . bladhfafhasfhaifhiaweiweaifkjanfkjasnfkasifheurfhdyainyunah Lorem Ipsum Lorem Ipsum. Tes 1234567890. 2410817220012. bladhfafhasfhaifhiaweiweaifkjanfkjasnfkasifheurfhdyainyunah Lorem Ipsum Lorem Ipsum. Tes 1234567890. 2410817220012. bladhfafhasfhaifhiaweiweaifkjanfkjasnfkasifheurfhdyainyunah Lorem Ipsum Lorem Ipsum. Tes 1234567890. 2410817220012. bladhfafhasfhaifhiaweiweaifkjanfkjasnfkasifheurfhdyainyunah Lorem Ipsum Lorem Ipsum. Tes 1234567890. 2410817220012. bladhfafhasfhaifhiaweiweaifkjanfkjasnfkasifheurfhdyainyunah Lorem Ipsum Lorem Ipsum. Tes 1234567890. 2410817220012. bladhfafhasfhaifhiaweiweaifkjanfkjasnfkasifheurfhdyainyunah Lorem Ipsum Lorem Ipsum",
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A78D0)),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Like", color = Color.White)
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE55353)),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Dislike", color = Color.White)
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF50B86C))
            ) {
                Text("Share", color = Color.White)
            }
        }
    }
}