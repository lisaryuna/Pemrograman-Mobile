package com.example.tugasmobileapi

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    val message: String,
    val code: String,
    val data: T
)

@JsonClass(generateAdapter = true)
data class MyData(
    val id: String,
    val name: String
)

class MainActivity : AppCompatActivity() {
    private val client = HttpClient(Android)
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvApiResult = findViewById<TextView>(R.id.tvApiResult)
        val apiUrl = "https://tugaslisa.free.beeceptor.com/data"

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val responseString = client.get(apiUrl).bodyAsText()
                val type = Types.newParameterizedType(ApiResponse::class.java, MyData::class.java)
                val adapter: JsonAdapter<ApiResponse<MyData>> = moshi.adapter(type)
                val parsedData = adapter.fromJson(responseString)

                withContext(Dispatchers.Main) {
                    if (parsedData != null) {
                        val textView = """
                            Status API: ${parsedData.message} (Code: ${parsedData.code})
                            
                            Isi Data:
                            ID: ${parsedData.data.id}
                            Nama: ${parsedData.data.name}
                        """.trimIndent()

                        tvApiResult.text = textView
                    } else {
                        tvApiResult.text = "Data Kosong"
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    tvApiResult.text = "Error, ${e.localizedMessage}"
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        client.close()
    }
}