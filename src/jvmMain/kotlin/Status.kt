import androidx.compose.desktop.DesktopTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun Status() {

    var text by remember { mutableStateOf("Tom") }

    //var text = remember { mutableStateOf("") }
    //var (text, setValue) = remember { mutableStateOf("") }



    MaterialTheme {


        Column() {
            if (text.isNotEmpty()) {
                Text(text = "Hello , $text")
            }
            TextField(
                value = "",
                onValueChange = { text = it },
                label = { Text("Name") }
            )

        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Status()
    }
}