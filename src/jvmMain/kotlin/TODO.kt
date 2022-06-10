import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun TODO() {

    //  val states by remember { mutableStateListOf("","") }

    var taskText by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Card(modifier = Modifier.padding(15.dp, 5.dp, 20.dp, 0.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(Color(0xffffffcc)).fillMaxWidth()
            ) {

                TextField(

                    value = taskText,
                    placeholder = {
                        Text(text = "添加任务")
                    },
                    onValueChange = {
                        taskText = it
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                    modifier = Modifier.fillMaxWidth().onKeyEvent {
                        if(it.key== Key.Enter){
                            println("Enter")

                        }

                        true
                    }
                )
            }
        }

        Card(modifier = Modifier.padding(15.dp, 5.dp, 20.dp, 0.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(Color(0xffffffcc)).fillMaxWidth()
            ) {
                Checkbox(checked = false, onCheckedChange = {})
                Text(text = "读书")
            }
        }

        Card(modifier = Modifier.padding(15.dp, 5.dp, 20.dp, 0.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(Color(0xffffffcc)).fillMaxWidth()
            ) {
                Checkbox(checked = false, onCheckedChange = {})
                Text(text = "运动")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        TODO()
    }
}