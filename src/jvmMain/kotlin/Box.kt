import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun BoxUI() {

    Box( contentAlignment = Alignment.Center){
        Text(text = "text1", modifier = Modifier.background(Color.Yellow).size(200.dp,200.dp))
        Text(text = "text2",modifier = Modifier.background(Color.Green).size(100.dp,100.dp))
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        BoxUI()
    }
}
