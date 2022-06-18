import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun ScaffoldUI2() {

    Scaffold(
        bottomBar = {
             BottomAppBar(contentColor = Color.Yellow, backgroundColor = Color(0xffcc00ff)) {
                 Row(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)){
                     IconButton(onClick = {}) {
                         Column(horizontalAlignment = Alignment.CenterHorizontally ) {
                             Text("主页" , fontWeight = FontWeight.Bold)
                             Icon(imageVector = Icons.Default.Home , contentDescription = "主页")
                         }
                     }

                     IconButton(onClick = {}, modifier = Modifier.padding(50.dp,0.dp,50.dp,0.dp)) {
                         Column(horizontalAlignment = Alignment.CenterHorizontally ) {
                             Text("发现" ,fontWeight = FontWeight.Bold)
                             Icon(imageVector = Icons.Default.Search , contentDescription = "发现")
                         }
                     }



                     IconButton(  onClick = {}) {
                         Column(horizontalAlignment = Alignment.CenterHorizontally ) {
                             Text("设置" ,fontWeight = FontWeight.Bold)
                             Icon(imageVector = Icons.Default.Settings , contentDescription = "设置")
                         }
                     }

                 }

             }

        }
    ) {

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        ScaffoldUI2()
    }
}
