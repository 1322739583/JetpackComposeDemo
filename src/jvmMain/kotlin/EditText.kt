import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun EditText() {

    var text by remember { mutableStateOf("") }
//    var colors= Colors(primary = Color.Blue, secondary = Color.Green, background = Color.Cyan, onBackground = Color.Cyan){
//
//    }
    OutlinedTextField(
        value = text,
        enabled = true,
        onValueChange = { text = it },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFFFFFF),
            textColor = Color.Gray,//主文本颜色
            disabledTextColor = Color.Green,//enabled属性为false的时候主文本的颜色
            focusedIndicatorColor = Color.Yellow,//有焦点时候下划线的颜色
            unfocusedIndicatorColor = Color.Yellow,//没焦点时候下划线的颜色
            cursorColor = Color.Yellow,//光标颜色
            disabledIndicatorColor = Color.Red,//禁用状态下划线的颜色
            disabledLabelColor = Color.Red,//禁用状态Lable的颜色
        ), label = {
            Text("name")
        }, placeholder = {
            Text(text = "enter name here")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
        },
        singleLine = true
    )

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        EditText()
    }
}