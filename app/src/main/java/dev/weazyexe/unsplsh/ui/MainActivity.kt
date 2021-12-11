package dev.weazyexe.unsplsh.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dev.weazyexe.unsplsh.ui.screen.main.MainScreen
import dev.weazyexe.unsplsh.ui.theme.UnsplshTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplshTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_3A,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    UnsplshTheme {
        Greeting("Android")
    }
}