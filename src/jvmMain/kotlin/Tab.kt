import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application

@Composable
fun TabUI() {
    var tabSelected = remember { mutableStateOf(false) }
    var tabIndex = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = tabIndex.value,
        modifier = Modifier.height(50.dp),
        tabs = {

            Tab(selected = tabIndex.value == 0, onClick = {
                tabSelected.value = true
                tabIndex.value = 0
            }) {
                Text("Item1")
            }
            Tab(selected = tabIndex.value == 1, onClick = {
                tabSelected.value = true
                tabIndex.value = 1
            }) {
                Text("Item2")
            }
            Tab(selected = tabIndex.value == 2, onClick = {
                tabSelected.value = true
                tabIndex.value = 2
            }) {
                Text("Item3")
            }
            Tab(selected = tabIndex.value == 3, onClick = {
                tabSelected.value = true
                tabIndex.value = 3
            }) {
                Text("Item4")
            }

        }
    )

//        ) {
//        Tab(selected = tabIndex.value == 0, onClick = {
//            tabSelected.value = true
//            tabIndex.value = 0
//        }) {
//            Text("Item1")
//        }
//        Tab(selected = tabIndex.value == 1, onClick = {
//            tabSelected.value = true
//            tabIndex.value = 1
//        }) {
//            Text("Item2")
//        }
//        Tab(selected = tabIndex.value == 2, onClick = {
//            tabSelected.value = true
//            tabIndex.value = 2
//        }) {
//            Text("Item3")
//        }
//        Tab(selected = tabIndex.value == 3, onClick = {
//            tabSelected.value = true
//            tabIndex.value = 3
//        }) {
//            Text("Item4")
//        }
//
//
//    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        TabUI()
    }
}
