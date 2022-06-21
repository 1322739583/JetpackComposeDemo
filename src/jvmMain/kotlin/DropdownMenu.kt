import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.mouseClickable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.*
import java.awt.SystemColor.menu

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DropdownMenuUI() {
  //  var expanded = remember { mutableStateOf(false) }

    //   val iconButton = @Composable {
//        IconButton(onClick = { expanded.value = true }) {
//            Icon(Icons.Default.MoreVert,contentDescription = null)
//        }
    //  }


//    val menuTextSize = 20.sp
//    Text(text = "文件", fontSize = menuTextSize, modifier = Modifier.clickable { expanded.value = !expanded.value })
//
//    DropdownMenu(
//        expanded = expanded.value,
//        onDismissRequest = { expanded.value = false },
//    ) {
//        DropdownMenuItem(onClick = { }) {
//            Text("保存", fontSize = menuTextSize)
//        }
//        DropdownMenuItem(onClick = { }) {
//            Text("导出", fontSize = menuTextSize)
//        }
//        DropdownMenuItem(onClick = { }) {
//            Text("退出", fontSize = menuTextSize)
//        }
//    }

//    DropdownMenu(
//        expanded = expanded.value,
//        onDismissRequest = { expanded.value = false },
//        modifier = Modifier.clip(shape = RectangleShape)
//    ) {
//
//        Text("保存", modifier = Modifier.height(20.dp).width(100.dp), fontSize = menuTextSize)
//
//
//        Text("导出", fontSize = menuTextSize)
//
//
//        Text("退出", fontSize = menuTextSize)
//
//    }


    var expanded by remember { mutableStateOf(false) }
    Box(
        Modifier
            .fillMaxSize()
            .mouseClickable {
                if (buttons.isSecondaryPressed) {
                    expanded = true
                }
            }
    )


// tmp fix for https://github.com/JetBrains/compose-jb/issues/2012
    var renderCount by remember { mutableStateOf(0) }
    listOf(renderCount, renderCount - 1).forEach { renderId ->
        val isActive = renderId == renderCount
        key(renderId) {
            CursorDropdownMenu(
                expanded = expanded && isActive,
                onDismissRequest = {
                    if (isActive) {
                        renderCount += 1
                        expanded = false
                    }
                },
            ) {
                DropdownMenuItem({}) {
                    Text("First item")
                }
                DropdownMenuItem({}) {
                    Text("Second item")
                }
            }
        }
    }

}

fun main() = application {


    Window(onCloseRequest = ::exitApplication) {
        DropdownMenuUI()
    }
}
