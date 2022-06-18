import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window

import androidx.compose.ui.window.application



@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun ColumnUI() {

    val indexs = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    println(indexs)
    val scrollState = rememberLazyListState(2)
    LazyColumn(state = scrollState) {
        indexs.forEach() {
//            ListItem(
//                icon = {
//
//                },
//                text = {
//                    Text("item  $it", modifier = Modifier.height(100.dp))
//                })
        }
    }
}



fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        ColumnUI()
    }
}
