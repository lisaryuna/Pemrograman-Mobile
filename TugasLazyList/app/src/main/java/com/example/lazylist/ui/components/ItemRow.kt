package com.example.lazylist.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazylist.data.ListItem

@Composable
fun ItemRow(item: ListItem, index: Int) {
    val context = LocalContext.current
    var isChecked by remember { mutableStateOf(false) }
    val backgroundColor = if (index % 2 == 1) Color(0xFFE8F5E9) else Color.White

    Card(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFEAEAEA)),
        colors = CardDefaults.cardColors(backgroundColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(Color(0xFFD3D3D3)),
                modifier = Modifier.size(60.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Gambar\n${item.id}",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
            }

            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = item.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }

            Spacer(Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.End) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = { checked ->
                        isChecked = checked
                        if (checked) {
                            Toast.makeText(context, "Switch hidup pada item \${item.id}", Toast.LENGTH_SHORT).show()
                        }
                    }
                )

                Spacer(Modifier.width(8.dp))
                Button(onClick = {
                    Toast.makeText(context, "Tombol telah ditekan untuk tombol \${item.id}", Toast.LENGTH_SHORT).show()
                },
                    colors = ButtonDefaults.buttonColors(Color(0xFF673AB7)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical =0.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Aksi", fontSize = 12.sp)
                }
            }
        }
    }
}