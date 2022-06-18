import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.window.Window
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application

/**
 * 在1.2.0-alpha05 版本LazyVerticalGrid已经是稳定版本，
 * LazyHorizontalGrid在最新的版本已经不见了，只有LazyVerticalGrid了？
 *
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerColunmUI() {
    val itemModifier = Modifier.border(1.dp, Color.Blue).width(100.dp).height(100.dp).wrapContentSize()

    Column {
        LazyVerticalGrid(cells = GridCells.Fixed(7)) {
            items(7) {
                Text("星期$it", itemModifier)
            }
        }
        LazyVerticalGrid(cells = GridCells.Fixed(7)) {
            items(31) {
                Text(" ${it + 1}", itemModifier)
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        LazyVerColunmUI()
    }
}





