package com.example.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazylist.data.ListItem
import com.example.lazylist.ui.screen.MainScreen
import com.example.lazylist.ui.theme.LazylistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataList = listOf(
            ListItem(1, "Item Pertama", "Deskripsi item kesatu"),
            ListItem(2, "Item Kedua", "Deskripsi item kedua"),
            ListItem(3, "Item Ketiga", "Deskripsi item ketiga"),
            ListItem(4, "Item Keempat", "Deskripsi item keempat"),
            ListItem(5, "Item Kelima", "Deskripsi item kelima")
        )

        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen(itemList = dataList)
                }
            }
        }
    }
}

